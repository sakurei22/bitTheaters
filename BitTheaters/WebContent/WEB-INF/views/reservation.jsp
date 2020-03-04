<%@page import="bit.com.theaters.model.TicketDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./../../include/header.jsp"%>

<%

TicketDto reservTicket = (TicketDto)request.getAttribute("reservTicket");

%>

<div class="container" style="height: 670px;">
<h1 class="mt-4 mb-3">: 비트 영화관 예매 확인 :</h1>
	<div class="row justify-content-center">
		<div class="col-lg-6">
			<div class="card shadow-lg border-0 rounded-lg mt-5">
				<div class="card bg-secondary mb-3">
					<div class="card-body">
						<div class="form-group">
							<ul>
								<li>제목 : ${reservTicket.ticket_title }</li>
								<li>극장 : ${reservTicket.ticket_place }</li>
								<li>상영일 : ${reservTicket.ticket_date }</li>
								<li>상영시간 : ${reservTicket.ticket_time }</li>
								<li>예매일 :${reservTicket.ticket_reserv_date }</li>
							</ul>
								
						
						</div>
						<div align ="right"><button type = "button" id = "returnBtn" class="btn btn-primary">돌아가기</button></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

$(document).on("click", "#returnBtn", function(){
	location.href = "movieList.do";
	
});

</script>
<%@ include file="./../../include/footer.jsp"%>