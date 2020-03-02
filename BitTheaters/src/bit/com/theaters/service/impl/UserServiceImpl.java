package bit.com.theaters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.theaters.dao.UserDao;
import bit.com.theaters.model.UserDto;
import bit.com.theaters.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public int idCheck(String id) {
		return userDao.idCheck(id);
	}

	@Override
	public int addUser(UserDto user) {
		return userDao.addUser(user);
	}

	@Override
	public UserDto loginCheck(UserDto user) {
		return userDao.loginCheck(user);
	}

}
