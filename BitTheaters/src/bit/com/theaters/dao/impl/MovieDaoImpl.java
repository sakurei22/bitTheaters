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
			/*
			  <div class="box-contents">
	                        <a href="/movies/detail-view/?midx=82999">
	                            <strong class="title">남산의 부장들</strong>
	                        </a>
			 */
			
			// 예매율
			Elements ticketings = doc.select("div.box-contents strong.percent span");
			
			//좋아요
			Elements likes = doc.select("div.box-contents span.count strong i");
			/*
			 <span class="count"> 
                 <strong><i>6,673</i><span>명이 선택</span></strong> 
			 */
			
			//포스터 이미지
			Elements posters = doc.select("div.box-image span.thumb-image img");
			
			
			//영화 번호
			Elements movie_nums = doc.select("div.box-contents span.like button.btn-like");
			
			/*
			 <div class="box-image" >
                        <strong class="rank">No.1</strong>	
                        <a href="/movies/detail-view/?midx=83126">
                            <span class="thumb-image">
                                <img src="http://img.cgv.co.kr/Movie/Thumbnail/Poster/000083/83126/83126_320.jpg" alt="해리포터와 아즈카반의 죄수 포스터" onerror="errorImage(this)"/>
                                <span class="ico-grade grade-all">전체</span>
                            </span>
                            <strong class="no1">1위</strong>
                        </a>
                        <span class="screentype">
                            
                                <a class="forDX" href="#" title="4DX 상세정보 바로가기" data-regioncode="4D14">4DX</a>
                            
                        </span>
                    </div>
			 */
			
			for (int i = 0; i < 7; i++) {
				Element eTitle = titles.get(i); //오브젝트
				String title = eTitle.text(); //오브젝트를 텍스트로 변환
				
				Element ePoster = posters.get(i);
				String poster = ePoster.attr("src");
				
				Element eTicketing = ticketings.get(i);
				String ticketing = eTicketing.text();
				
				Element eMovie_num = movie_nums.get(i);
				String sMovie_num = eMovie_num.attr("value");
				
				int idx = sMovie_num.lastIndexOf("=");
				int movie_num = Integer.parseInt(sMovie_num.substring(idx+1));
				
				
				
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
	
	
}
