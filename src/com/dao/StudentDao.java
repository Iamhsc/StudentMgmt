package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.domain.Student;

public interface StudentDao {

	//插入数据
	int save(Student student) throws SQLException;

	//更新数据
	int update(Student student) throws SQLException;

	//根据id删除数据
	int delete(int id) throws SQLException;

	//根据id获取数据
	Student getById(int id) throws SQLException;

	//获取全部数据
	List<Student> getAll() throws SQLException;

	//获取数据总条数
	Long getSize() throws SQLException;

	//分页查询
	List<Student> getByPage(int startIndex, int pageSize) throws SQLException;
}