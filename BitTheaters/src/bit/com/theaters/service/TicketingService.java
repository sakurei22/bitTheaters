package bit.com.theaters.service;

import java.util.List;

import bit.com.theaters.model.TicketDto;

public interface TicketingService {
	public int addTicket(TicketDto ticket);
	public int getTicketNum(String user_id);
	public TicketDto getReservation(int ticket_number);
	public List<TicketDto> getReservList(String user_id);
	public int cancleTicket(int ticket_num);
}
