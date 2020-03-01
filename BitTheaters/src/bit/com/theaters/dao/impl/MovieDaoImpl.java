package bit.com.theaters.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import bit.com.theaters.dao.MovieDao;
import bit.com.theaters.model.MovieDto;

@Repository
public class MovieDaoImpl implements MovieDao {

	@Override
	public List<MovieDto> getMovieList() {

		Document doc;

		List<MovieDto> list = new ArrayList<MovieDto>();

		try {
			doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();

			// 영화제목
			Elements titles = doc.select("div.box-contents strong.title");

			// 예매율
			Elements ticketings = doc.select("div.box-contents strong.percent span");

			// 좋아요
			Elements likes = doc.select("div.box-contents span.count strong i");

			// 포스터 이미지
			Elements posters = doc.select("div.box-image span.thumb-image img");

			// 영화 번호
			Elements movie_nums = doc.select("div.box-contents span.like button.btn-like");

			for (int i = 0; i < 7; i++) {
				Element eTitle = titles.get(i); // 오브젝트
				String title = eTitle.text(); // 오브젝트를 텍스트로 변환

				Element ePoster = posters.get(i);
				String poster = ePoster.attr("src");

				Element eTicketing = ticketings.get(i);
				String ticketing = eTicketing.text();

				Element eMovie_num = movie_nums.get(i);
				String sMovie_num = eMovie_num.attr("value");

				int idx = sMovie_num.lastIndexOf("=");
				int movie_num = Integer.parseInt(sMovie_num.substring(idx + 1));

				Element eLike = likes.get(i);
				int like = Integer.parseInt(eLike.text().replace(",", ""));

				MovieDto dto = new MovieDto(title, poster, movie_num, like, ticketing);

				list.add(dto);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public MovieDto getMovie(int movieNum) {
		Document doc;
		
		MovieDto movie = null;
		try {
			doc = Jsoup.connect("http://www.cgv.co.kr/movies/detail-view/?midx="+movieNum).get();
			//제목
			Element eTitle = doc.selectFirst("div.box-contents div.title strong");
			String title = eTitle.text();
			//영문제목
			Element eEngTitle = doc.selectFirst("div.box-contents div.title p");
			String engTitle = eEngTitle.text();
			//포스터
			Element posters = doc.selectFirst("div.box-image span.thumb-image img");
			String poster = posters.attr("src");
			//좋아요
			Element likes = doc.selectFirst("div.box-contents span.count strong i");
			int like = Integer.parseInt(likes.text().replace(",", ""));

			Element eticketing = doc.selectFirst("div.box-contents strong.percent span");
			String ticketing = eticketing.text();
			
			Element edirector = doc.selectFirst("div.box-contents div.spec dl dd a");
			String director = edirector.text();
			
			Element actors = doc.selectFirst("div.box-contents div.spec dl dd.on");
			String actor = actors.text();
			
			Element egenre = actors.nextElementSibling();

			String sgenre = egenre.text();
			int idx = sgenre.lastIndexOf(":");
			String genre = sgenre.substring(idx+2);
			
			Element ebasic = egenre.nextElementSibling().nextElementSibling().nextElementSibling();
			String basic = ebasic.text();
			
			movie = new MovieDto(title, engTitle, poster, movieNum, like, ticketing, director, actor, genre, basic);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return movie;
	}

}
