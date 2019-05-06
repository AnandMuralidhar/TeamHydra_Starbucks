<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import = "com.app.model.Order" %>
    <%@page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payments</title>
<script src="js/main.js"></script>
<link rel="stylesheet" href="styles/dashboard.css" type="text/css">
</head>
<body>
<div class="container">
<div class="header">
<%@ include file="header.jspf" %>
</div>
<div class="printReceipt"> 
<form action="/payment" method="post">
<% 
 if(request.getAttribute("orderlist") != null)
 {
 ArrayList<Order> a = (ArrayList<Order>)request.getAttribute("orderlist"); 
 System.out.println(a); 
 double total = 0.00;
for(Order usermodel : a)
 { 
%>
	<p><%out.println(usermodel.getType()); %> x <%out.println(usermodel.getCount()); %> = <%out.println(usermodel.getPrice()); %></p>
	<% total += usermodel.getPrice();%>									


 <% }%>
<p>Total: <% out.println(total); %></p>
<% } %>
<button type="submit">Proceed to checkout</button>
</form>
</div>
</div>
</body>
</html>