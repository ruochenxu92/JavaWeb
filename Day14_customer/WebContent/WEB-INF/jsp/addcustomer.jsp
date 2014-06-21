<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer.js"></script>
</head>
<body style="text-align:center;"onload="makeYear()">

	
	
	<table width="50%" border="1" >
		<tr>
			<td>Customer Name</td>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<td>Sex</td>
			<td>
				<input type="radio" name="gender" value="male"> male
				<input type="radio" name="gender" value="female">female
			</td>
		</tr>
		<tr>
			<td>birthday</td>
			<td>
				<select name="year" id="year">
					<option value="1990">1900</option>
				</select>Year
				<select name="month" id="month">
				
				</select>Month
				<select name="day" id="day">
				
				</select>Day
			</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		
	</table>
	
	
	
	

</body>
</html>