package com.roommates.model;

import java.sql.Date;

public class ModelUser {

	private String uname;
	private String email;
	private String pass;
	private String gender;
	private String city;
	private String country;
	private String phone;
	private String type;
	private String avatar;
	private Date signup;
	private long lastLogin;
	private long notesCheck;

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Date getSignup() {
		return signup;
	}
	public void setSignup(Date signup) {
		this.signup = signup;
	}
	public long getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(long currentTimestamp) {
		this.lastLogin = currentTimestamp;
	}
	public long getNotesCheck() {
		return notesCheck;
	}
	public void setNotesCheck(long notesCheck) {
		this.notesCheck = notesCheck;
	}

}
