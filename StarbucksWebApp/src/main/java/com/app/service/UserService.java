package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	/** Adding users into db*/
	public boolean adduser(User user) {
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {

		}
		return false;
	}
	
	

}
