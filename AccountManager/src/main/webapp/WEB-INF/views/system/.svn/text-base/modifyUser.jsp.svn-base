<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>the user modify page</title>
<script type="text/javascript">
<!--
$(function() {
	//初始化combobox
	initComboboxContent("status", "STATUS");
});

function backList() {
	window.location.href = '${pageContext.request.contextPath}/menu/userList.do';
}

function saveObj() {
	$('#modifyForm').form('submit', {
	   url : '${pageContext.request.contextPath}/user/modifyUser.do',
	   success : function(result) {
		  try {
				var r = $.parseJSON(result);
				
                if (r.success) {
						$.messager.alert('信息提示', r.msg, "info", backList);
					}else{
					   $.messager.alert('信息提示', r.msg, "info");
					}
				} catch (e) {
					$.messager.alert('信息提示', result, "info");
				}
			}
		});
}
//-->
</script>
</head>
<body>
<div id="updatePanel" class="easyui-panel" title="修改用户"
	data-options="border:false,fit:true"
	style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
	<form id="modifyForm" method="post">
		<table id="update" class="modifytable" width="100%">
			<tr>
				<th align="center" width="35%">&nbsp &nbsp登录名</th>
				<td><input id ="loginId" class="easyui-validatebox" name="loginId"
					validType="length[1,10]" data-options="required:true"
					value="${userObj.loginId}" style="width: 400px" /></td>
			</tr>
			<tr>
				<th align="center" width="35%">姓名</th>
				<td><input class="easyui-validatebox" name="name"
					style="width: 400px" validType="length[1,50]" data-options="required:true" value="${userObj.name}" /></td>
			</tr>
			<tr>
				<th align="center" width="35%">描述</th>
				<td><input class="easyui-validatebox" name="description"
					style="width: 400px" validType="length[1,100]" value="${userObj.description}" /></td>
			</tr>			
            <tr>
				<th align="center" width="35%">状态</th>
				<td><input  name="status" id="status"
					data-options="required:true,validType:'emptyString[\'#status\']'" value="${userObj.status}"
					style="width: 400px" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="保存" class="btn" onclick="saveObj();" />
			    <input type="button" value="返回" class="btn" onclick="backList();" />
                <input type="hidden" name="userId" value="${userObj.userId}" />  
				<input type="hidden" name="flag" value="${flag}"></td>
			</tr>
		</table>
	</form>
</div>
</body>