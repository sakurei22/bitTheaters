package bit.com.theaters.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.theaters.dao.TicketingDao;
import bit.com.theaters.model.TicketDto;

@Repository
public class TicketingDaoImpl implements TicketingDao {

	@Autowired
	SqlSession sqlSession;
	
	String namespace = "Ticket.";
	@Override
	public int addTicket(TicketDto ticket) {
		int status = sqlSession.insert(namespace + "addTicket", ticket);
		return status;
	}

}
