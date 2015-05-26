<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modify owner info</title>
<script type="text/javascript">
<!--
	function saveOwnerInfo() {
		$.messager
				.confirm(
						'信息提示',
						'确认要修改用户基本信息？',
						function(r) {
							if (r) {
								$('#modifyForm')
										.form(
												'submit',
												{
													url : '${pageContext.request.contextPath}/user/saveOwnerInfo.do',
													success : function(result) {
														try {
															var r = $
																	.parseJSON(result);

															if (r.success) {
																$.messager
																		.alert(
																				'信息提示',
																				r.msg,
																				"info");
															} else {
																$.messager
																		.alert(
																				'信息提示',
																				r.msg,
																				"info");
															}
														} catch (e) {
															$.messager.alert(
																	'信息提示',
																	result,
																	"info");
														}
													}
												});
							}
						});
	}

	function savePassWord() {
		var oldPassword = $("#oldPassword").val();
		var password = $("#password").val();
		var confirmPassword = $("#confirmPassword").val();
		if (oldPassword == "") {
			$.messager.alert('信息提示', '请输入原原密码！', "info");
			return;
		}
		if (password == "") {
			$.messager.alert('信息提示', '请输入新密码！', "info");
			return;
		}
		if (confirmPassword == "") {
			$.messager.alert('信息提示', '请输入确认密码！', "info");
			return;
		}

		$.messager.confirm('信息提示', '您确认要修改用户密码信息？', function(r) {
			if (r) {
				$.ajax({
					url : '${pageContext.request.contextPath}/user/modifyPassWord.do?',
					data : {
						oldPassword : oldPassword,
						newPassword : password
					},
					type : 'POST',
					dataType : 'json',
					success : function(result) {
						$.messager.alert('信息提示', result.msg, "info");
					}
				});
			}
		});
	}
//-->
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',border : false"
			style="padding: 1px; overflow: hidden;" title="修改基本信息">
			<form id="modifyForm" method="post">
				<table id="update" class="modifytable" width="100%">
					<tr>
						<th align="center" width="35%">姓名</th>
						<td><input class="easyui-validatebox" name="name"
							style="width: 400px" validType="length[1,50]"
							data-options="required:true" value="${user.name}" /></td>
					</tr>
					<tr>
						<th align="center" width="35%">描述</th>
						<td><input class="easyui-validatebox" name="description"
							style="width: 400px" validType="length[1,100]"
							value="${user.description}" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="button"
							value="保存" class="btn" onclick="saveOwnerInfo();" /> <input
							type="hidden" name="userId" value="${user.userId}" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'south',title:'修改密码',border : false"
			style="padding: 1px; height: 260px;" title="密码信息修改">
			<table id="update" class="modifytable" width="100%">
				<tr>
					<th align="center" width="35%">原密码</th>
					<td><input class="easyui-validatebox" id="oldPassword"
						type="password" style="width: 400px" name="oldPassword"
						validType="length[4,20]" data-options="required:true" value="" /></td>
				</tr>
				<tr>
					<th align="center" width="35%">新密码</th>
					<td><input class="easyui-validatebox" id="password"
						type="password" style="width: 400px" name="password"
						validType="length[4,20]" invalidMessage="密码长度4-20（非中文），请重填"
						data-options="required:true" /></td>
				</tr>
				<tr>
					<th align="center" width="35%">确认密码</th>
					<td><input class="easyui-validatebox" id="confirmPassword"
						type="password" name="confirmPassword"
						data-options="required:true" style="width: 400px"
						required="required" validType="equalTo['#password']"
						invalidMessage="两次输入密码不匹配" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button" value="保存"
						class="btn" onclick="savePassWord();" /></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>