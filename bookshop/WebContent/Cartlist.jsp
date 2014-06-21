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


       <c:forEach var="entry" items="${sessionScope.cart.map }"  varStatus="stat">
		<tr style="background-color: ${stat.count%2==0?'yellow':'pink'}">
			<td>${stat.count }</td>
			<td>${entry.key }</td>
			<td>${entry.value.num }</td>
			<td>${entry.value.num }</td>
			<td>${entry.value.num }</td>
			<td>
			<a href ="/bookshop/BuyServlet?bookid=${entry.key }">Buy</a>
			</td>			
		</tr>
		</c:forEach>

</body>
</html>