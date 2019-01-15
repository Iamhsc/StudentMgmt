package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.domain.AdminUser;

public interface AdminUserDao {

	//插入数据
	int save(AdminUser aduser) throws SQLException;

	//更新数据
	int update(AdminUser aduser) throws SQLException;

	//根据id删除数据
	int delete(int id) throws SQLException;

	//根据id获取数据
	AdminUser getById(int id) throws SQLException;

	//获取全部数据
	List<AdminUser> getAll() throws SQLException;

	//获取数据总条数
	Long getSize() throws SQLException;

	//分页查询
	List<AdminUser> getByPage(int startIndex, int pageSize) throws SQLException;

	AdminUser login(String username) throws SQLException;

}