package bit.com.theaters.model;

import java.io.Serializable;

/*

DROP TABLE THEATERS_USERS 
CASCADE CONSTRAINTS;

CREATE TABLE THEATERS_USERS(
    USER_ID VARCHAR2(50) PRIMARY KEY,
    USER_PWD VARCHAR2(50) NOT NULL,
    USER_PHONE VARCHAR2(11) NOT NULL,
    USER_EMAIL VARCHAR2(100) NOT NULL,
    USER_BIRTH VARCHAR2(10) NOT NULL,
    USER_NAME VARCHAR2(15) NOT NULL,
    USER_JOIN_DAY DATE NOT NULL,
    USER_AUTH NUMBER(1) NOT NULL
);

 */


public class UserDto implements Serializable {
	
	private String user_id;
	private String user_pwd;
	private String user_phone;
	private String user_email;
	private String user_birth;
	private String user_name;
	private String user_join_day;
	private int user_auth;
	
	public UserDto() {
	}
	
	public UserDto(String user_id, String user_pwd, String user_phone, String user_email, String user_birth,
			String user_name) {
		super();
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_birth = user_birth;
		this.user_name = user_name;
	}

	public UserDto(String user_id, String user_pwd, String user_phone, String user_email, String user_birth,
			String user_name, String user_join_day, int user_auth) {
		super();
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_birth = user_birth;
		this.user_name = user_name;
		this.user_join_day = user_join_day;
		this.user_auth = user_auth;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_join_day() {
		return user_join_day;
	}

	public void setUser_join_day(String user_join_day) {
		this.user_join_day = user_join_day;
	}

	public int getUser_auth() {
		return user_auth;
	}

	public void setUser_auth(int user_auth) {
		this.user_auth = user_auth;
	}

	@Override
	public String toString() {
		return "UserDto [user_id=" + user_id + ", user_pwd=" + user_pwd + ", user_phone=" + user_phone + ", user_email="
				+ user_email + ", user_birth=" + user_birth + ", user_name=" + user_name + ", user_join_day="
				+ user_join_day + ", user_auth=" + user_auth + "]";
	}
	
}
