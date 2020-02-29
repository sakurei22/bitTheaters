package bit.com.theaters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.theaters.model.MovieDto;
import bit.com.theaters.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	MovieService movieService;

	@RequestMapping(value = "movieList.do", method= RequestMethod.GET)
	public String moveList(Model model) {
		
		List<MovieDto> list = movieService.getMovieList();
		model.addAttribute("movieList", list);
		
		return "theatersList";
	}
	
}
