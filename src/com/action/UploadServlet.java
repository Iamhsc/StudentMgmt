package com.action;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Part part = request.getPart("fileData");
		String id = request.getParameter("stu_id");
		String savePath = getServletContext().getRealPath("/upload");
		String save1=getServletContext().getRealPath("upload");
		System.out.print("路径1"+savePath+"\n");
		System.out.print("路径2"+save1+"\n");
		File file = new File(savePath);
		// 判断上传文件的保存目录是否存在
		if (!file.exists() && !file.isDirectory()) {
			System.out.println(savePath + "目录不存在，需要创建"+"\n");
			// 创建目录
			file.mkdir();
		}
		// 获取文件名
		String fileName = id+".jpg";
		String filePath=savePath + File.separator + fileName;
		// 把文件写到指定路径
		part.write(filePath);
		JSONObject json = new JSONObject();
		json.put("code", 1);
		json.put("msg", "上传成功");
		json.put("path", filePath);
		response.getWriter().write(json.toString());
//	    PrintWriter out = response.getWriter();
//	    out.println(id+".jpg<br><img src="+imgPath+" whdth='100px'>");
//	    out.flush();
//	    out.close();
	}

}
