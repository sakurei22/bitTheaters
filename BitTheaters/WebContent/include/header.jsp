<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bit Theaters : 비트 영화관</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css" media="screen">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">BitTheaters</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="movieList.do">영화목록</a></li>
				<li class="nav-item"><a class="nav-link" href="#">예매하기</a></li>
				<li class="nav-item"><a class="nav-link" href="#">나의 예매정보</a></li>
			</ul>
		</div>
		<div class="my-2 my-lg-0">
			<ul class = "navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="#" id = "loginBtn">로그인</a></li>
				<li class="nav-item"><a class="nav-link" href="#" id = "LogoutBtn">로그아웃</a></li>
				<li class="nav-item"><a class="nav-link" href="regi.do" id = "regiBtn">회원가입</a></li>
			</ul>
		</div>
	</nav>
	
	
	<script type="text/javascript">

	$(document).ready(function(){
		if('<%=request.getSession().getAttribute("login")%>' != 'null') {
			$("#loginBtn").hide();
			$("#logoutBtn").show();
			$("#regiBtn").hide();
			
		} else if('<%=request.getSession().getAttribute("login") %>' == 'null') {
			$("#loginBtn").show();
			$("#logoutBtn").hide();
			$("#regiBtn").show();			
			
		}
		
	});
	</script>