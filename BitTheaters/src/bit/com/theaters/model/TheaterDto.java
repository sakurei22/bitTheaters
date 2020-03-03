package bit.com.theaters.model;

import java.io.Serializable;

public class TheaterDto implements Serializable {
	private String place;
	private String time1;
	private String time2;
	private String time3;

	public TheaterDto() {
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getTime3() {
		return time3;
	}

	public void setTime3(String time3) {
		this.time3 = time3;
	}

	public TheaterDto(String place, String time1, String time2, String time3) {
		super();
		this.place = place;
		this.time1 = time1;
		this.time2 = time2;
		this.time3 = time3;
	}
	
	
}
