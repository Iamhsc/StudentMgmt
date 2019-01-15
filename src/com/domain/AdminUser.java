package com.domain;

public class AdminUser {
	private Integer id;
	private String username;
	private String password;
	private String mobile;
	private String email;
	private Integer create_time;
	private Integer last_login_time;
	private String last_login_ip;

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", username=" + username + ", password=" + password + ", mobile=" + mobile
				+ ", email=" + email + ", create_time=" + create_time + ", last_login_time=" + last_login_time
				+ ", last_login_ip=" + last_login_ip + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Integer create_time) {
		this.create_time = create_time;
	}

	public Integer getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Integer last_login_time) {
		this.last_login_time = last_login_time;
	}

	public String getLast_login_ip() {
		return last_login_ip;
	}

	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}

}
