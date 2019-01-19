<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="//layui.hcwl520.com.cn/layui-v2.4.3/css/layui.css?v=201809030202" />
<script
	src="//layui.hcwl520.com.cn/layui-v2.4.3/layui.js?v=201809030202"></script>
<title>Insert title here</title>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 50px;">
		<legend>学生信息添加</legend>
	</fieldset>
	<form class="layui-form layui-form-pane" action="student">
		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-inline">
				<input type="text" name="name" lay-verify="required"
					placeholder="请输入学生姓名" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">学号</label>
			<div class="layui-input-inline">
				<input type="text" name="stu_id" id="stu_id" lay-verify="required"
					placeholder="请输入学生学号" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">专业</label>
			<div class="layui-input-inline">
				<select name="college">
					<option value=""></option>
					<c:forEach items="${collLs}" var="item" varStatus="index">
						<option value="${item.c_code}">${item.college_name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">学院</label>
			<div class="layui-input-inline">
				<select name="professional">
					<option value=""></option>
					<c:forEach items="${proLs}" var="item" varStatus="index">
						<option value="${item.p_code}">${item.profession_name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">出生日期</label>
				<div class="layui-input-block">
					<input type="text" name="birthday" id="date" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">性別</label>
				<div class="layui-input-inline">
					<input type="radio" name="sex" value="1" title="男" checked="">
					<input type="radio" name="sex" value="2" title="女">
				</div>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">地址</label>
			<div class="layui-input-inline">
				<input type="text" name="address" lay-verify="required"
					placeholder="请输入" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">电话号码</label>
			<div class="layui-input-inline">
				<input type="text" name="phone" lay-verify="required"
					placeholder="请输入" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">爱好兴趣</label>
			<div class="layui-input-block">
				<input type="checkbox" name="hobby" value="写作" title="写作"> <input
					type="checkbox" name="hobby" value="阅读" title="阅读" checked=""> <input
					type="checkbox" name="hobby" value="游戏" title="游戏">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">照片</label>
			<div class="layui-upload">
				&nbsp;
				<button class="layui-btn layui-btn-normal" id="test8" type="button">上传照片</button>
				<a id="uploadimg"></a> <a id="imgpath"></a>
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">介绍</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入内容" name="self" class="layui-textarea"></textarea>
			</div>
		</div>
		<input type="hidden" name="action" value="save">
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button type="button" class="layui-btn" id="upload">立即提交</button>
				<button id="sub" lay-submit lay-filter="addStudent"
					style="display: none;"></button>
				<button class="layui-btn layui-btn-primary" type="reset">重置</button>
			</div>
		</div>
	</form>
	<script>
		layui.use([ 'form', 'layedit', 'laydate','upload' ],function() {
							var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate,$=layui.jquery, upload = layui.upload;
							//日期
							laydate.render({
								elem : '#date'
							});
							//创建一个编辑器
							var editIndex = layedit.build('LAY_demo_editor');
							form.render();
					        form.on('submit(addStudent)', function (data) {
					            delete data.field.fileData;
					            var _form = $(this).parents('form');
					            layer.msg('数据提交中...', { time: 500000 });
					            $.ajax({
					                type: "POST",
					                url: _form.attr('action'),
					                dataType: 'json',
					                data: _form.serialize(),
					                success: function (res) {
					                    console.log(res);
					                    layer.msg(res.msg, {}, function () {
					                        if (res.code == 1) {
					                            if (typeof (res.url) != 'undefined' && res.url != null && res.url != '') {
					                                location.href = res.url;
					                            } else {
					                                location.reload();
					                            }
					                        } else {
					                            location.reload();
					                        }
					                    });
					                }, error: function (er) {
					                    console.log(er);
					                }
					            });
					            return false;
					        });
					        upload.render({
					            elem: '#test8'
					          , url: 'UploadServlet'
					          , auto: false
					          , field: "fileData"
					          , bindAction: '#upload'
					          ,data: {
					        	  stu_id: function(){
					        		console.log($('#stu_id').val());  
					        		    return $('#stu_id').val();
					        		  }
					        		}
					          , choose: function (obj) {
					              //读取本地文件
					              obj.preview(function (index, file, result) {
					                  var img = '<img src="' + result + '" alt="' + file.name + '" style="width:65px;height:38px;margin:0 5px;" class="layui-upload-img">';
					                  $("#uploadimg").append(img);
					              });
					          }
					          , done: function (res) {
					              console.log(res);
					              $("#imgpath").append('<input name="photo" value=' + res.path + '>');
					              document.getElementById("sub").click();
					              return;
					          }
					        });
					    });
	</script>
</body>
</html>