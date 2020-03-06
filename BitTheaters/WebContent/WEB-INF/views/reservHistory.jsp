

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="bit.com.theaters.model.TicketDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../include/header.jsp"%>
<%

List<TicketDto> list = (List<TicketDto>)request.getAttribute("reservList");
LocalDate today = LocalDate.now();

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
      <th scope="col">예매취소</th>
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
      <td>
      <% if(ticket.getTicket_auth()==1){ %>
     	예매취소완료
      <%} else if(ticket.getTicket_auth()==0){
    	  LocalDate date = LocalDate.parse(ticket.getTicket_date(), DateTimeFormatter.ISO_DATE);
      		if(date.compareTo(today) >= 1){
      %>
      	<a href ="#" id="cancleBtn" value ="<%=ticket.getTicket_num()%>">취소</a>
      	<%} else {
      		%>
      		취소 불가
      	<%} %>
      <%} %>
      </td>
    </tr>
    
    <%}
  		}%>
    </tbody>
    </table>

</div>

<script type="text/javascript">
$(document).on("click", "#cancleBtn", function(){
	var result = confirm("정말 취소하시겠습니까?");

	if(result){
		$.ajax({
			url : "./cancleTicketAf.do",
			type : "post",
			data : {
				"ticket_number" : "$(this).attr('value')"
			},
			async : true,
			success : function(resp) {
				if(resp.trim()=="ok"){
					alert("취소에 성공하셨습니다."); 
					} else {
					alert("취소에 실패하였습니다.");
				}
				
			},
			error : function( jqXHR, textStatus, errorThrown ) {

				alert( jqXHR.status );

				alert( jqXHR.statusText );

				alert( jqXHR.responseText );

				alert( jqXHR.readyState );

				}
		});		

	} else {
		return;
		}
}
</script>

<%@ include file="./../../include/footer.jsp"%>