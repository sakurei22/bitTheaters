package bit.com.theaters.dao;

import bit.com.theaters.model.UserDto;

public interface UserDao {
	public int idCheck(String id);
	public int addUser(UserDto user);
	public UserDto loginCheck(UserDto user);

}
