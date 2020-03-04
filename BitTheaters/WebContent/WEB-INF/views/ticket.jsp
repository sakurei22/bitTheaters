<%@page import="bit.com.theaters.model.UserDto"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="bit.com.theaters.model.MovieDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../../include/header.jsp"%>

<%
	List<MovieDto> movieList = (List<MovieDto>) request.getSession().getAttribute("movieList");
UserDto user = (UserDto)request.getSession().getAttribute("login");
	
%>

<style>

.bg { background-color: #D9230F;
 color : white;
 font-weight: 400;
 }
 .bg:hover {
 background-color: #D9230F;
 color : white;
 font-weight: 400;
 text-decoration: none;
 cursor: text;
 }
</style>
<!-- Page Content -->

<div class="container" style="height: 650px;">

	<!-- Page Heading/Breadcrumbs -->
	<h1 class="mt-4 mb-3">: 비트 영화관 예매 :</h1>
	<div class="row">
		<div class="col-lg-3">
			<div class="bs-component">
				<ul class="list-group">
					<%
						for (int i = 0; i < movieList.size(); i++) {
							MovieDto movie = movieList.get(i);
					%>
					<li class="list-group-item d-flex justify-content-between align-items-center">
						<a href="#" value = "<%=i+1%>" title="<%=movie.getMovie_title()%>" class = "movielist"><%=movie.getMovie_title()%></a>
					</li>
					
					<%
						}
					%>
				</ul>

			</div>
		</div>
		<div class="col-lg-3" id="theater"></div>
		<div class="col-lg-3" id="date"></div>
		<div class="col-lg-3" id="times"></div>
	</div>
</div>
<div class="modal" id="popup">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"><%=user.getUser_nickname() %>님이 선택하신 영화 내역입니다.</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="declose">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <ul id="movie_ticket_final">
		</ul>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
	var movieChoiceNum; 
	var movieTitle;
	var theater;
	var choiceDate;
	var time;

	$(".movielist").click(function() {
		$("#theater").empty();
		$("#date").empty();
		$("#times").empty();
		movieChoiceNum = $(this).attr("value");
		movieTitle = $(this).attr("title");
		$(".movielist").removeClass("bg");
		$(this).addClass("bg");
		$.ajax({
			type : "post",
			url : "./theaterlist.do",
			data : {
				"movieNum" : movieChoiceNum
			},
			success : function(data) {
				
				$("#theater").append(
						"<div class='bs-component'>"
						+ "<ul class='list-group'>"
						+"<li class='list-group-item d-flex justify-content-between align-items-center'>"
						+ "<a href='#' value='"+data.one+"' class='theaterlist'>"+data.one
						+"</a></li>"
						+"<li class='list-group-item d-flex justify-content-between align-items-center'>"
						+ "<a href='#' value='"+data.two+"' class='theaterlist'>"+data.two+"</a></li>"
						+"<li class='list-group-item d-flex justify-content-between align-items-center'>"
						+ "<a href='#' value='"+data.three+"' class='theaterlist'>"+data.three+"</a></li>"
						+ "</ul></div>");
			},
			error : function( jqXHR, textStatus, errorThrown ) {

				alert( jqXHR.status );

				alert( jqXHR.statusText );

				alert( jqXHR.responseText );

				alert( jqXHR.readyState );

				}
			});
		});
	
		$(document).on("click", ".theaterlist", function(){
			theater = $(this).attr("value");
			$("#date").empty();
			$("#times").empty();
			$(".theaterlist").removeClass("bg");
			$(this).addClass("bg");

			$("#date").append(
					"<div class='bs-component'>"
					+ "<ul class='list-group'>"
					+ "<li class='list-group-item d-flex justify-content-between align-items-center'>"
					+"Date: <input type='text' id='datepicker' class='datepic'></li></ul></div>");
			
	
		});
		
		$(document).on("click",".datepic",function(){
			$( "#datepicker" ).datepicker({
			    dateFormat: 'yy-mm-dd',
			    prevText: '이전 달',
			    nextText: '다음 달',
			    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
			    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
			    dayNames: ['일','월','화','수','목','금','토'],
			    dayNamesShort: ['일','월','화','수','목','금','토'],
			    dayNamesMin: ['일','월','화','수','목','금','토'],
			    showMonthAfterYear: true,
			    changeMonth: true,
			    changeYear: true,
			    yearSuffix: '년',
			    minDate :"+1D",
			    maxDate : "+7D",
			    onSelect  : function(dateText, inst){
					choiceDate = $(this).val();
					$.ajax({
						type : "post",
						url : "./timelist.do",
						data : {
							"movieNum" : movieChoiceNum,
							"theater" : theater
						},
						success : function(data) {
							
							$("#times").append(
									"<div class='bs-component'>"
									+ "<ul class='list-group'>"
									+"<li class='list-group-item d-flex justify-content-between align-items-center'>"
									+ "<a href='#' value='"+data.one+"' class='timelist'>"+data.one
									+"</a></li>"
									+"<li class='list-group-item d-flex justify-content-between align-items-center'>"
									+ "<a href='#' value='"+data.two+"' class='timelist'>"+data.two+"</a></li>"
									+"<li class='list-group-item d-flex justify-content-between align-items-center'>"
									+ "<a href='#' value='"+data.three+"' class='timelist'>"+data.three+"</a></li>"
									+ "</ul></div>");
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
		});
		
		$(document).on("click", ".timelist", function(){
			time = $(this).attr("value");
			
			$(".timelist").removeClass("bg");
			$(this).addClass("bg");
			$("#movie_ticket_final").empty(); 
			var liList = "<li> 영화 제목 : "+movieTitle+"</li>";
			liList += "<li> 극장 : "+theater+"</li>";
			liList += "<li> 예매일 : " + choiceDate +"</li>";
			liList += "<li> 영화 시간 : "+time+"</li>";
			liList += "<div align ='center' style = 'margin-top : 25px;'>";
			liList += "<button type = 'button' id = 'ticketingAfBtn' class='btn btn-primary' style='margin-right:10px;'>예매하기</button>";
			liList += "<button type = 'button' id = 'returnBtn' class='btn btn-primary'>돌아가기</button></div>";

			$("#movie_ticket_final").append(liList); 
			$("#popup").css("display","block");

		});

		$(document).on("click", "#declose", function() {
			//alert("close 클릭");
			$("#popup").css("display", "none");
			$("#movie_ticket_final").empty(); 
		});

		$(document).on("click", "#ticketingAfBtn", function(){

			var ticketdto = {
					"ticket_title": movieTitle,
					"ticket_date": choiceDate,
					"ticket_time" : time,
					"ticket_place" : theater,
					"user_id" : "<%=user.getUser_id()%>"
					}
			
			$.ajax({
				type : "post",
				url : "./ticketingAf.do",
				data : ticketdto,
				success : function(data) {
					if(data.status=="ok"){
						alert("예매에 성공하셨습니다!")
						var ticket_num = data.ticket_num;
						location.href="./reservation.do?ticket_num="+ticket_num;
					} else {
						alert("예메에 실패하셨습니다.");
					}
				},
				error : function( jqXHR, textStatus, errorThrown ) {

					alert( jqXHR.status );

					alert( jqXHR.statusText );

					alert( jqXHR.responseText );

					alert( jqXHR.readyState );

					}
		});
		});

		$(document).on("click", "#returnBtn", function(){
			$("#popup").css("display","none");
			
		});

</script>

<%@ include file="./../../include/footer.jsp"%>