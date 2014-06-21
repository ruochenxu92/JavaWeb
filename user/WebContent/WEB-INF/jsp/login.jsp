<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="/user/LoginServlet" method="get">
		User Name: <input type="text" name= "username">
	    Password: <input type="text" name="password">
	<input type="submit" value="login">
	</form>

</body>
</html>