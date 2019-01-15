package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dao.AdminUserDao;
import com.domain.AdminUser;
import com.util.C3P0Util;
import com.util.RegExpValidatorUtils;

public class AdminUserDaoImpl implements AdminUserDao {
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	
	//插入数据
		/* (non-Javadoc)
		 * @see com.dao.impl.AdminUserDao#save(com.domain.AdminUser)
		 */
		@Override
		public int save(AdminUser aduser) throws SQLException {
			String sql = "insert into s_user(stu_id,name,sex,professional,hobby,self,photo) values(?,?,?,?,?,?,?)";
			int result = 0;
			return result;
		}

		//更新数据
		/* (non-Javadoc)
		 * @see com.dao.impl.AdminUserDao#update(com.domain.AdminUser)
		 */
		@Override
		public int update(AdminUser aduser) throws SQLException {
				int result = 0;
			String sql = "update s_user set name=?,sex=?,professional=?,hobby=?,self=?,photo=? where id=?";
			return result;
		}

		//根据id删除数据
		/* (non-Javadoc)
		 * @see com.dao.impl.AdminUserDao#delete(int)
		 */
		@Override
		public int delete(int id) throws SQLException {
			int result = 0;
			String sql = "delete from s_user where id=?";
			try {
				result = qr.update(sql, id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}

		//根据id获取数据
		/* (non-Javadoc)
		 * @see com.dao.impl.AdminUserDao#getById(int)
		 */
		@Override
		public AdminUser getById(int id) throws SQLException {
			String sql = "select id,stu_id,name,sex,professional,hobby as hobbys,self,photo from s_user where id=?";
			AdminUser aduser = null;
			return aduser;
		}
		

		//获取全部数据
		/* (non-Javadoc)
		 * @see com.dao.impl.AdminUserDao#getAll()
		 */
		@Override
		public List<AdminUser> getAll() throws SQLException {
			List<AdminUser> lists = new ArrayList<AdminUser>();
			String sql = "select id,stu_id,name,sex,professional,hobby as hobbys,self,photo from s_user";
//				 lists = qr.query(sql, new BeanListHandler<Student>(Student.class));
			return lists;
		}

		//获取数据总条数
		/* (non-Javadoc)
		 * @see com.dao.impl.AdminUserDao#getSize()
		 */
		@Override
		public Long getSize() throws SQLException {
			Long count = null;
			try {
				String sql = "select count(*) from s_user";
				count = qr.query(sql, new ScalarHandler<Long>());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
		}

		//分页查询
		/* (non-Javadoc)
		 * @see com.dao.impl.AdminUserDao#getByPage(int, int)
		 */
		@Override
		public List<AdminUser> getByPage(int startIndex, int pageSize) throws SQLException {
			List<AdminUser> lists = new ArrayList<AdminUser>();
			String sql = "select id,stu_id,name,sex,professional,hobby as hobbys,self,photo from s_user limit ?,?";
				lists = qr.query(sql, new BeanListHandler<AdminUser>(AdminUser.class),startIndex,pageSize);
			return lists;
		}

		/* (non-Javadoc)
		 * @see com.dao.impl.AdminUserDao#login(java.lang.String)
		 */
		@Override
		public AdminUser login(String username) throws SQLException {
			String sql="";
			if(RegExpValidatorUtils.isEmail(username)) {
				sql = "select id,username,password from s_admin_user where email=?";
			}else if(RegExpValidatorUtils.IsHandset(username)) {
				sql = "select id,username,password from s_admin_user where mobile=?";
			}else {
				sql = "select id,username,password from s_admin_user where username=?";
			}
			AdminUser user = null;
			try {
				user = qr.query(sql, new BeanHandler<>(AdminUser.class),username);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
		}
}
