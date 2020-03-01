package bit.com.theaters.service;

import java.util.List;

import bit.com.theaters.model.MovieDto;

public interface MovieService {

	public List<MovieDto> getMovieList();
	public MovieDto getMovie(int movieNum);
	
}
