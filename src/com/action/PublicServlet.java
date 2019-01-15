package com.action;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.AdminUserDao;
import com.dao.impl.AdminUserDaoImpl;
import com.domain.AdminUser;

import net.sf.json.JSONObject;

@WebServlet("/public")
public class PublicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminUserDao dao=null;
	private AdminUser user=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.addHeader("Content-Type","application/json");
		String action = request.getParameter("action");
		JSONObject json = new JSONObject();
		if (action.equals("register")) {
		}
		if (action.equals("login")) {
			dao = new AdminUserDaoImpl();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			try {
				user = dao.login(username);
				if (user == null) {
					json.put("code", 0);
					json.put("msg", "用户不存在");
					response.getWriter().write(json.toString());
				} else {
					if (password.equals(user.getPassword())) {
						HttpSession session = request.getSession();
						session.setAttribute("username", username);
						session.setAttribute("user_id", user.getId());
						json.put("code", 1);
						json.put("msg", "登陆成功");
						json.put("url", "student");
						response.getWriter().write(json.toString());
					} else {
						json.put("code", 0);
						json.put("msg", "用户名或密码错误");
						response.getWriter().write(json.toString());
					}
				}
				System.out.println(user);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
