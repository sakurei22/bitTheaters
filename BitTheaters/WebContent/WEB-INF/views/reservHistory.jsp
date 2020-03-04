<%@page import="bit.com.theaters.model.TicketDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../include/header.jsp"%>
<%

List<TicketDto> list = (List<TicketDto>)request.getAttribute("reservList");
%>
<div class="container" style="height: 670px;">
<h1 class="mt-4 mb-3">: 비트 영화관 예매 내역 :</h1>

<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">no</th>
      <th scope="col">영화제목</th>
      <th scope="col">극장</th>
      <th scope="col">일시</th>
      <th scope="col">시간</th>
    </tr>
  </thead>
  <tbody>
  	<% 
  	if( list.size()==0){
  		%>
  	    <tr class="table-default" align="center">
        <th colspan="5" >영화를 예매해주세요~ ^^;;</th>
      </tr>
      <%
  	} else {
  	
  		for(int i = 0; i < list.size(); i++){
  		TicketDto ticket = list.get(i);
  		%>
    <tr class="table-default">
      <th scope="row"><%=i+1 %></th>
      <td><%=ticket.getTicket_title() %></td>
      <td><%=ticket.getTicket_place() %></td>
      <td><%=ticket.getTicket_date() %></td>
      <td><%=ticket.getTicket_time() %></td>
    </tr>
    
    <%}
  		}%>
    </tbody>
    </table>

</div>

<%@ include file="./../../include/footer.jsp"%>