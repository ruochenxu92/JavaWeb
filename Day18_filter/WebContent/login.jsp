<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login start page</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
		Username:<input type ="text" name="username"><br>
		Password:<input type ="password" name="password"><br>
		Expire:
			<input type="radio" name="logintime" value="3600"> 1 hour
			<input type="radio" name="logintime" value="${10*60 }"> 10 mins
			<input type="radio" name="logintime" value="${5*60 }">	5 mins
		<br>
		<input type="submit" value="login">
	</form>

</body>
</html>