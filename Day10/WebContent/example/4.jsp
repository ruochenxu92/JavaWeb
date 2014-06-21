<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"
    import="java.util.*" %>
    
    
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
	
	
	<simple:forEach2 var="str" items="${list }">
		 ${str }
	</simple:forEach2>
	<br>----------------------------<br>
	<%
		Map map = new HashMap();
		map.put("1","aaa");
		map.put("2","bbb");
		map.put("3","ccc");
		pageContext.setAttribute("map", map);
	
	%>
	<simple:forEach2 var="entry" items="${map }">
		 ${entry.key} = ${entry.value }
	</simple:forEach2>
	<br>----------------------------<br>
	<%
		Integer[] arr = {1,2,3,4};
		pageContext.setAttribute("arr", arr);
	%>

	<simple:forEach2 var="elem" items="${arr }">
		 ${elem }
	</simple:forEach2>
	<br>----------------------------<br>
<%
		int[] arr1 = {5,6,7,8};
		pageContext.setAttribute("arr1", arr1);
	%>

	<simple:forEach2 var="elem" items="${arr1 }">
		 ${elem }
	</simple:forEach2>
	<br>----------------------------<br>
<%
		boolean[] arr2 = {true,false};
		pageContext.setAttribute("arr2", arr2);
	%>

	<simple:forEach2 var="elem" items="${arr2 }">
		 ${elem }
	</simple:forEach2>
	<br>----------------------------<br>


</body>
</html>