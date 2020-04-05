package com.lawencon.ticket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_h_transaction_header")
public class TransactionHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTransaction;

	@ManyToOne
	@JoinColumn(name = "idUser", nullable = false)
	private User user;

	public Long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
