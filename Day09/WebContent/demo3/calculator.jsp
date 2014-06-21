<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" import="cn.itcast.javabean.Calculator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<jsp:useBean id="calculator" class="cn.itcast.javabean.Calculator" scope="request"></jsp:useBean>
<jsp:setProperty property = "*" name = "calculator"/>
<%--
<h3>Result: ${calculator.firstNum } ${calculator.operator } ${calculator.secondNum }= ${calculator.result } </h3>
 --%>




<form action = "/day09/demo3/calculator.jsp" method = "post">
	<table>
		<tr><td>first parameter</td><td><input type="text" name="firstNum" /></td></tr>
		<tr>
		<td>operator</td>
		<td> 
		<select name = "operator">
			<option value = "+">+</option>
			<option value = "-">-</option>
			<option value ="*">*</option>
			<option value ="/">/</option>
		</select> 
		</td>
		</tr>
		<tr>
			<td> second parameter</td>
			<td> <input type = "text" name = "secondNum"/> </td>
		</tr>
	    
	    <tr><td colspan="2"><input type="submit" value="calculate"/></td></tr>
	</table>
</form>


