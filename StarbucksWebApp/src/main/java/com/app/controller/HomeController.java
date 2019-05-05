package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Card;
import com.app.model.User;
import com.app.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public String start() {
		return "index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	
	@GetMapping("/success")
	public String success() {
		return "success";
	}
	

	
	@PostMapping("/addUser")
	public String addUser(@RequestParam("email") String email, @RequestParam("fname") String fname, @RequestParam("lname") String lname,
			@RequestParam("zipcode") int zipcode, @RequestParam("password") String password)
	{
		User user = new User();
		user.setEmailID(email);
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setZipCode(zipcode);
		user.setPassword(password);
		
//		user.setEmailID("abc@gmail.com");
//		user.setFirstName("ABC");
//		user.setLastName("XYZ");
//		user.setZipCode(98);
//		user.setPassword("root");
		
		
		if(userService.adduser(user))
		{
			System.out.println("User added successfully");
		}else
		{
			System.out.println("User not added successfully");
		}
		
	return "success";
	}
	
	

	@PostMapping("/addCard")
	public void addUser(@RequestParam("cardNumber") String cardNumber, @RequestParam("cardCode") String cardCode, @RequestParam("email") String email,
			@RequestParam("cardBalance") int cardBalance)
	{
		Card card = new Card();
		card.setCardNumber(cardNumber);
		card.setCardCode(cardCode);
		card.setEmailID(email);
		card.setCardBalance(20);
		

		if(userService.addCard(card))
		{
			System.out.println("Card added successfully");
		}else
		{
			System.out.println("Card not added successfully");
		}
		
	}
	

}
