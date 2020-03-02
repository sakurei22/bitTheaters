package bit.com.theaters.model;

import java.io.Serializable;

public class TheaterDto implements Serializable {
	private String place;
	private String time;

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public TheaterDto(String place, String time) {
		super();
		this.place = place;
		this.time = time;
	}

	public TheaterDto() {
	}
}
