<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome to JiaHui's BookShop</title>
</head>
<center>
<h1>Welcome to Jay's Book Shop</h1>
</center>
<body>
	<table width="100%" border = "1">
		<tr>
			<td>ID</td>
			<td>BookId</td>
			<td>Book Name</td>
			<td>Author</td>
			<td>Price</td>
			<td>Operator</td>			
		</tr>
		<c:forEach var="entry" items="${books }"  varStatus="stat">
		<tr style="background-color: ${stat.count%2==0?'yellow':'pink'}">
			<td>${stat.count }</td>
			<td>${entry.key }</td>
			<td>${entry.value.name }</td>
			<td>${entry.value.author }</td>
			<td>${entry.value.price }</td>
			<td>
			<a href ="/bookshop/BuyServlet?bookid=${entry.key }">Buy</a>
			</td>			
		</tr>
		</c:forEach>
	</table>

</body>
</html>