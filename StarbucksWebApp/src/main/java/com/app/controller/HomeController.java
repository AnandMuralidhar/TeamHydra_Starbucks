package com.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Card;
import com.app.model.Order;

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

	@GetMapping("/order")
	public String Order() {
		return "order";
	}
	



	@GetMapping("/store")
	public String Store() {
		return "store";
	}
	
	@GetMapping("/rewards")
	public String Rewards() {
		return "rewards";
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
	


	
	@PostMapping("/createorder")
	public String createorder(@RequestParam("cappuccino") int cappuccinocount, @RequestParam("latte") int lattecount,
			@RequestParam("macchiato") int macchiatocount, @RequestParam("mocha") int mochacount, HttpServletRequest request)
	{
		Map<String, Integer> m = new HashMap<String, Integer>();
		ArrayList<Order> orderarray = new ArrayList<Order>();
		m.put("Cappucino", cappuccinocount);
		m.put("Latte", lattecount);
		m.put("Macchiato", macchiatocount);
		m.put("Mocha", mochacount);
		System.out.println(cappuccinocount);
		System.out.println(lattecount);
		System.out.println(macchiatocount);
		System.out.println(mochacount);
		orderarray = userService.createOrder(m);
		request.setAttribute("orderlist", orderarray);
		return "payments";
	}
	
	@PostMapping("/logout")
	public String logout( HttpSession session) {
		session.invalidate();
		return "index";
	}

	@PostMapping("/loginUser")
	public String loginUser(@RequestParam("emailid")String email,@RequestParam("pwd")String password, HttpSession session)
	{
		User user = userService.getUser(email,password);
		Card card = userService.getCardDetails(email);
		
		double cardBal;
		
		if(card == null)
		{
			cardBal = 0;
		}else
		{
			cardBal = card.getCardBalance();
		}
		
		
		session.setAttribute("CardBalance", cardBal);
		
		
		if(user == null) {
		
			return "index";
		}
		session.setAttribute("UserEmail", email);
		return "dashboard";
	}
	
	@PostMapping("/payment")
	public String payment( HttpSession session)
	{	
		
		String total = "5";
		double amount = Double.parseDouble(total);
		String email = session.getAttribute("UserEmail").toString();
		Card card = userService.getCardDetails(email);	
		double cardBalance = 0.00;	
		
			cardBalance = card.getCardBalance();
			if(amount < cardBalance)
			{
				cardBalance = cardBalance - amount;
				card.setCardBalance(cardBalance);
				userService.addCard(card);
				session.setAttribute("CardBalance", cardBalance);
				System.out.println("Updated Card: "+card);
			}
	
		
		return "dashboard";
	}
}
