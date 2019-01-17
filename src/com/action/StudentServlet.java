package com.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.domain.PageBean;
import com.domain.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDao dao = new StudentDaoImpl();

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
		// TODO Auto-generated method stub
		doPost(request, response);
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
					dao.save(stu);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("student");
			} else if (action.equals("update")) {
				Student stu = doForm(request);
				try {
					dao.update(stu);
					response.sendRedirect("student");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (action.equals("delete")) {
				Integer id = Integer.parseInt(request.getParameter("id"));
				try {
					dao.delete(id);
					response.sendRedirect("student");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (action.equals("more")) {
				Integer id = Integer.parseInt(request.getParameter("id"));
				Student stu;
				try {
					stu = dao.getById(id);
					System.out.println(stu);
					request.setAttribute("stu", stu);
					request.getRequestDispatcher("more.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (action.equals("edit")) {
				Integer id = Integer.parseInt(request.getParameter("id"));
				Student stu;
				try {
					stu = dao.getById(id);
					request.setAttribute("stu", stu);
					request.getRequestDispatcher("edit.jsp").forward(request, response);
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
				totalRecord = dao.getSize();
				int pageSize = 5;
				PageBean<Student> pageBean = new PageBean<>(num, pageSize, (int) totalRecord);
				List<Student> list = dao.getByPage(pageBean.getStartIndex(), pageSize);
				pageBean.setList(list);
				request.setAttribute("pageBean", pageBean);
				request.getRequestDispatcher("studentList.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private Student doForm(HttpServletRequest request) {
		Integer id = 0;
		Integer stu_id = Integer.parseInt(request.getParameter("stu_id"));
		String name = request.getParameter("name");
		String password = stu_id.toString();
		String birthday=request.getParameter("birthday");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		Integer professional_code =Integer.parseInt(request.getParameter("professional_code"));
		Integer college_code = Integer.parseInt(request.getParameter("college_code"));
		Byte sex = Byte.parseByte(request.getParameter("sex"));
		String[] hobby = request.getParameterValues("hobby");
		String self = request.getParameter("self");
		String photo = request.getParameter("photo");
		Student stu=new Student(id, stu_id, password, name, birthday, sex, address, phone, professional_code, college_code, hobby, self, photo);
		return stu;
	}
}
