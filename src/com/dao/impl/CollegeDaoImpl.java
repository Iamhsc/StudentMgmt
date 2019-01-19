package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dao.CollegeDao;
import com.domain.College;
import com.util.C3P0Util;

public class CollegeDaoImpl implements CollegeDao {
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.impl.CollegeDao#getAll()
	 */
	@Override
	public List<College> getAll() throws SQLException {
		List<College> lists = new ArrayList<College>();
		try {
			String sql = "select * from s_college";
			lists = qr.query(sql, new BeanListHandler<College>(College.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}
}
