package bit.com.theaters.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.theaters.dao.MovieDao;
import bit.com.theaters.model.MovieDto;
import bit.com.theaters.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDao movieDao;

	@Override
	public List<MovieDto> getMovieList() {
		return movieDao.getMovieList();
	}
	
}
