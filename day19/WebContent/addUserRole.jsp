<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User Role</title>
</head>
<body>
	<h1>Add User Role</h1>
	<table frame="border" width="40%">
		<tr>
			<td>User Name</td>
			<td>${user.name }</td>
		</tr>
		<tr>
			<td>User current have Roles</td>
			<td>				
				<c:forEach var="r" items="${user_roles}">
					${r.name }<br>
				</c:forEach>
			</td>
		</tr>
		<tr>
		<td>
		<br/>
		<br/>
		<br/>
		</td>
		</tr>
		<tr>
			<td>Current System have Roles</td>
			<td>
				<form
					action="${pageContext.request.contextPath }/AddUserRoleServlet"
					method="get">
					<input type="hidden" name="user_id" value="${user.id }">
					<c:forEach var="role" items="${system_roles }">
						<input type="checkbox" name="role_id" value="${role.id }" />${role.name }<br>
					</c:forEach>
					<input type="submit" value="Add Role">
				</form>
			</td>
		</tr>	
	</table>
</body>
</html>