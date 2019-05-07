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
<li>Find Store</li>
<li>Enable Payments</li>
</ul>
</div>
</div>
<div class="rightcontent card">
 
<form action="/payment" method="post">
<% 
double total = 0.00;
 if(request.getAttribute("orderlist") != null)
 {
 ArrayList<Order> a = (ArrayList<Order>)request.getAttribute("orderlist"); 
 System.out.println(a);  %>
 <div class="printreceipt">
<%for(Order usermodel : a)
 { 
%>
	<p><%out.println(usermodel.getType()); %> x <%out.println(usermodel.getCount()); %> = <%out.println(usermodel.getPrice()); %></p>
	<% total += usermodel.getPrice();%>									


 <% }%>
<p>Total: <% out.println(total); %></p>
</div>
<input type="hidden" name="total" value="<%=total%>" />
<button class="submitbtn" type="submit">Proceed to checkout</button>
<% } else { %>
	<div style =" text-align: center;
    margin-top: 40%;"><h1>Order first to pay</h1> </div>
<%  }%>

</form>
</div>
</div>

</body>
</html>