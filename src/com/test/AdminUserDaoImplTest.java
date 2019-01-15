package com.test;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.AdminUserDao;
import com.dao.impl.AdminUserDaoImpl;
import com.domain.AdminUser;

public class AdminUserDaoImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	AdminUserDao dao=new AdminUserDaoImpl();
	@Test
	public void testLogin() {
		AdminUser user=null;
		try {
			user=dao.login("admin");
			System.out.println(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
