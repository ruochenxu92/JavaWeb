<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
<script type="text/javascript">
	function clearcart(){
		var b = window.confirm("Are you sure?");
		if(b){
			window.location.href="${pageContext.request.contextPath }/ClearCartServlet";
		}
	}
</script>
<script type="text/javascript">
	function update(input,id,old){
		
		var quantity = input.value;
		var b = window.confirm("Are you sure?");
		if(b){
			window.location.href="${pageContext.request.contextPath }/UpdateCartServlet?bookid="+id+"&quantity="+quantity;
			
		}else{
			input.value = old;
		}
	}
</script>
</head>
<body>
	<br>
	<center>
		<h1>Shopping Cart</h1>
		<br>
		<br>
		<c:if test="${!empty(cart.map)}">
		<table width="80%" border="1">
			<tr>
				<td>Book Name</td>
				<td>Book Author</td>
				<td>Book Price</td>
				<td>Number</td>
				<td>Sum</td>
				<td>Operator</td>
			</tr>


			<c:forEach var="me" items="${cart.map }">
				<tr>
					<td>${me.value.book.name }</td>
					<td>${me.value.book.author }</td>
					<td>$${me.value.book.price }</td>
					<td><input type="text"  name = "quantity"  value= ${me.value.quantity } style="width:30px"  onchange="javascript:update(this,${me.value.book.id},${me.value.quantity } )"></td>
					<td>$${me.value.price }</td>
					<td><a href="/bookmarket/DeleteServlet?bookid=${me.key}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2">total:  $${cart.price }</td>
				<td colspan="2">
				<a href="javascript:clearcart()">Clear All items</a>
			</tr>
		
		</table>
		
		</c:if>
		<c:if test="${empty (cart.map) }">
			<h1>Sorry, You have not bought any item!</h1>
		</c:if>
	</center>
</body>
</html>