<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"
    import="java.util.*"
    
    %>
    
    
<%@taglib uri="/WEB-INF/simpletag.tld" prefix="simple" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<%
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		pageContext.setAttribute("list", list);
	
	%>
	
	
	<simple:forEach var="str" items="${list }">
		 ${str }
	</simple:forEach>



</body>
</html>