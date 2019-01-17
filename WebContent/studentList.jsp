<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style>
table.stu-info {
	border-collapse: collapse;
	border-color: #666;
	border-width: 1px;
	color: #333;
	font-size: 11px;
	font-family: verdana, arial, sans-serif
}

table.stu-info th {
	padding: 8px;
	border: 1px solid #666;
	background-color: #dedede
}

table.stu-info td {
	padding: 8px;
	border: 1px solid #666;
	background-color: #fff
}
</style>
<body>
	<h3>学生信息列表页面JSTL</h3>
	<hr>
	<table class="stu-info">
		<thead>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>专业</th>
				<th>爱好</th>
				<th width="200px;">简介</th>
				<th>照片</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageBean.list}" var="item" varStatus="index">
				<tr>
					<td>${item.stu_id}</td>
					<td>${item.name}</td>
					<td>${item.sex}</td>
					<td>${item.professional}</td>
					<td>${item.hobbys}</td>
					<td width="200px;">${item.self}</td>
					<td><img alt="" src="photo/${item.photo}" width="50" ></td>
					<td>
					<a href='upload?id=${item.id}'>上传照片</a>
					<a href='student?action=more&id=${item.id}'>更多</a> <a 
						href='student?action=delete&id=${item.id}'>删除</a> <a
						href='student?action=edit&id=' ${item.id}>编辑</a></td>
				</tr>
			</c:forEach>
	</table>
	<hr>
	<%-- 构建分页导航 --%>
	<c:if test="${pageBean.list.size()>0}">
            共有${pageBean.totalRecord}个员工，共${pageBean.totalPage }页，当前为${pageBean.pageNum}页
            <br />
		<a href="student?pageNum=1">首页</a>
		<%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
		<c:if test="${pageBean.pageNum ==1}">
			<c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1"
				var="i">
				<c:if test="${pageBean.pageNum == i}">
                        ${i}
                    </c:if>
				<c:if test="${pageBean.pageNum != i}">
					<a href="student?pageNum=${i}">${i}</a>
				</c:if>
			</c:forEach>
			<a href="student?pageNum=${pageBean.pageNum+1}">下一页</a>
		</c:if>

		<%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
		<c:if
			test="${pageBean.pageNum > 1 && pageBean.pageNum < pageBean.totalPage}">
			<a href="student?pageNum=${pageBean.pageNum-1}">上一页</a>
			<c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1"
				var="i">
				<c:if test="${pageBean.pageNum == i}">
                        ${i}
                    </c:if>
				<c:if test="${pageBean.pageNum != i}">
					<a href="student?pageNum=${i}">${i}</a>
				</c:if>
			</c:forEach>
			<a href="student?pageNum=${pageBean.pageNum+1}">下一页</a>
		</c:if>
		<%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
		<c:if test="${pageBean.pageNum == pageBean.totalPage}">
			<a href="student?pageNum=${pageBean.pageNum-1}">上一页</a>
			<c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1"
				var="i">
				<c:if test="${pageBean.pageNum == i}">
                        ${i}
                    </c:if>
				<c:if test="${pageBean.pageNum != i}">
					<a href="student?pageNum=${i}">${i}</a>
				</c:if>
			</c:forEach>
		</c:if>
		<%--尾页 --%>
		<a href="student?pageNum=${pageBean.totalPage}">尾页</a>
	</c:if>

</body>
</html>