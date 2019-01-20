<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>学生个人信息页面</h3>
学号：${stu.stu_id }<br>
姓名：${stu.name }<br>
生日：${stu.birthday}<br>
性别：${stu.sex==1?"男":"女" }<br>
地址：${stu.address}<br>
电话：${stu.phone}<br>
学院：${stu.college}<br>
专业：${stu.professional }<br>
爱好：${stu.hobbys}<br> 
简介：${stu.self }<br>
照片： <br><img alt="" width="150" src="${stu.photo }">
</body>
</html>