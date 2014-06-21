<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addRolePrivilege</title>
</head>
<body>
	<table frame="border" width="40%">
		<tr>
			<td>Role Name</td>
			<td>${role.name }</td>
		</tr>
		<tr>
			<td>role current have privileges</td>
			<td>				
				<c:forEach var="p" items="${role_privileges}">
					${p.name }<br>
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
			<td>Current System have privileges</td>
			<td>
				<form action="${pageContext.request.contextPath }/AddRolePrivilegesServlet" method="get">
				<input type="hidden" name="role_id" value="${role.id }">
				<c:forEach var="s" items="${system_privileges }">
					<input type="checkbox" name="privilege_id" value="${s.id }" />${s.name }<br>
				</c:forEach>
				<input type="submit" value="privilege">
				</form>
			</td>
		</tr>	
	</table>
</body>
</html>