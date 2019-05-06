<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
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
<div class="submenuoptions">Make your day light with coffee...</div>
</div>
</div>
<div>
<div class="rightcontent card">
<div class="ordercontents">
<form action="/createorder" method="post">
<div class="coffeeitem">
<img class="coffeeimg" src="resources/images/cappuccino.jpg" />
<div class="coffeename">Cappuccino:</div>
<div class="inputfields">
<input type="button" onclick="decrementCappuccinoValue()" value="-" />
   <input type="text" id="cappuccinonumber" name="cappuccino" value="0"/>
   <input type="button" onclick="incrementCappuccinoValue()" value="+" />
   </div>
</div>

<div class="coffeeitem">
<img class="coffeeimg" src="resources/images/cappuccino.jpg" />
<div class="coffeename">Latte:</div>
<div class="inputfields">
<input type="button" onclick="decrementValue()" value="-" />
   <input type="text" id="lattenumber" name="latte" value="0"/>
   <input type="button" onclick="incrementValue()" value="+" />
</div>
</div>


<div class="coffeeitem">
<img class="coffeeimg" src="resources/images/cappuccino.jpg" />
<div class="coffeename">Macchiato:</div>
<div class="inputfields">
<input type="button" onclick="decrementValue()" value="-" />
   <input type="text" id="macchiatonumber" name="macchiato" value="0"/>
   <input type="button" onclick="incrementValue()" value="+" />
</div>
</div>

<div class="coffeeitem">
<img class="coffeeimg" src="resources/images/cappuccino.jpg" />
<div class="coffeename">Mocha:</div>
<div class="inputfields">
<input type="button" onclick="decrementValue()" value="-" />
   <input type="text" id="mochanumber" name="mocha" value="0"/>
   <input type="button" onclick="incrementValue()" value="+" />
</div>
</div>
<button type="submit">Order</button>
</form>
</div>
</div>
</div>
</div>


</body>
</html>