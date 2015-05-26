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
	function upload() {
		var mFile = $("#mFile").val();
		if (mFile != 0) {
			$.messager.confirm('信息提示','您是否要上传此附件？',	function(r) {
				if (r) {
					$('#modifyForm').form(
						'submit',
						{
							url : '${pageContext.request.contextPath}/test/uploadTest.do',
							success : function(results) {
								$.messager.confirm('信息提示','附件上传成功！');
							}
						});
					}
				});
		} else {
			$.messager.confirm('信息提示', '请选择要上传的附件！');
		}
	}
	
	function exec(){
		$('#modifyForm').form(
				'submit',
				{
					url : '${pageContext.request.contextPath}/test/executeStrategy.do',
					success : function(results) {
						$.messager.confirm('信息提示','执行成功！');
					}
				});
	}
	
	function reExec(){
		$('#modifyForm').form(
				'submit',
				{
					url : '${pageContext.request.contextPath}/test/reExecuteStrategy.do',
					success : function(results) {
						$.messager.confirm('信息提示','执行成功！');
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
			<form id="modifyForm" method="post" enctype="multipart/form-data">
				<table id="update" class="modifytable" width="100%">
					<tr>
						<th align="center" width="35%">文件</th>
						<td><input type="file" id="mFile" name="mFile"
							style="width: 200px" /></td>
					</tr>
					<tr>
						<th align="center" width="35%">描述</th>
						<td><input class="easyui-validatebox" name="fileName"
							style="width: 400px" validType="length[1,100]"
							value="${user.description}" /></td>
					</tr>
					<tr>
						<th align="center" width="35%">文件下载</th>
						<td><a href="${pageContext.request.contextPath}/test/download.do">张三测试.docx</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="button"
							value="保存" class="btn" onclick="upload();" />
							<input type="button"
							value="测试执行" class="btn" onclick="exec();" />
							<input type="button"
							value="重新加载执行" class="btn" onclick="reExec();" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>