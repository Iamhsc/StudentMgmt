package com.domain;

/**
  * 专业
 * @author imhsc
 *
 */
public class Profession {
	private Integer id;
	private String profession_name;
	private Integer p_code;
	private Integer college_code;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProfession_name() {
		return profession_name;
	}

	public void setProfession_name(String profession_name) {
		this.profession_name = profession_name;
	}

	public Integer getP_code() {
		return p_code;
	}

	public void setP_code(Integer p_code) {
		this.p_code = p_code;
	}

	public Integer getCollege_code() {
		return college_code;
	}

	public void setCollege_code(Integer college_code) {
		this.college_code = college_code;
	}

	public Profession(Integer id, String profession_name, Integer p_code, Integer college_code) {
		super();
		this.id = id;
		this.profession_name = profession_name;
		this.p_code = p_code;
		this.college_code = college_code;
	}

	public Profession() {
		super();
	}

	@Override
	public String toString() {
		return "Profession [id=" + id + ", profession_name=" + profession_name + ", p_code=" + p_code
				+ ", college_code=" + college_code + "]";
	}
}
