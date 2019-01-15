package com.domain;

import java.util.Arrays;

public class Student {
	private Integer id;
	private Integer stu_id;
	private String name;
	private String password;
	private Byte sex;
	private String professional;
	private String[] hobby;
	private String hobbys;
	private String self;
	private String photo;

	@Override
	public String toString() {
		return "Student [id=" + id + ", stu_id=" + stu_id + ", name=" + name + ", password=" + password + ", sex=" + sex
				+ ", professional=" + professional + ", hobby=" + Arrays.toString(hobby) + ", hobbys=" + hobbys
				+ ", self=" + self + ", photo=" + photo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStu_id() {
		return stu_id;
	}

	public void setStu_id(Integer stu_id) {
		this.stu_id = stu_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getHobbys() {
		return hobbys;
	}

	public void setHobbys(String hobbys) {
		this.hobbys = hobbys;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
