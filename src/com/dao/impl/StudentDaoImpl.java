package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dao.StudentDao;
import com.domain.Student;
import com.util.C3P0Util;

public class StudentDaoImpl implements StudentDao {
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	//插入数据
	/* (non-Javadoc)
	 * @see com.dao.impl.StudentDao#save(com.domain.Student)
	 */
	@Override
	public int save(Student student) throws SQLException {
		String sql = "insert into s_student values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int result = 0;
		try {
			result = qr.update(sql,null,student.getStu_id(),student.getPassword(),student.getName(),student.getBirthday(), student.getSex(),student.getAddress(),student.getPhone(), student.getProfessional_code(),student.getCollege_code(),
					Arrays.toString(student.getHobby()), student.getSelf(), student.getPhoto());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//更新数据
	/* (non-Javadoc)
	 * @see com.dao.impl.StudentDao#update(com.domain.Student)
	 */
	@Override
	public int update(Student student) throws SQLException {
		String sql = "update s_student set stu_id=?,name=?,birthday=?,sex=?,address=?,phone=?,professional_code=?,college_code=?,hobbys=?,self=?,photo=? where id=?";
		int result = 0;
		try {
			result = qr.update(sql, student.getStu_id(),student.getName(),student.getBirthday(), student.getSex(),student.getAddress(),student.getPhone(), student.getProfessional_code(),student.getCollege_code(),
					Arrays.toString(student.getHobby()), student.getSelf(), student.getPhoto(), student.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//根据id删除数据
	/* (non-Javadoc)
	 * @see com.dao.impl.StudentDao#delete(int)
	 */
	@Override
	public int delete(int id) throws SQLException {
		int result = 0;
		String sql = "delete from s_student where id=?";
		try {
			result = qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//根据id获取数据
	/* (non-Javadoc)
	 * @see com.dao.impl.StudentDao#getById(int)
	 */
	@Override
	public Student getById(int id) throws SQLException {
		String sql = "select s.id,s.stu_id,s.name,s.birthday,s.sex,s.address,s.phone,s.professional_code,s.college_code,s.hobbys,s.photo,c.college_name as college,p.profession_name as professional,self from s_student s left join s_college c on s.college_code= c.c_code left join s_profession p on s.professional_code=p.p_code where s.id=?";
		Student student = null;
		try {
			student = qr.query(sql, new BeanHandler<>(Student.class), id);
			String hobbys=student.getHobbys();
			hobbys=hobbys.substring(1,hobbys.length()-1);
			student.setHobby(hobbys.split(","));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	

	//获取全部数据
	/* (non-Javadoc)
	 * @see com.dao.impl.StudentDao#getAll()
	 */
	@Override
	public List<Student> getAll() throws SQLException {
		List<Student> lists = new ArrayList<Student>();
		try {
			String sql = "select id,stu_id,name,sex,professional,hobby as hobbys,self,photo from s_student";
			 lists = qr.query(sql, new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	//获取数据总条数
	/* (non-Javadoc)
	 * @see com.dao.impl.StudentDao#getSize()
	 */
	@Override
	public Long getSize() throws SQLException {
		Long count = null;
		try {
			String sql = "select count(*) from s_student";
			count = qr.query(sql, new ScalarHandler<Long>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	//分页查询
	/* (non-Javadoc)
	 * @see com.dao.impl.StudentDao#getByPage(int, int)
	 */
	@Override
	public List<Student> getByPage(int startIndex, int pageSize) throws SQLException {
		List<Student> lists = new ArrayList<Student>();
		try {
			String sql = "select s.id,s.stu_id,s.name,s.birthday,s.sex,s.address,s.phone,s.professional_code,s.college_code,s.hobbys,s.photo,c.college_name as college,p.profession_name as professional from s_student s left join s_college c on s.college_code= c.c_code left join s_profession p on s.professional_code=p.p_code limit ?,?";
			lists = qr.query(sql, new BeanListHandler<Student>(Student.class),startIndex,pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}
}
