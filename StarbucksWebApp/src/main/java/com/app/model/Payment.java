package com.app.model;

public class Payment {

	private String paymentId;
	private String amount ;
	private String cardNumber;
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
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
