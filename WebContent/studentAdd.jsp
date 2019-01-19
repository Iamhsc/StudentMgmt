<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>学生信息录入表单页面ALt+/</h1>
	<hr>
	<form method="post" action="student">
		<input type="hidden" name="action" value="save"> 
		学号：<input type="text" name="stu_id"> <br> 
		姓名：<input type="text" name="name"><br> 
		生日：<input type="date" name="birthday" value="2000-01-01"><br>
		性别：<input type="radio" name="sex" value="1">男 
			  <input type="radio" name="sex" value="2">女<br>
	    地址：<input type="text"><br>
	    电话：<input type="text"><br>
			  学院：<select name="college">
		<c:forEach items="${collLs}" var="item" varStatus="index">
			<option value="${item.c_code}">${item.college_name}</option>
		</c:forEach></select>
		专业：<select name="professional">
		<c:forEach items="${proLs}" var="item" varStatus="index">
			<option value="${item.p_code}">${item.profession_name}</option>
		</c:forEach>
		</select><br> 爱好：<input type="checkbox" name="hobby" value="编程">编程
		<input type="checkbox" name="hobby" value="音乐">音乐 <input
			type="checkbox" name="hobby" value="运动">运动 <input
			type="checkbox" name="hobby" value="动漫">动漫<br> 简介：
		<textarea rows="5" cols="20" name="self"></textarea>
		<br> 照片：<input type="text" name="photo"><br> <input
			type="submit" value="提交"> <input type="reset" value="重写">
	</form>
	<hr>
</body>
</html>