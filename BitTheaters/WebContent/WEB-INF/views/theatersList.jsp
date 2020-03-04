<%@page import="java.text.DecimalFormat"%>
<%@page import="bit.com.theaters.model.MovieDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<MovieDto> movieList = (List<MovieDto>) request.getSession().getAttribute("movieList");
%>

<%!

	public String toNumFormat(int num){
	DecimalFormat df = new DecimalFormat("#,###");
	return df.format(num);
}
%>
<%@ include file="./../../include/header.jsp"%>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">
			: 비트 영화관 무비 차트 : <small style = "color :#ba0000;">인기 상영작 순</small>
		</h1>

		<div class="row">
			<%
				for (int i = 0; i < movieList.size(); i++) {
					MovieDto movie = movieList.get(i);
			%>
			<div class="col-lg-4">
				<div class="bs-component">
					<div class="card mb-3">
						<h3 class="card-header">
							No<%=i + 1%></h3>
						<a href="#" onclick ="selectMovie(<%=movie.getMovie_num()%>)"><img style="width: 100%; display: block;"
							src="<%=movie.getMovie_poster()%>"
							alt="<%=movie.getMovie_title()%>"></a>
						<div class="card-body">
							<h5 class="card-title" style ="color:#ba0000;"><%=movie.getMovie_title()%></h5>
						</div>
						<ul class="list-group list-group-flush">
							<li class="list-group-item"><strong>예매율</strong> : <%=movie.getMovie_ticketing() %></li>
							<li class="list-group-item"><strong>like</strong> : <%=toNumFormat(movie.getMovie_like()) %></li>
						</ul>
					</div>
				</div>
			</div>

			<%
				}
			%>
		</div>
	</div>
	<!-- /.container -->
	
<script type="text/javascript">

function selectMovie(movie_num){
	location.href="selectMovie.do?movieNum="+movie_num;
}

$(document).ready(function () {
	$("#ticketingBtn").click(function(){
		if('<%=request.getSession().getAttribute("login")%>' == 'null'){
			alert("로그인이 필요합니다.");
			location.href="login.do";
		} else if('<%=request.getSession().getAttribute("login")%>' != 'null'){
			alert($("#ticketingBtn").movienum());
			
			//location.href="ticket.do";
		}
		
		
		});
	
});

function ticketing(num){

	if('<%=request.getSession().getAttribute("login")%>' == 'null'){
		alert("로그인이 필요합니다.");
		location.href="login.do";
	} else if('<%=request.getSession().getAttribute("login")%>' != 'null'){
		alert(num);
		
		//location.href="ticket.do";
	}
	
}

</script>

<%@ include file="./../../include/footer.jsp"%>