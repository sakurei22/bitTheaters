package bit.com.theaters.model;

import java.io.Serializable;

public class MovieDto implements Serializable {

	private String movie_title;
	private String movie_title_e;
	private String movie_poster;
	private int movie_num;
	private int movie_like;
	private String movie_ticketing;
	private String movie_director;
	private String movie_actor;
	private String movie_genre;
	private String movie_basic;
	
	public MovieDto() {
	}

	public MovieDto(String movie_title, String movie_title_e, String movie_poster, int movie_num, int movie_like,
			String movie_ticketing, String movie_director, String movie_actor, String movie_genre, String movie_basic) {
		super();
		this.movie_title = movie_title;
		this.movie_title_e = movie_title_e;
		this.movie_poster = movie_poster;
		this.movie_num = movie_num;
		this.movie_like = movie_like;
		this.movie_ticketing = movie_ticketing;
		this.movie_director = movie_director;
		this.movie_actor = movie_actor;
		this.movie_genre = movie_genre;
		this.movie_basic = movie_basic;
	}

	public MovieDto(String movie_title, String movie_poster, int movie_num, int movie_like, String movie_ticketing) {
		super();
		this.movie_title = movie_title;
		this.movie_poster = movie_poster;
		this.movie_num = movie_num;
		this.movie_like = movie_like;
		this.movie_ticketing = movie_ticketing;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public String getMovie_title_e() {
		return movie_title_e;
	}

	public void setMovie_title_e(String movie_title_e) {
		this.movie_title_e = movie_title_e;
	}

	public int getMovie_like() {
		return movie_like;
	}

	public void setMovie_like(int movie_like) {
		this.movie_like = movie_like;
	}

	public String getMovie_director() {
		return movie_director;
	}

	public void setMovie_director(String movie_director) {
		this.movie_director = movie_director;
	}

	public String getMovie_actor() {
		return movie_actor;
	}

	public void setMovie_actor(String movie_actor) {
		this.movie_actor = movie_actor;
	}

	public String getMovie_genre() {
		return movie_genre;
	}

	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}

	public String getMovie_basic() {
		return movie_basic;
	}

	public void setMovie_basic(String movie_basic) {
		this.movie_basic = movie_basic;
	}
	
	
	public String getMovie_poster() {
		return movie_poster;
	}

	public void setMovie_poster(String movie_poster) {
		this.movie_poster = movie_poster;
	}

	public int getMovie_num() {
		return movie_num;
	}

	public void setMovie_num(int movie_num) {
		this.movie_num = movie_num;
	}

	public String getMovie_ticketing() {
		return movie_ticketing;
	}

	public void setMovie_ticketing(String movie_ticketing) {
		this.movie_ticketing = movie_ticketing;
	}

	@Override
	public String toString() {
		return "MovieDto [movie_title=" + movie_title + ", movie_title_e=" + movie_title_e + ", movie_poster="
				+ movie_poster + ", movie_num=" + movie_num + ", movie_like=" + movie_like + ", movie_ticketing="
				+ movie_ticketing + ", movie_director=" + movie_director + ", movie_actor=" + movie_actor
				+ ", movie_genre=" + movie_genre + ", movie_basic=" + movie_basic + "]";
	}


	
}
