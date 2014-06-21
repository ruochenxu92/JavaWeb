<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>register</title>
<script type="text/javascript" src="/register/js/Birthday-Calendar.js"></script>

</head>
<h1>Register</h1>
<body>

<form action= "/Register/RegisterServlet" method="get">
	Username<input type="text" name="username" value="${form.username }">${form.error.username }<br>
	Password<input type="text" name="password" value="${form.password }">${form.error.password }<br>
	Reenter: <input type="text" name="password2" value="${form.password2 }">${form.error.password2 }<br>
	Email <input type="text" name="email" value="${form.email }">${form.error.email }<br>
	birthday<input type="text" name="birthday" value="${form.birthday }"  >${form.error.birthday } <br>
	Nick Name<input type="text" name="nickname" value="${form.nickname }">${form.error.nickname }<br>
	<input type="submit" value="Register"><br>
</form>
</body>
</html>