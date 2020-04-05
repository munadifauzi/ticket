package com.lawencon.ticket.model;

import java.util.List;

public class Transaction {

	private TransactionHeader trans;

	private List<TransactionDetail> listTransDetail;

	public TransactionHeader getTrans() {
		return trans;
	}

	public void setTrans(TransactionHeader trans) {
		this.trans = trans;
	}

	public List<TransactionDetail> getListTransDetail() {
		return listTransDetail;
	}

	public void setListTransDetail(List<TransactionDetail> listTransDetail) {
		this.listTransDetail = listTransDetail;
	}

}
