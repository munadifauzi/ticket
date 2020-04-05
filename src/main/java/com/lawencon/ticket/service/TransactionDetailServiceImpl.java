package com.lawencon.ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.ticket.dao.TransactionDetailDao;
import com.lawencon.ticket.model.TransactionDetail;

@Service
@Transactional
public class TransactionDetailServiceImpl implements TransactionDetailService {

	@Autowired
	@Qualifier("transDetail_repo_hibernate")
	TransactionDetailDao transDetailDao;

	@Autowired
	UserService userService;

	@Override
	public TransactionDetail save(TransactionDetail transDetail, String auth, String auth2) throws Exception {
		userService.findByUserNameAndPassword(auth, auth2);		
//		ticketService.findByTicketType(ticketType, auth, auth2);
//		discService.findByDiscCode(discCode, auth, auth2);
		// set final price (price-diskon)
		return transDetailDao.save(transDetail);
	}

}
