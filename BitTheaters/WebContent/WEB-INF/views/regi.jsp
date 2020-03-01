<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../../include/header.jsp"%>

<!-- Page Content -->
<div class="container">
	<h1 class="mt-4 mb-3">
		: 비트 영화관 회원가입 : <small style="color: #ba0000;"> Bit Theaters Sign Up</small>
	</h1>
	<div class="col-lg-6">
		<div class="bs-component">
			<div class="form-group">
				<div>
					<label class="col-form-label" for="id">ID </label> 
				</div>
				<div style="float:left; margin-right : 5px;">
					<input type="text" class="form-control" id="id" placeholder="ID">
				</div>
				<div style="float:left; margin-right : 5px;">
					<button type="button" id="idcheckBtn" class="btn btn-primary">ID Check</button>
				</div>
				<div style = "clear : left"></div>
				<p id="idcheck" style="font-size: 9px">ID를 입력해주세요.</p>
			</div>
			<div class="form-group">
				<label class="col-form-label" for="pwd">Password</label> 
				<input type="password" class="form-control" id="pwd" placeholder="Password">
			</div>
			<div class="form-group">
				<label class="col-form-label" for="name">Name </label> 
				<input type="text" class="form-control" id="name" placeholder="Name" maxlength="20">
			</div>
			<div class="form-group">
				<label class="col-form-label" for="nickname">Nickname </label> 
				<input type="text" class="form-control" id="nickname" placeholder="Nickname" maxlength="20">
			</div>
			<div class="form-group">
				<div>
					<label class="col-form-label" for="Phone">Phone </label> 
				</div>
				<div style="float:left; margin-right : 5px;">
			      <select class="form-control" id="phone1">
			        <option value = "010" selected="selected">010</option>
			        <option value = "011">011</option>
			        <option value = "017">017</option>
			      </select>
			     </div>
			    <div style="float:left; margin-right : 5px;">
					<input type="text" class="form-control" id="phone2" maxlength="4" numberOnly>
				</div>
				<div style="float:left; margin-right : 5px;">
					<input type="text" class="form-control" id="phone3" maxlength="4" numberOnly>
				</div>
				<div style = "clear : left"></div>
			</div>
			<div class="form-group">
				<label class="col-form-label" for="birth">Birth </label> 
				<input type="date" class="form-control" id="birth" min="1960-01-01" max = "2010-01-01">
			</div>
			<div class="form-group">
				<label class="col-form-label" for="id">E-mail</label> 
				<input type="email" class="form-control" id="email" placeholder="bittheaters@bit.com">
			</div>
		</div>
	</div>
	<div align = "center" style = "margin-bottom : 10px;">
		<button type="button" id="signupBtn" class="btn btn-primary">회원가입</button>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function () {
		$("#idcheckBtn").click(function() {
			if($("#id").val().trim()==""){
				alert("아이디를 입력해주세요.");
				$("#id").focus();
			} else {
				$.ajax({
					type : "post",
					url : "./idcheck.do",
					data : {
						"id" : $("#id").val()
					},
					success : function(data) {
						//alert(data);
						//alert(data.trim());
						if (data.trim() == "ok") {
							$("#idcheck").css("color", "#0000ff");
							$("#idcheck").html('사용할 수 있는 id 입니다.');
						} else {
							$("#idcheck").css("color", "#ff0000");
							$("#idcheck").html("사용 중인 id 입니다.");
							$("#id").val("");
						}
					},
					error : function() {
						alert("실패");
					}
				});
			}
		});
		
		$("#signupBtn").click(function() {
			if($("#id").val().trim()==""){
				alert("아이디를 입력해주세요.");
				$("#id").focus();
			} else if($("#pwd").val().trim()==""){
				alert("패스워드를 입력해주세요.");
				$("#pwd").focus();
			} else if($("#name").val().trim()==""){
				alert("이름을 입력해주세요.");
				$("#name").focus();
			} else if($("#phone2").val().trim()=="" || $("#phone2").val().trim().length != 4){
				alert("핸드폰 번호를 정확히 입력해주세요.");
				$("#phone2").focus();
			} else if($("#phone3").val().trim()=="" || $("#phone2").val().trim().length != 4){
				alert("핸드폰 번호를 정확히 입력해주세요.");
				$("#phone3").focus();
			} else if($("#email").val().trim()==""){
				alert("이메일을 입력해주세요.");
				$("#email").focus();
			}  else if($("#birth").val().trim()==""){
				alert("생일을 입력해주세요.");
				$("#birth").focus();
			
			}else {

				if($("#nickname").val().trim()==""){
					$("#nickname").val($("#name").val());
				}
				var user = {
						user_id : $("#id").val(),
						user_pwd : $("#pwd").val(),
						user_phone : $("#phone1").val()+$("#phone2").val()+$("#phone3").val(),
						user_email : $("#email").val(),
						user_birth : $("#birth").val(),
						user_name : $("#name").val(),
						user_nickname : $("#nickname").val()
				};
				$.ajax({
					url : "./regiAf.do",
					data : user,
					type : "post",
					async : true,
					success : function(resp) {
						if(resp.trim()=="ok"){
							alert("비트 영화관 가입에 성공하셨습니다!")
							location.href="./movieList.do"
						} else {
							alert("가입에 실패하셨습니다.");
						}
					},
					error : function() {
						alert("e");
					}
				});
				
			}

		});
		$("input:text[numberOnly]").on("keyup", function() {
		    $(this).val($(this).val().replace(/[^0-9]/g,""));
		});
	});
</script>

<%@ include file="./../../include/footer.jsp"%>