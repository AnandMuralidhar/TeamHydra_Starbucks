<%@ page language="java" contentType="text/html; charset=UTF-8"
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
<div class="container">
<div class="header">
<div class="headerelement">
<img src="resources/images/starbuckshomelogo.png" width="40px" height="40px" />
</div>
<div class="headerelement"><a href="index.jsp">Sign in</a></div>
<div class="headerelement"><a href="register.jsp">Join now</a></div>
</div><br />
<div class="loginform">
<form action="" method="post">
<div class="loginelement">
    <input type="text" placeholder="Username or email address" name="emailid" required><br />
   </div>
    <div class="loginelement">
    <input type="password" placeholder="Enter Password" name="pwd" required><br />
   </div>     
    <button class="submitbtn" type="submit">Login</button>
</form>
</div>
<div class="btnregister" type="submit"><a href="register.jsp">Join now</a></div>
</div>
</body>
</html>