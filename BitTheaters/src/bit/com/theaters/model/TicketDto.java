package bit.com.theaters.model;

import java.io.Serializable;

/*

DROP TABLE THEATERS_TICKET 
CASCADE CONSTRAINTS;

DROP SEQUENCE THEATERS_TICKET_SEQ; 

CREATE TABLE THEATERS_TICKET (
    TICKET_NUM NUMBER(5) PRIMARY KEY,
    TICKET_TITLE VARCHAR2(100) NOT NULL,
    TICKET_DATE VARCHAR2(10) NOT NULL,
    TICKET_TIME VARCHAR2(5) NOT NULL,
    TICKET_PLACE VARCHAR2(10) NOT NULL,
    USER_ID VARCHAR2(50) NOT NULL,
    TICKET_RESERV_DATE DATE NOT NULL,
    TICKET_AUTH NUMBER(1) NOT NULL
);
   
CREATE SEQUENCE THEATERS_TICKET_SEQ
START WITH 10000
INCREMENT BY 1
MAXVALUE 19999
NOCYCLE;


ALTER TABLE THEATERS_TICKET
    ADD CONSTRAINT FK_TICKET_USER_ID_USERS FOREIGN KEY (USER_ID)
        REFERENCES THEATERS_USERS (USER_ID);

 
 */

public class TicketDto implements Serializable {
	private int ticket_num;
	private String ticket_title;
	private String ticket_date;
	private String ticket_time;
	private String ticket_place;
	private String user_id;
	private String ticket_reserv_date;
	private String ticket_auth;
	
	public TicketDto() {
	}
	
	public TicketDto(String ticket_title, String ticket_date, String ticket_time, String ticket_place, String user_id) {
		super();
		this.ticket_title = ticket_title;
		this.ticket_date = ticket_date;
		this.ticket_time = ticket_time;
		this.ticket_place = ticket_place;
		this.user_id = user_id;
	}

	public TicketDto(int ticket_num, String ticket_title, String ticket_date, String ticket_time, String ticket_place,
			String user_id, String ticket_reserv_date, String ticket_auth) {
		super();
		this.ticket_num = ticket_num;
		this.ticket_title = ticket_title;
		this.ticket_date = ticket_date;
		this.ticket_time = ticket_time;
		this.ticket_place = ticket_place;
		this.user_id = user_id;
		this.ticket_reserv_date = ticket_reserv_date;
		this.ticket_auth = ticket_auth;
	}
	
	public int getTicket_num() {
		return ticket_num;
	}
	public void setTicket_num(int ticket_num) {
		this.ticket_num = ticket_num;
	}
	public String getTicket_title() {
		return ticket_title;
	}
	public void setTicket_title(String ticket_title) {
		this.ticket_title = ticket_title;
	}
	public String getTicket_date() {
		return ticket_date;
	}
	public void setTicket_date(String ticket_date) {
		this.ticket_date = ticket_date;
	}
	public String getTicket_time() {
		return ticket_time;
	}
	public void setTicket_time(String ticket_time) {
		this.ticket_time = ticket_time;
	}
	public String getTicket_place() {
		return ticket_place;
	}
	public void setTicket_place(String ticket_place) {
		this.ticket_place = ticket_place;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTicket_reserv_date() {
		return ticket_reserv_date;
	}
	public void setTicket_reserv_date(String ticket_reserv_date) {
		this.ticket_reserv_date = ticket_reserv_date;
	}
	public String getTicket_auth() {
		return ticket_auth;
	}
	public void setTicket_auth(String ticket_auth) {
		this.ticket_auth = ticket_auth;
	}

	@Override
	public String toString() {
		return "TicketDto [ticket_num=" + ticket_num + ", ticket_title=" + ticket_title + ", ticket_date=" + ticket_date
				+ ", ticket_time=" + ticket_time + ", ticket_place=" + ticket_place + ", user_id=" + user_id
				+ ", ticket_reserv_date=" + ticket_reserv_date + ", ticket_auth=" + ticket_auth + "]";
	}
	
	
}
