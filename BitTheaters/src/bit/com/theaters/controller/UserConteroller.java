package bit.com.theaters.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value = "login.do" , method= RequestMethod.GET)
	public String login(){
		
		return "userLogin";
	}
	

	@ResponseBody
	@RequestMapping(value = "loginAf.do", method = RequestMethod.POST)
	public Map<String, Object> loginAf(UserDto user, HttpSession session) {
		UserDto dto = userService.loginCheck(user);
		Map<String, Object> rmap = new HashMap<String, Object>();

		if (dto != null && dto.getUser_id().equals("") == false) {
			if (dto.getUser_auth() == 3) {
				//logger.info(dto.toString());
				session.setAttribute("login", dto);
				session.setMaxInactiveInterval(60*60*365);
				//req.getSession().setAttribute("login",login);
				//req.getSession().setMaxInactiveInterval(60*60*365);
				rmap.put("status", "ok");
				rmap.put("nickname", dto.getUser_nickname());
			} else {
				//logger.info("탈퇴자");
				rmap.put("status", "no");
			}
		} else {
			//logger.info("no dto");
			rmap.put("status", "no");
		}
		
		return rmap;
	}
	

	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public void logout(HttpSession session, HttpServletResponse resp) throws IOException {
		session.invalidate();
		resp.sendRedirect("movieList.do");
	}
}
