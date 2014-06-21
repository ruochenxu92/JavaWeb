<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Look Up</h1>
<%
	Map<String,Integer> cart = (Map<String,Integer>)request.getSession().getAttribute("cart");
	if(cart ==null){
		out.println("no information about your shopping");
	}else{
		for(String productName: cart.keySet()){
			out.println("<h3>ProductName:"+productName+", "+cart.get(productName)+" </h3>");
		}
	}
%>
<hr/>
<c:if test="${empty sessionScope.cart}">
	No Shopping Information
</c:if>
<c:if test="${not empty sessionScope.cart}">
	<c:forEach items="${sessionScope.cart}" var="entry">
		<h3>ProductName:${entry.key},${entry.value}</h3>
	</c:forEach>
</c:if>
</body>
</html>