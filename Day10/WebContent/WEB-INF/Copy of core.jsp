<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"
    import= "java.util.*"
    
    
    %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<c:set var="data" value="xxx" scope="page"/>
	${data }
	
	<%	
		Map map = new HashMap();
		request.setAttribute("map",map);
	%>
	
	<c:set property="ddd" value="xxx" target="${map }"/>
	
	
	<c:out value=""></c:out>
	
</body>
</html>