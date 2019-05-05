package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Card;
import com.app.model.Payment;
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
	
	@GetMapping("/dashboard")
	public String MyCards() {
		return "dashboard";
	}
	@GetMapping("/addcard")
	public String AddCard() {
		return "addcard";
	}
	

	
	@PostMapping("/addUser")
	public String addUser(@RequestParam("email") String email, @RequestParam("fname") String fname, @RequestParam("lname") String lname,
			@RequestParam("zipcode") int zipcode, @RequestParam("password") String password, HttpSession session)
	{
		User user = new User();
		user.setEmailID(email);
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setZipCode(zipcode);
		user.setPassword(password);
		
		
		
		if(userService.adduser(user))
		{
			session.setAttribute("UserEmail", user.getEmailID());
			System.out.println("User added successfully");
		}else
		{
			System.out.println("User not added successfully");
		}
		
	return "dashboard";
	}
	
	

	@PostMapping("/addCard")
	public String addCard(@RequestParam("cardNumber") String cardNumber, @RequestParam("cardCode") String cardCode, ModelMap model, HttpSession session)
	{
		Card card = new Card();
		String emailID = (String) session.getAttribute("UserEmail");
	
		
		if(cardNumber.length() == 9 && cardCode.length() == 3)
		{
			card.setCardNumber(cardNumber);
			card.setCardCode(cardCode);
			card.setEmailID(emailID);
			card.setCardBalance(20);
		}else
		{
			model.addAttribute("ErrorMessage", "Card Number / Card Code is not valid");
			return "addcard";
		}		

		if(userService.addCard(card))
		{
			System.out.println("Card added successfully");
		}else
		{
			System.out.println("Card not added successfully");
		}
		return "dashboard";
		
	}
	
	@PostMapping("/payment")
	public void payment(@RequestParam("paymentId") String paymentId, @RequestParam("cardNumber") String cardNumber,
			@RequestParam("amount") int amount)
	{
		Payment pay = new Payment();
		pay.setPaymentId(paymentId);
		pay.setCardNumber(cardNumber);
		pay.setAmount(amount);	
	
	}
	
	@PostMapping("/order")
	public void order(@RequestParam("paymentId") String paymentId, @RequestParam("cardNumber") String cardNumber,
			@RequestParam("amount") int amount)
	{
			
	
	}
	
	@PostMapping("/logout")
	public String logout( HttpSession session) {
		session.invalidate();
		return "index";

	@PostMapping("/loginUser")
	public String loginUser(@RequestParam("emailid")String email,@RequestParam("pwd")String password)
	{
		User user = userService.getUser(email,password);
		
		if(user == null) {
			
			System.out.println("User does not exsist");	
		}
		return "dashboard";
	}
	

}
