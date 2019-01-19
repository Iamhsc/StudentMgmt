package com.domain;

/**
  * 学院
 * @author imhsc
 *
 */
public class College {
	private Integer id;
	private String college_name;
	private Integer c_code;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public Integer getC_code() {
		return c_code;
	}

	public void setC_code(Integer c_code) {
		this.c_code = c_code;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", college_name=" + college_name + ", c_college=" + c_code + "]";
	}

	public College() {
		super();
	}

	public College(Integer id, String college_name, Integer c_college) {
		super();
		this.id = id;
		this.college_name = college_name;
		this.c_code = c_college;
	}
}
