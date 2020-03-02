package bit.com.theaters.dao.impl;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.theaters.dao.UserDao;
import bit.com.theaters.model.UserDto;


@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "User.";

	@Override
	public int idCheck(String id) {
		int status = sqlSession.selectOne(namespace+"idCheck", id);
		return status;
	}

	@Override
	public int addUser(UserDto user) {
		int status = sqlSession.insert(namespace+"addUser", user);
		return status;
	}

	@Override
	public UserDto loginCheck(UserDto user) {
		UserDto dto = sqlSession.selectOne(namespace+"loginCheck", user);
		return dto;
	}

}
