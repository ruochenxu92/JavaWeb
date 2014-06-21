<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" import="bookstore.domain.Cart"  import="java.util.*" import="bookstore.domain.CartItem"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Shopping Cart</title>
</head>
<body>

		<table width="80%" border="1">
   		<tr>
   			<td>ID</td>
			<td>ISBN</td>
			<td>Book Name</td>
			<td>Author</td>
			<td>Price</td>
			<td>Description</td>
			<td>Operation</td>
   		</tr>
   		<!-- me    Map.Entry  key=bookid   value=CartItem -->
   		<c:forEach items="${sessionScope.shopcart.map}" var="me" varStatus="stat">
   			<tr style="background-color: ${stat.count%2==0?'#5A4DB5':'#C8C8FF' }">
    			<td>${stat.count}</td>
    			<td>${me.value.book.name }</td>
    			<td>${me.value.book.author }</td>
    			<td>${me.value.book.price }</td>
    			<td>
    				<input type="text" maxlength="5" name="num" id="num" value="${me.value.num }" onchange="changeNum(this,'${me.value.book.id }','${me.value.num }')"/>
    			</td>
    			<td>${me.value.price }</td>
    			<td>
    				<a href="javascript:toDelete('${me.value.book.id}')">Delete</a>
    			</td>
    		</tr>
   		</c:forEach>
   		<tr>
   			<td colspan="3">
   				<a href="javascript:clear()">Empty Cart</a>
   			</td>
   			<td>Total Num</td>
   			<td>${sessionScope.shopcart.num }</td>
   			<td>Total Price</td>
   			<td>${sessionScope.shopcart.price}</td>
   		</tr>
   	</table>
		
		
		
	</table>
</body>
</html>