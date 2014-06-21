<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<br><center>
<h1>Book Market</h1>
<br><br>
<table width="80%" border = 1>
	<tr>
		<td>Book Id</td>
		<td>Book Name</td>
		<td>Book Author</td>
		<td>Price</td>
		<td>Description</td>
		<td>Operator</td>
	</tr>
	<!-- request map   books   <bookid, book> -->
	<c:forEach var="entry" items="${books }" >
		<tr>
		<td>${entry.key}</td>
		<td>${entry.value.name}</td>
		<td>${entry.value.author }</td>
		<td>${entry.value.price }</td>
		<td>${entry.value.description }</td>
		<td>
			<a href="/bookmarket/BuyServlet?bookid=${entry.key }">Buy</a>
		</td>
		</tr>
	
	
	</c:forEach>


</table>
</center>


</body>
</html>