package bit.com.theaters.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.theaters.dao.TicketingDao;
import bit.com.theaters.model.TicketDto;
import bit.com.theaters.service.TicketingService;

@Service
public class TicketingServiceImpl implements TicketingService {
	
	@Autowired
	TicketingDao ticketDao;

	@Override
	public int addTicket(TicketDto ticket) {
		return ticketDao.addTicket(ticket);
	}

	@Override
	public int getTicketNum(String user_id) {
		return ticketDao.getTicketNum(user_id);
	}

	@Override
	public TicketDto getReservation(int ticket_number) {
		return ticketDao.getReservation(ticket_number);
	}

	@Override
	public List<TicketDto> getReservList(String user_id) {
		return ticketDao.getReservList(user_id);
	}

}
