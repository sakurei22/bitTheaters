package bit.com.theaters.dao.impl;

import java.util.List;

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
	@Override
	public int getTicketNum(String user_id) {
		int ticket_num = sqlSession.selectOne(namespace+"getTicketNum", user_id);
		return ticket_num;
	}
	@Override
	public TicketDto getReservation(int ticket_number) {
		TicketDto reserv = sqlSession.selectOne(namespace+"getReservation", ticket_number);
		return reserv;
	}
	@Override
	public List<TicketDto> getReservList(String user_id) {
		List<TicketDto> list = sqlSession.selectList(namespace+"getReservList", user_id);
		return list;
	}

}
