package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	private String paymentId;
	private double amount ;
	private String cardNumber;
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", Amount=" + amount + ", CardNumber=" + cardNumber + "]";
	}
	
}
