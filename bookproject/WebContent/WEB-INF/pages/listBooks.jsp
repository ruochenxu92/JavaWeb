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
	<h1>Books List</h1>
	<table width="80%" border="1">
		<tr style="background-color:#ff1">
						<td>Id</td>
						<td>ISBN</td>
						<td>BookName</td>
						<td>Author</td>
						<td>Price</td>
						<td>Description</td>
						<td>Operator</td>
		</tr>
		
	<%
	String data = "abcd";
	request.setAttribute("data", data);
%>
		
		<c:forEach items="${books}" var="me" varStatus="stat">
    			<tr style="background-color: ${stat.count%2==0?'#5A4DB5':'#C8C8FF' }">
	    			<td>${stat.count}</td>
	    			<td>${me.key}</td>
	    			<td>${me.value.name }</td>
	    			<td>${me.value.author }</td>
	    			<td>${me.value.price }</td>
	    			<td>${me.value.description }</td>
	    			<td>
	    				<a href="${pageContext.request.contextPath }/servlet/BuyServlet?bookid=${me.key}">Buy</a>
	    			</td> 
	    		</tr>
    		</c:forEach>
	</table>
</body>
</html>