package com.lawencon.ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.ticket.dao.TransactionHeaderDao;
import com.lawencon.ticket.model.Transaction;
import com.lawencon.ticket.model.TransactionDetail;
import com.lawencon.ticket.model.TransactionHeader;

@Service
@Transactional
public class TransactionHeaderServiceImpl implements TransactionHeaderService {

	@Autowired
	@Qualifier("transHeader_repo_hibernate")
	TransactionHeaderDao transHeaderDao;

	@Autowired
	TransactionDetailService transDetailService;
	
	@Autowired
	UserService userService;

	@Override
	public TransactionHeader save(TransactionHeader transHeader, String auth, String auth2) throws Exception {
		userService.findByUserNameAndPassword(auth, auth2);
		return transHeaderDao.save(transHeader);
	}

	@Override
	public void saveTransaction(Transaction transaction, String auth, String auth2) throws Exception {
		userService.findByUserNameAndPassword(auth, auth2);
		TransactionHeader transHeader = transHeaderDao.save(transaction.getTrans());
		transaction.getListTransDetail().forEach(valList -> {
			TransactionDetail transDetail = valList;
			transDetail.setTrans(transHeader);
			try {
				transDetailService.save(transDetail, auth, auth2);
			} catch (Exception e) {
				e.getMessage();
			}
		});
	}

}
