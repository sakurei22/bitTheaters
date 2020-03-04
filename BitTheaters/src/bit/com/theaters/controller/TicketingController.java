package bit.com.theaters.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.theaters.model.TicketDto;
import bit.com.theaters.model.UserDto;
import bit.com.theaters.service.TicketingService;


@Controller
public class TicketingController {
	@Autowired
	TicketingService ticketService;
	
	@RequestMapping(value = "reservation.do", method=RequestMethod.GET)
	public String reservation(Model model, String ticket_num) {
		
		int ticket_number = Integer.parseInt(ticket_num);
		TicketDto reservTicket = ticketService.getReservation(ticket_number);
		
		model.addAttribute("reservTicket", reservTicket);
		
		return "reservation";
	}
	
	@RequestMapping(value = "reservHistory.do", method=RequestMethod.GET)
	public String reservHistory(Model model, String user_id) {
		
		List<TicketDto> list = ticketService.getReservList(user_id);
		model.addAttribute("reservList", list);
		return "reservHistory";
	}
	
	@ResponseBody
	@RequestMapping(value = "ticketingAf.do", method = RequestMethod.POST)
	public Map<String, Object> ticketing(TicketDto ticket) {
		Map<String, Object> rmap = new HashMap<String, Object>();
		
		

		int count = ticketService.addTicket(ticket);
		if (count == 1) {
			int ticket_num = ticketService.getTicketNum(ticket.getUser_id());
			rmap.put("status", "ok");
			rmap.put("ticket_num", ticket_num);
		} else {
			rmap.put("status","no");
		}

		return rmap;
	}
	
	@RequestMapping(value = "ticket.do", method = RequestMethod.GET)
	public String ticket() {
		return "ticket";
	}

	@ResponseBody
	@RequestMapping(value = "theaterlist.do", method = RequestMethod.POST)
	public Map<String, Object> theaterlist(String movieNum) {
		Map<String, Object> tmap = new HashMap<String, Object>();

		if (movieNum.contentEquals("1")) {
			tmap.put("one","상봉");
			tmap.put("two","건대");
			tmap.put("three","강남");
			
		} else if (movieNum.contentEquals("2")) {
			tmap.put("one","홍대");
			tmap.put("two","신촌");
			tmap.put("three","강남");
			
		} else if (movieNum.contentEquals("3")) {
			tmap.put("one","상봉");
			tmap.put("two","건대");
			tmap.put("three","강남");
			
		} else if (movieNum.contentEquals("4")) {
			tmap.put("one","홍대");
			tmap.put("two", "신촌");
			tmap.put("three", "강남");
			
		} else if (movieNum.contentEquals("5")) {
			tmap.put("one","상봉");
			tmap.put("two", "건대");
			tmap.put("three","강남");
			
		} else if (movieNum.contentEquals("6")) {
			tmap.put("one", "홍대");
			tmap.put("two", "신촌");
			tmap.put("three","강남");
			
		} else if (movieNum.contentEquals("7")) {
			tmap.put("one","상봉");
			tmap.put("two","건대");
			tmap.put("three", "강남");
		}


		return tmap;
	}
	
	@ResponseBody
	@RequestMapping(value = "timelist.do", method = RequestMethod.POST)
	public Map<String, Object> timelist(String movieNum, String theater) {
		Map<String, Object> tmap = new HashMap<String, Object>();

		if (movieNum.contentEquals("1")) {
			if(theater.contentEquals("상봉")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			} else if(theater.contentEquals("건대")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			} else if(theater.contentEquals("강남")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			}
		} else if (movieNum.contentEquals("2")) {
			if(theater.contentEquals("홍대")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			} else if(theater.contentEquals("신촌")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			} else if(theater.contentEquals("강남")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			}
		} else if (movieNum.contentEquals("3")) {
			if(theater.contentEquals("상봉")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			} else if(theater.contentEquals("건대")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			} else if(theater.contentEquals("강남")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			}
			
		} else if (movieNum.contentEquals("4")) {
			if(theater.contentEquals("홍대")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			} else if(theater.contentEquals("신촌")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			} else if(theater.contentEquals("강남")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			}
			
		} else if (movieNum.contentEquals("5")) {
			if(theater.contentEquals("상봉")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			} else if(theater.contentEquals("건대")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			} else if(theater.contentEquals("강남")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			}
			
		} else if (movieNum.contentEquals("6")) {
			if(theater.contentEquals("홍대")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			} else if(theater.contentEquals("신촌")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			} else if(theater.contentEquals("강남")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			}
			
		} else if (movieNum.contentEquals("7")) {
			if(theater.contentEquals("상봉")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			} else if(theater.contentEquals("건대")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			} else if(theater.contentEquals("강남")) {
				tmap.put("one","10:00");
				tmap.put("two","18:20");
				tmap.put("three","22:10");
			}
		}


		return tmap;
	}
}
