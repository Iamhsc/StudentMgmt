<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>后台登陆</title>
    <link rel="stylesheet" href="//layui.hcwl520.com.cn/layui-v2.4.3/css/layui.css?v=201809030202" />
	<script src="//layui.hcwl520.com.cn/layui-v2.4.3/layui.js?v=201809030202"></script>
    <style type="text/css">
    body{background-color:#f5f5f5}
    .login-head{position:fixed;left:0;top:0;width:80%;height:60px;line-height:60px;background:#000;padding:0 10%}
    .login-head h1{color:#fff;font-size:20px;font-weight:600}
    .login-box{margin:15pc auto 0;width:25pc;background-color:#fff;padding:15px 30px;border-radius:10px;box-shadow:5px 5px 15px #999}
    .login-box .layui-input{font-size:15px;font-weight:400}
    .login-box input[name=password]{letter-spacing:5px;font-weight:800}
    .login-box .layui-btn{width:100%}
    .login-box .copyright{text-align:center;height:50px;line-height:50px;font-size:9pt;color:#ccc}
    .login-box .copyright a{color:#ccc}
    </style>
</head>
<body>
    <div class="login-box">
        <form action="public" method="post" class="layui-form layui-form-pane">
            <fieldset class="layui-elem-field layui-field-title">
                <legend>管理后台登陆</legend>
            </fieldset>
            <input type="hidden" name="action" value="login">
            <div class="layui-form-item">
                <label class="layui-form-label">登陆账号</label>
                <div class="layui-input-block">
                    <input type="text" name="username" class="layui-input" lay-verify="required" placeholder="请输入登陆账号" autofocus="autofocus" value="">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">登陆密码</label>
                <div class="layui-input-block">
                    <input type="password" name="password" class="layui-input" lay-verify="required" placeholder="******" value="">
                </div>
            </div>
           <c:if test="${loginerr!=null}">
				<div style="color: red">${loginerr}</div>
			</c:if>
            <input type="submit" value="登陆" lay-submit="" lay-filter="formLogin" class="layui-btn">
        </form>
        <div class="copyright">
            © 2018-2019 <a href="#" target="_blank"></a>All Rights Reserved.
        </div>
    </div>
</body>
</html>