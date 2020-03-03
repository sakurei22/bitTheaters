<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bit Theaters : 비트 영화관</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
				<li class="nav-item"><a class="nav-link" href="#" id = "ticketingBtn">예매하기</a></li>
				<li class="nav-item"><a class="nav-link" href="#">나의 예매정보</a></li>
			</ul>
		</div>
		<div class="my-2 my-lg-0">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="login.do" id="loginBtn">로그인</a></li>
				<li class="nav-item"><a class="nav-link" href="regi.do" id="regiBtn">회원가입</a></li>
				<li class="nav-item"><a class="nav-link" href="#" id="logoutBtn">로그아웃</a></li>
			</ul>
		</div>
	</nav>

	<script type="text/javascript">

	$(document).ready(function(){
		if('<%=request.getSession().getAttribute("login")%>' != 'null') {
			$("#loginBtn").hide();
			$("#regiBtn").hide();
			$("#logoutBtn").show();
		} else if('<%=request.getSession().getAttribute("login")%>' == 'null') {
			$("#loginBtn").show();
			$("#regiBtn").show();
			$("#logoutBtn").hide();
		}

		//로그아웃 시도시 처리 
		$(document).on("click", "#logoutBtn", function() {

			if (confirm("정말 로그아웃하시겠습니까?")) {
				//확인버튼 클릭시 동작
				$.ajax({
					url : "logout.do",
					type : "get",
					success : function() {
						//alert("통신성공");
						alert("로그아웃되셨습니다. 감사합니다.");
						$("#loginBtn").show();
						$("#regiBtn").show();
						$("#logoutBtn").hide();
						location.href = "movieList.do";
					},
					error : function() {
						alert("통신실패");
					}
				});
			} else {
				//취소버튼 클릭시 동작 
			}
		});

		$("#ticketingBtn").click(function(){
			if('<%=request.getSession().getAttribute("login")%>' == 'null'){
				location.href="login.do";
			} else if('<%=request.getSession().getAttribute("login")%>' != 'null'){
				location.href="ticket.do";
			}
			
		});

	});
	</script>