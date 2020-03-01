<%@page import="java.text.DecimalFormat"%>
<%@page import="bit.com.theaters.model.MovieDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<MovieDto> movieList = (List<MovieDto>) request.getAttribute("movieList");
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
						<img style="width: 100%; display: block;"
							src="<%=movie.getMovie_poster()%>"
							alt="<%=movie.getMovie_title()%>">
						<div class="card-body">
							<h5 class="card-title" style ="color:#ba0000;"><%=movie.getMovie_title()%></h5>
						</div>
						<ul class="list-group list-group-flush">
							<li class="list-group-item"><strong>예매율</strong> : <%=movie.getMovie_ticketing() %></li>
							<li class="list-group-item"><strong>like</strong> : <%=toNumFormat(movie.getMovie_like()) %></li>
						</ul>
						<div class="card-footer text-muted" align = "right">
							<button type="button" class="btn btn-primary btn-sm">예매하기</button>
						</div>
					</div>
				</div>
			</div>


			<%
				}
			%>
		</div>

		<!-- Pagination
		<ul class="pagination justify-content-center">
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span
					class="sr-only">Previous</span>
			</a></li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
					class="sr-only">Next</span>
			</a></li>
		</ul>
-->
	</div>
	<!-- /.container -->

<%@ include file="./../../include/footer.jsp"%>