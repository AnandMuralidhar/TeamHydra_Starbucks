package com.app.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.model.Card;
import com.app.model.Payment;
import com.app.repository.CardRepository;
import com.app.repository.PaymentRepository;

public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private CardRepository cardRepository;

	private String id;

	public Boolean doPayment(String cardNumber, double amount) {
		
		Optional<Card> cardData = cardRepository.findById(cardNumber);
	       if(cardData.isPresent()){
	    	  Card card = cardData.get();
	    	  if(card.getCardBalance() >= amount)
	    	  {	
	    		  paymentRepository.save(new Payment(amount, cardNumber));
	    		  return true;
	    	  }
	       }
		return false;
	}
}
