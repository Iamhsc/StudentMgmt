<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>学生信息编辑表单页面ALt+/</h1>
<hr>
<form method="post" action="student">
<input type="hidden" name="action" value="update">
学号：<input type="text" name="id" value="${stu.id }"> <br>
姓名：<input type="text" name="name" value="${stu.name }"><br>
性别：<input type="radio" name="sex" value="男" <c:if test="${stu.sex=='男' }"> checked="checked" </c:if>  >男
     <input type="radio" name="sex" value="女" <c:if test="${stu.sex=='女' }"> checked="checked" </c:if>>女<br>
专业：<select name="professional">
    <option value="计算机科学与技术" <c:if test="${stu.professional=='计算机科学与技术' }">selected="selected" </c:if> >计算机科学与技术</option>
    <option value="网络工程技术" <c:if test="${stu.professional=='网络工程技术' }">selected="selected" </c:if> >网络工程技术</option>
    <option value="电子信息技术" <c:if test="${stu.professional=='电子信息技术' }">selected="selected" </c:if> >电子信息技术</option>
    <option value="物联网工程" <c:if test="${stu.professional=='物联网工程' }">selected="selected" </c:if> >物联网工程</option>
     </select><br>
爱好：<input type="checkbox" name="hobby" value="编程" <c:if test="${fn:contains(stu.hobbys,'编程')}"> checked="checked" </c:if>>编程
    <input type="checkbox" name="hobby" value="音乐" <c:if test="${fn:contains(stu.hobbys,'音乐')}"> checked="checked" </c:if>>音乐
    <input type="checkbox" name="hobby" value="运动" <c:if test="${fn:contains(stu.hobbys,'运动')}"> checked="checked" </c:if>>运动
    <input type="checkbox" name="hobby" value="动漫" <c:if test="${fn:contains(stu.hobbys,'动漫')}"> checked="checked" </c:if>>动漫<br>
简介：<textarea rows="5" cols="20" name="self">${stu.self }</textarea><br>
照片：<input type="text" name="photo" value="${stu.photo }">
<a href="upload.jsp?id=${stu.id }" target="blank">上传头像</a>
<br>
<input type="submit" value="提交">
<input type="reset" value="重写">
</form>
</body>
</html>