package com.lawencon.ticket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_h_transaction_detail")
public class TransactionDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTransactionDetail;
	
	@ManyToOne
	@JoinColumn(name = "idDiscount", nullable = true)
	private Discount disc;
	
	@ManyToOne
	@JoinColumn(name = "idTransaction", nullable = true)
	private TransactionHeader trans;
	
	@ManyToOne
	@JoinColumn(name = "idTicket", nullable = true)
	private Ticket ticket;
	
	private int finalPrice;
	
	private String departureDate;
	
	private String seat;

	public Long getIdTransactionDetail() {
		return idTransactionDetail;
	}

	public void setIdTransactionDetail(Long idTransactionDetail) {
		this.idTransactionDetail = idTransactionDetail;
	}

	public Discount getDisc() {
		return disc;
	}

	public void setDisc(Discount disc) {
		this.disc = disc;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	
}
