package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dao.ProfessionDao;
import com.domain.Profession;
import com.util.C3P0Util;

public class ProfessionDaoImpl implements ProfessionDao {
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	/* (non-Javadoc)
	 * @see com.dao.impl.ProfessionDao#getAll()
	 */
	@Override
	public List<Profession> getAll() throws SQLException {
		List<Profession> lists = new ArrayList<Profession>();
		try {
			String sql = "select * from s_profession";
			lists = qr.query(sql, new BeanListHandler<Profession>(Profession.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}
}
