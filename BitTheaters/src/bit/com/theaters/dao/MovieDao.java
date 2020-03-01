package bit.com.theaters.dao;

import java.util.List;

import bit.com.theaters.model.MovieDto;

public interface MovieDao {
	
	public List<MovieDto> getMovieList();
	public MovieDto getMovie(int movieNum);

}
