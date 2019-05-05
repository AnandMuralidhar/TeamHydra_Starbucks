<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="styles/dashboard.css" type="text/css">
</head>
<body>
<div class="container">
<div class="header">
<div class="headerelement">
<img src="resources/images/starbuckshomelogo.png" width="40px" height="40px" />
</div>
<div class="headerelement"><a href="/index">My Cards</a></div>
<div class="headerelement"><a href="/index">Payments</a></div>
<div class="headerelement"><a href="/index">Rewards</a></div>
<div class="headerelement"><a href="/index">Stores</a></div>
<div class="headerelement moreoptions" onclick="displayMoreOptions()">Settings</div>
<ul class="suboptions"><li>Add Card</li></ul>
</div><br /><br />

<h1><font color= "black">${ErrorMessage}</font></h1>

<form action="/addCard" method="post">	
    <p>Add New Card</p>
     <label for="cardNumber"><b>First Name</b></label>
	 <input class="input" type="text" name="cardNumber" placeholder="cardNumber" required/><br/>
	 <label for="cardCode"><b>Last Name</b></label>
	 <input class="input" type="text" name="cardCode" placeholder="cardCode" required/><br />
	<button class="signupbutton" type="submit">Add Card</button>		
	
</form>
</div>
<script type="text/javascript">
function displayMoreOptions() {
	alert("hii");
}

</script>

</body>
</html>