<%@page import="bit.com.theaters.model.MovieDto"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	
	<%
	MovieDto movie = (MovieDto)request.getAttribute("selectMovie");
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
	<h1 class="mt-4 mb-3">
		: 비트 영화관 : <small style="color: #ba0000;"> Bit Theaters</small>
	</h1>

	   <div class="row">

      <div class="col-md-5">
        <img width="410" src="${selectMovie.movie_poster }" alt="">
      </div>

      <div class="col-md-6">
        <h3 class="my-3">${selectMovie.movie_title }</h3>
        <p>${selectMovie.movie_title_e }</p>
        <h3 class="my-3">Information</h3>
        <ul>
          <li>감독 : ${selectMovie.movie_director }</li>
          <li>배우 : ${selectMovie.movie_actor}</li>
          <li>장르 : ${selectMovie.movie_genre }</li>
          <li>기본 : ${selectMovie.movie_basic }</li>
        </ul>
        <button type="button" id ="ticketingBtn" class="btn btn-primary btn-sm" movienum ="${selectMovie.movie_num }">예매하기</button>
      </div>
	
    </div>
    <!-- /.row -->
	<div style = "margin-bottom : 10px;"></div>
</div>

<%@ include file="./../../include/footer.jsp"%>