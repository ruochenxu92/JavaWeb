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
				<a href="${pageContext.request.contextPath }/addrole.jsp">Add Role</a>
			</td>
		</tr>
	</table>
	<table frame="border" width="50%">
		<tr>
			<td>Role Name</td>
			<td>Role Description</td>
			<td>Operator</td>
		</tr>
		<c:forEach  var="role" items="${list }">
			<tr>
				<td>${role.name }</td>
				<td>${role.description }</td>
				<td>
					<a href="${pageContext.request.contextPath }/AddRolePrivilegeUIServlet?role_id=${role.id}">Privileges+</a>
					<a href="">Update Role</a>
					<a href="">Delete Role</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>