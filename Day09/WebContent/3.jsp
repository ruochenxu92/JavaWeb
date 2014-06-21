<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" import="cn.itcast.javabean.Person"
    import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<%
	String data = "abcd";
	request.setAttribute("data", data);
%>
${data }
<%
	Person p = new Person();
	p.setName("Xiao");
	request.setAttribute("person",p);
%>
${person.name }



<%
	List list = new ArrayList();
	list.add(new Person("aaa"));
	list.add(new Person("bbb"));
	list.add(new Person("ccc"));
	request.setAttribute("list",list);
%>
${list[1].name }

<%
	Map map = new HashMap();
	map.put("aa",new Person("aaaa"));
	map.put("111",new Person("bbbb"));
	request.setAttribute("map",map);

%>

${map.aa.name }
${map['111'].name }




${pageContext.request.contextPath}
<a href = "${pageContext.request.contextPath}/3.jsp">click</a>









</body>
</html>