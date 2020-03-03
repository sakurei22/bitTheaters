package bit.com.theaters.service.impl;

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

}
