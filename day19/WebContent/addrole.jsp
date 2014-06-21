<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add Role</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/AddRoleServlet">
 		Role Name: <input type="text" name="name"><br>
		Role Description:
			<textarea rows="5"  cols="60" name="description">
			</textarea><br>
		<input type="submit" value="submit">
	</form>

</body>
</html>
