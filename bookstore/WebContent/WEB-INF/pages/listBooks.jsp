<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>List Books</title>
</head>
<body>
	<h1>Book Shop</h1>
	<table width="80%" border="1">
		<tr style="background-color: yellow;">
			<td>ID</td>
			<td>ISBN</td>
			<td>Book Name</td>
			<td>Author</td>
			<td>Price</td>
			<td>Description</td>
			<td>Operation</td>
		</tr>
	
			<c:forEach var="entry" items="${books }" varStatus="status"> 
			<tr style="background-color: ${status.count%2==0?'#5A4DB5':'#C8C8FF'}">
				<td>${status.count }</td>
				<td>${entry.key }</td>
				<td>${entry.value.name }</td>
				<td>${entry.value.author }</td>
				<td>${entry.value.price }</td>
				<td>${entry.value.description }</td>
				<td>
					<a href="/bookstore/BuyServlet?bookid=${entry.key }">Buy</a>
				</td>
			</tr>
			</c:forEach>
		
	</table>
</body>
</html>