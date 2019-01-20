package com.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.domain.Student;

public class StudentDaoImplTest {
	StudentDao dao = new StudentDaoImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testSave() {
//		int res;
//		try {
////		for(int i=0;i<=20;i++) {
////			res = dao.save(new Student(null, 2005010+1, "password"+i,"ligoudan"+i,"2018-12-12", (byte) 1,"百色市","100861"+i, 100100+i,1000+i,new String[] { "编程", "运动" },
////					"hello world"+i, "2005001.jpg+1"));
////		}
////			System.out.println("信息插入" + (res > 0 ? "成功!" : "失败!"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Test
	public void testUpdate() {
		try {
			int res = dao.update(new Student(47,20181219,"20181219","ligoudan","2018-12-12", (byte) 1,"百色市","100861", 100100,1000,new String[] { "编程", "运动" },
						"hello world", "2005001.jpg+1"));
			System.out.print(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByPage() {
		List<Student> lists;
		try {
			lists = dao.getByPage(0, 1);
			for (Student stu : lists)
				System.out.print(stu.getName() + " , ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
