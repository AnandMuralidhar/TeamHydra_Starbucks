<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Card</title>
<script src="js/main.js"></script>
<link rel="stylesheet" href="styles/dashboard.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="container">
<div class="leftcontent card">
<div class="header">
<%@ include file="header.jspf" %>
</div>
<div class="headercontent"> 
<ul class="submenuoptions">
<li><a href="/addcard">Add Card</a></li>
<li>Delete Card</li>
<li>Billing</li>
<li>Passcode</li>
<li>About | Terms</li>
<li>Help</li>
</ul>
</div>
</div>
<div class="rightcontent card">
<h1><font color= "black">${ErrorMessage}</font></h1>
<div class="maincontent">
<form action="/addCard" method="post">	
    <p>Add New Card</p>
	 <input class="input" type="text" pattern="\d*" maxlength="9" name="cardNumber" placeholder="cardNumber" required/><br/>
	 <input class="input" type="text" pattern="\d*" maxlength="3" name="cardCode" placeholder="cardCode" required/><br />
	<button class="submitbtn" type="submit">Add Card</button>		
</form>
</div>
</div>
</div>	
</body>
</html>