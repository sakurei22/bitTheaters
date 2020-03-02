<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../../include/header.jsp"%>
<!-- Page Content -->
<div class="container" style="height: 670px;">

	<div class="row justify-content-center">
		<div class="col-lg-5">
			<div class="card shadow-lg border-0 rounded-lg mt-5">
				<div class="card bg-secondary mb-3">
					<div class="card-header">
						<h3 class="text-center font-weight-light my-4">비트 영화관 로그인</h3>
					</div>
					<div class="card-body">
						<div class="form-group">
							<label class="small mb-1" for="id">ID</label><input
								class="form-control py-4" id="id" type="text"
								placeholder="ID" />
						</div>
						<div class="form-group">
							<label class="small mb-1" for="pwd">Password</label><input
								class="form-control py-4" id="pwd" type="password"
								placeholder="Password" />
						</div>

						<div
							class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
							<a class="small" href="password.do">비밀번호 찾기</a>
							<button id = "_btnLogin" class="btn btn-primary">Login</button>
						</div>
					</div>

					<div class="card-footer text-center">
						<div class="small">
							<a href="regi.do">회원가입</a>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">

$("#_btnLogin").click(function() {	
	if( $("#id").val().trim() == "" ){
		alert("id를 입력해 주십시오");
		$("#id").focus();
	}
	else if( $("#pwd").val().trim() == "" ){
		alert("password를 입력해 주십시오");
		$("#pwd").focus();
	}
	else{
		$.ajax({
			url : "./loginAf.do",
			type : "post",
			data : {
				"user_id" : $("#id").val(),
				"user_pwd" : $("#pwd").val()
			},
			dataType : "json",
			async : true,
			success : function(resp) {
				if(resp.status=="ok"){
					alert(resp.nickname+"님 환영합니다!");
					
					location.href="movieList.do"
				} else {
					alert("id 혹은 패스워드가 틀렸습니다.");
					$("#pwd").val("");
				}
				
			},
			error : function( jqXHR, textStatus, errorThrown ) {

				alert( jqXHR.status );

				alert( jqXHR.statusText );

				alert( jqXHR.responseText );

				alert( jqXHR.readyState );

				}
		});		
	}	
});
</script>

<%@ include file="./../../include/footer.jsp"%>