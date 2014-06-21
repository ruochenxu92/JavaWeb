<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Student Information</title>
</head>
<body>
	Total: ${page.totalrecords } records
	Current: ${page.pagenum } page
	Total: ${page.lastpage } pages
	<table width="50%" frame="border" style="text-align:center">
		<tr>
			<td>Id  </td>
			<td>Name</td>
		</tr>
		<c:forEach var="student" items="${page.list }">
			<tr><td>${student.id } </td>
       		<td>${student.name }</td></tr>		
       	</c:forEach>
	</table>
	
	<%@include file="/public/page.jsp" %>
	
</body>
</html>