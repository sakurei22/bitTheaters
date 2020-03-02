package bit.com.theaters.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	public String moveList(HttpSession session) {
		
		List<MovieDto> list = movieService.getMovieList();
		session.setAttribute("movieList", list);
		
		return "theatersList";
	}
	
	@RequestMapping(value = "selectMovie.do", method= RequestMethod.GET)
	public String selectMovie(Model model, int movieNum) {
		MovieDto movie = movieService.getMovie(movieNum);
		model.addAttribute("selectMovie", movie);
		
		return "movieDetail";
	}
	
}
