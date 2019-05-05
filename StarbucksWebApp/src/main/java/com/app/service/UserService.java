package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Card;
import com.app.model.User;
import com.app.repository.CardRepository;
import com.app.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private CardRepository cardRepository;
	
	
	/** Adding users into db*/
	public boolean adduser(User user) {
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {

		}
		return false;
	}
	
	
	/** Adding cards into db*/
	public boolean addCard(Card card) {
		try {
			cardRepository.save(card);
			return true;
		} catch (Exception e) {

		}
		return false;
	}

}
