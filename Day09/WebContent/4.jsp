<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" import="java.util.*"
    import="cn.itcast.javabean.Person"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<%
	List list = new ArrayList();
	list.add(new Person("aaa"));
	list.add(new Person("bbb"));
	list.add(new Person("ccc"));
	request.setAttribute("list",list);
%>
<c:out value="${'<tag> , &'}"/>
<c:forEach var="entry" items="${list }">
	${entry.name}
</c:forEach>

<c:if test="${user!=null }">
	Welcome: ${user.name }
</c:if>
<c:if test="${user==null }">
	Username: <input type="text" name="username">
	Password: <input type="text" name="password">
	<input type="submit" value="login">
</c:if>


</body>
</html>