<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Card</title>
<script src="js/main.js"></script>
<link rel="stylesheet" href="styles/dashboard.css" type="text/css">
</head>
<body>
<div class="header">
<%@ include file="header.jspf" %>
</div>
<h1><font color= "black">${ErrorMessage}</font></h1>
<div class="maincontent">
<form action="/addCard" method="post">	
    <p>Add New Card</p>
	 <input class="input" type="text" pattern="\d*" maxlength="9" name="cardNumber" placeholder="cardNumber" required/><br/>
	 <input class="input" type="text" pattern="\d*" maxlength="3" name="cardCode" placeholder="cardCode" required/><br />
	<button class="submitbtn" type="submit">Add Card</button>		
</form>
</div>	
</body>
</html>