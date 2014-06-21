<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List all role</title>
</head>

<body style="text-align:center;">
	<table>
		<tr style="text-align:right">
			<td>
				<a href="${pageContext.request.contextPath }/adduser.jsp">Add User</a>
			</td>
		</tr>
	</table>
	<table frame="border" width="50%">
		<tr>
			<td>User Name</td>
			<td>User Password</td>
			<td>Operator</td>
		</tr>
		<c:forEach  var="user" items="${users }">
			<tr>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td>
					<a href="${pageContext.request.contextPath }/AddUserRoleServlet?user_id=${user.id}">Role+</a>
					<a href="">Update User</a>
					<a href="">Delete User</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>