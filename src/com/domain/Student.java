package com.domain;

import java.util.Arrays;

public class Student {
	private Integer id;
	private Integer stu_id;//学号
	private String password;//密码
	private String name;//姓名
	private String birthday;//生日
	private Byte sex;//性别
	private String address;//地址
	private String phone;//电话
	private Integer professional_code;//专业代码
	private String professional;//专业
	private Integer college_code;//学院代码
	private String college;//学院
	private String[] hobby;//爱好
	private String hobbys;//爱好string
	private String self;//简介
	private String photo;//照片
	
	public Student() {
		super();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getProfessional_code() {
		return professional_code;
	}

	public void setProfessional_code(Integer professional_code) {
		this.professional_code = professional_code;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public Integer getCollege_code() {
		return college_code;
	}

	public void setCollege_code(Integer college_code) {
		this.college_code = college_code;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", stu_id=" + stu_id + ", password=" + password + ", name=" + name + ", birthday="
				+ birthday + ", sex=" + sex + ", address=" + address + ", phone=" + phone + ", professional_code="
				+ professional_code + ", professional=" + professional + ", college_code=" + college_code + ", college="
				+ college + ", hobby=" + Arrays.toString(hobby) + ", hobbys=" + hobbys + ", self=" + self + ", photo="
				+ photo + "]";
	}

	public Student(Integer id, Integer stu_id, String password, String name, String birthday, Byte sex, String address,
			String phone, Integer professional_code, Integer college_code,
			String[] hobby, String self, String photo) {
		super();
		this.id = id;
		this.stu_id = stu_id;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.professional_code = professional_code;
		this.college_code = college_code;
		this.hobby = hobby;
		this.self = self;
		this.photo = photo;
	}

	
}
