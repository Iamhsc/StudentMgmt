package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "LoginFilter", urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "loginUI", value = "/login.jsp"), @WebInitParam(name = "loginProcess", value = "/public"),
		@WebInitParam(name = "encoding", value = "utf-8") })
public class LoginFilter implements Filter {

	private FilterConfig config;

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		config = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String loginUI = config.getInitParameter("loginUI");
		String loginProcess = config.getInitParameter("loginProcess");
		HttpServletRequest org0 = (HttpServletRequest) request;
		HttpServletResponse org1 = (HttpServletResponse) response;
		HttpSession session = org0.getSession(true);
		String requestPath = org0.getServletPath();
		if (requestPath.contains(".css") || requestPath.contains(".js") || requestPath.contains(".png")|| requestPath.contains(".jpg")){
			chain.doFilter(request, response);
		} else {
			if (session.getAttribute("username") == null && !requestPath.endsWith(loginUI)
					&& !requestPath.endsWith(loginProcess)) {
				org1.setContentType("text/html; charset=utf-8");
				org1.sendRedirect(org0.getContextPath() + loginUI);
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
