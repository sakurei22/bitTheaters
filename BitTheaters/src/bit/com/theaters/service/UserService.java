package bit.com.theaters.service;

import bit.com.theaters.model.UserDto;

public interface UserService {
	public int idCheck(String id);
	public int addUser(UserDto user);
	public UserDto loginCheck(UserDto user);
}
