<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style>
	body{
		margin:0px;
		padding:0px;
		font-size:12px;
		background-color:#016aa9;
		overflow:hidden;
		text-align: center;
	}

	#container{
		width:980px;
	}


	#login{
		margin-left: 170px;
		margin-top: -50px;
		background-image:url(images/login.jpg);
		background-size: 100% 100%;
		width:1031px;
		height:393px;
		text-align: center;


	}

	#form{
		text-align: center;
		margin-top:180px;
		margin-left: 300px;
		width:180px;
		height:50px;
	}

	#input{
		position:fixed;
		top:45%;
		left:48%;

		
		width:120px;
		height:24px;
		

	}

	#input input{

		width:125px;
		height:20px;
		background-color: #292929;
		color:#058991;
		border: 0px;
		margin-bottom: 5px;
	}



	#btn {
		  position: fixed;
    	  top: 53%;
    	  left: 48%;
	}

	#btn input{
		border:0px;
		background-image: url(images/green.png);
		background-size: 100% 100%;
		margin-right: 5px;
		width:120px;
		height:24px;
	}

	#btn a{
		border:0px;
		text-decoration:none;
		margin-right: 5px;
		width:120px;
		height:24px;
	}
	
	#btn a:hover{
		border:0px;
		color:white;
		
		font-size:16px;
		margin-right: 5px;
		width:120px;
		height:24px;
	}
	
	
	
	#user{
		background-image: url(images/user.png);
		background-size: 100% 100%;
		position:fixed;
		top:45%;
		left:46%;
		width:20px;
		height:18px;
	}
	#password{
		background-image: url(images/lock.png);
		background-size: 100% 100%;
		position: fixed;
		top:48.7%;
		left:46%;
		width:20px;
		height:18px;
	}

</style>
</head>

<body>
	<div id="container">
		<div id="login">
			<div id="form">
				<form action="${pageContext.request.contextPath }/LoginServlet" method="get">
					<div id="input">
						<input type="text" name="username"><br>	
						<input type="password" name="password">
					</div>

					<div id="btn">
						<input type="submit" value=" Login ">
						<a href="${pageContext.request.contextPath }/registerUIServlet">register</a>
						
					</div>

					<div id="user">
					</div>
						
					<div id="password">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>




	
