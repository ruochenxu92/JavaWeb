<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/addCustomer.js"></script>
</head>
<body onload="init()">
	<form action="${pageContext.request.contextPath }/addCustomerServlet" method="get" onsubmit="return dosubmit()" id="customer">
	<table>
		<tr>
			<td>Customer Name:</td>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>
				<input type="radio" name="gender" value="male">male
				<input type="radio" name="gender" value="female">female
			</td>
		</tr>
		<tr>
			<td>Birthday:</td>
			<td>
				<select name="year" id="year">
					<option value="1900">1900</option>
				</select> Year
				<select name="month" id = "month">
					<option value="01">01</option>
				</select> Month
				<select name="day" id="day">
					<option value="01">01</option>
				</select> Day
			</td>
		</tr>
		<tr>
			<td>cellphone</td>
			<td>
				<input type = "text" name="cellphone">
			</td>
		</tr>
		<tr>
			<td>email</td>
			<td>
				<input type="text" name = "email">
			</td>
		</tr>
		<tr>
			<td>hobby</td>
			<c:forEach var="entry" items="${preference }">
				<td>
					<input type="checkbox" name="preference" value="${entry }" id="pre"> ${entry }
				</td>
			</c:forEach>
		</tr>
			
		<tr>
			<td>type</td>
			<c:forEach var="entry" items="${type }">
			<td>
				<input type="radio" name="type" value="${entry }"> ${entry }
			
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Description</td>
			<td>
				<textarea rows="5" cols="50"></textarea>
			</td>
		</tr>
		<tr>
			<td>
			<input type="reset" value="empty">
			</td>
			<td>
			<input type="submit" value="submit">
			</td>
		</tr>
		
	
	
	
	
	
	
	</table>
		</form>
	
</body>
</html>