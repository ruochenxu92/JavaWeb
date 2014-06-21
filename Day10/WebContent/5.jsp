<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib  uri="/WEB-INF/us.tld" prefix="tlt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>use tag to modify jsp page content</title>
</head>
<body>
dostarttag eval_body_buffered setBodyContent
		java body 
		capitalize
		eval_body_buffered
	<tlt:demo4>
		AAAAAAAAAAAA
	</tlt:demo4>


</body>
</html>