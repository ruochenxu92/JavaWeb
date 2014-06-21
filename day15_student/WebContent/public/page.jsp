<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${page.pagenum>1 }">
		<a href="${pageContext.request.contextPath }/ListStudentServlet?pagenum=${page.pagenum-1}">previous</a>
	</c:if>
	&nbsp;&nbsp;

	<c:forEach var="pagenum" begin="${page.startpage }" end="${page.endpage }">
		<a href="${pageContext.request.contextPath }/ListStudentServlet?pagenum=${pagenum}">${pagenum }</a>


	</c:forEach>
	&nbsp;&nbsp;
	<c:if test="${page.pagenum< page.lastpage}">
		<a href="${pageContext.request.contextPath }/ListStudentServlet?pagenum=${page.pagenum+1}">next</a>
	</c:if>
	
	
	<input type="text" id="pagenum">
	<input type="button" value=" GO " onclick="goWhich(document.getElementById('pagenum'))">

	<script type="text/javascript">
		function goWhich(input){
			var pagenum = input.value;
			
			if(pagenum == null || pagenum == ""){
				alert("Please enter the page number!");
				return;
			}
			if(!pagenum.match("\\d+")){
				alert("Please enter number!");
				return;
			}
			
			
			if(pagenum < 1  ||  pagenum > ${page.lastpage}){
				alert("invalid page");
				return;
			}
			
			window.location.href="${pageContext.request.contextPath }/ListStudentServlet?pagenum="+pagenum;
		}
	</script>
    