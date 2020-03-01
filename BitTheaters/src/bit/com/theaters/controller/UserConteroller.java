package bit.com.theaters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.theaters.model.UserDto;
import bit.com.theaters.service.UserService;

@Controller
public class UserConteroller {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "regi.do" , method= RequestMethod.GET)
	public String regi(){
		
		return "regi";
	}
	
	@ResponseBody
	@RequestMapping(value = "idcheck.do", method = RequestMethod.POST, produces = "application/String; charset=utf-8")
	public String idcheck(String id) {
		String str = "";

		int count = userService.idCheck(id);
		if (count == 1) {
			str = "no";
		} else {
			str = "ok";
		}

		return str;
	}
	

	@ResponseBody
	@RequestMapping(value = "regiAf.do", method = RequestMethod.POST, produces = "application/String; charset=utf-8")
	public String regiAf(UserDto user) {
		int status = userService.addUser(user);

		String str = "";
		if (status == 1) {
			str = "ok";
		} else {
			str = "no";
		}
		return str;
	}
}
