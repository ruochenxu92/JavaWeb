<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
    
<%@ taglib prefix="tlt" uri="/WEB-INF/us.tld"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Summer</title>
</head>
<body>
	IP is: 
	<% 
		String ip = request.getRemoteAddr();
		out.print(ip);
	%>
	<tlt:viewIP/>
	
	
	
	
	
</body>
</html>