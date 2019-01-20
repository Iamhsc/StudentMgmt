package com.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CollegeDao;
import com.dao.ProfessionDao;
import com.dao.StudentDao;
import com.dao.impl.CollegeDaoImpl;
import com.dao.impl.ProfessionDaoImpl;
import com.dao.impl.StudentDaoImpl;
import com.domain.College;
import com.domain.PageBean;
import com.domain.Profession;
import com.domain.Student;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDao stuDao = new StudentDaoImpl();
	CollegeDao collDao = new CollegeDaoImpl();
	ProfessionDao proDao = new ProfessionDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("add")) {
				List<College> collLs;
				List<Profession> proLs;
				try {
					collLs = collDao.getAll();
					proLs = proDao.getAll();
					request.setAttribute("collLs", collLs);
					request.setAttribute("proLs", proLs);
					request.getRequestDispatcher("studentAdd.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (action.equals("more")) {
				Integer id = Integer.parseInt(request.getParameter("id"));
				Student stu;
				try {
					stu = stuDao.getById(id);
					request.setAttribute("stu", stu);
					request.getRequestDispatcher("studentDetail.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (action.equals("edit")) {
				Integer id = Integer.parseInt(request.getParameter("id"));
				Student stu;
				try {
					List<College> collLs;
					List<Profession> proLs;
					stu = stuDao.getById(id);
					collLs = collDao.getAll();
					proLs = proDao.getAll();
					request.setAttribute("collLs", collLs);
					request.setAttribute("proLs", proLs);
					request.setAttribute("stu", stu);
					request.getRequestDispatcher("studentEdit.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (action.equals("delete")) {
				Integer id = Integer.parseInt(request.getParameter("id"));
				try {
					stuDao.delete(id);
					response.sendRedirect("student");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			int num = 1;
			String pageNum = request.getParameter("pageNum");
			if (pageNum != null)
				num = Integer.parseInt(pageNum);
			try {
				long totalRecord;
				totalRecord = stuDao.getSize();
				int pageSize = 5;
				PageBean<Student> pageBean = new PageBean<>(num, pageSize, (int) totalRecord);
				List<Student> list = stuDao.getByPage(pageBean.getStartIndex(), pageSize);
				pageBean.setList(list);
				request.setAttribute("pageBean", pageBean);
				request.getRequestDispatcher("studentList.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("save")) {
				Student stu = doForm(request);
				try {
					stuDao.save(stu);
					JSONObject json = new JSONObject();
					json.put("code", 1);
					json.put("msg", "添加成功");
					json.put("url", "student");
					response.getWriter().write(json.toString());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (action.equals("update")) {
				Student stu = doForm(request);
				stu.setId(Integer.parseInt(request.getParameter("id")));
				try {
					JSONObject json = new JSONObject();
					if (stuDao.update(stu) > 0) {
						json.put("code", 1);
						json.put("msg", "更新成功");
						json.put("url", "student");
					} else {
						json.put("code", 0);
						json.put("msg", "更新失败");
					}
					response.getWriter().write(json.toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private Student doForm(HttpServletRequest request) {
		Integer id = null;
		Integer stu_id = Integer.parseInt(request.getParameter("stu_id"));
		String name = request.getParameter("name");
		String password = stu_id.toString();
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		Integer college_code = Integer.parseInt(request.getParameter("college"));
		Integer professional_code = Integer.parseInt(request.getParameter("professional"));
		Byte sex = Byte.parseByte(request.getParameter("sex"));
		String[] hobby = request.getParameterValues("hobby");
		String self = request.getParameter("self");
		String photo = request.getParameter("photo");
		Student stu = new Student(id, stu_id, password, name, birthday, sex, address, phone, professional_code,
				college_code, hobby, self, photo);
		return stu;
	}
}
