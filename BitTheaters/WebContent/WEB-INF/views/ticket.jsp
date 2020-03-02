<%@page import="bit.com.theaters.model.TheaterDto"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="bit.com.theaters.model.MovieDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../../include/header.jsp"%>

<%
	List<MovieDto> movieList = (List<MovieDto>) request.getSession().getAttribute("movieList");

	Map<String, TheaterDto> movieOne = new HashMap<String, TheaterDto>();
%>
<!-- Page Content -->
<div class="container" style="height: 650px;">

	<!-- Page Heading/Breadcrumbs -->
	<h1 class="mt-4 mb-3">: 비트 영화관 예매 :</h1>
	<div class="row">
		<div class="col-lg-4">
			<div class="bs-component">
				<div class="list-group">
					<span class="list-group-item"><strong>영화 제목</strong></span>
					<%
						for (int i = 0; i < movieList.size(); i++) {
							MovieDto movie = movieList.get(i);
					%>
					<a href="#" id="movie<%=i%>" 
						class="list-group-item list-group-item-action"><%=movie.getMovie_title()%></a>

					<%
						}
					%>
				</div>

			</div>
		</div>
		<div class="col-lg-4" id="theater"></div>
	</div>
</div>

<script type="text/javascript">
	$("a").click(function(){
		$("#theater").empty();
		$("a").removeClass("active");
		$(this).toggleClass("active");
		
		$("#theater").append("<div class='bs-component'><div class='list-group'><span class='list-group-item'><strong>극장</strong></span><a href='#' id='th1' class='list-group-item list-group-item-action'>상봉</a><a href='#' id='th2' class='list-group-item list-group-item-action'>강남</a><a href='#' id='th3' class='list-group-item list-group-item-action'>건대</a></div></div>");
		
	});

		
</script>

<%@ include file="./../../include/footer.jsp"%>