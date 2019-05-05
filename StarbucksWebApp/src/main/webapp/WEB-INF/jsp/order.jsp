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
</head>
<body>
<div class="container">
<div class="header">
<%@ include file="header.jspf" %>
</div><br /><br />
<div>
<form action="/createorder" method="post">
<label>Cappuccino:</label>
<input name="cappuccino" type="text" />
<label>Latte:</label>
<input name="latte" type="text" />
<label>Macchiato:</label>
<input name="macchiato" type="text" />
<label>Mocha:</label>
<input name="mocha" type="text" />
<button type="submit">Order</button>
</form>
</div>
</div>
</body>
</html>