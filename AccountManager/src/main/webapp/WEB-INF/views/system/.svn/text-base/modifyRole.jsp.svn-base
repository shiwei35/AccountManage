<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>the role modify page</title>
<script type="text/javascript">
<!--
$(function() {
	//初始化combobox
	initComboboxContent("status", "STATUS");
});

function backList() {
	window.location.href = '${pageContext.request.contextPath}/menu/roleList.do';
}

function saveObj(){
	$('#modifyForm').form('submit', {
		url : '${pageContext.request.contextPath}/role/modifyRole.do',
		success : function(result) {
			try {
				var r = $.parseJSON(result);
				if (r.success) {
					$.messager.alert('信息提示', r.msg, "info", backList);
				}
			} catch (e) {
				$.messager.alert('信息提示', result);
			}
		}
	});
}
//-->
</script>
</head>
<body>
<div id="updatePanel" class="easyui-panel" 
	data-options="border:false,fit:true"
	style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
	<form id="modifyForm" method="post">
		<table id="update" class="modifytable" width="100%">
			<tr>
				<th align="center" width="35%">角色名称</th>
				<td><input class="easyui-validatebox" name="roleName" id="roleName"
					value="${role.roleName}" data-options="required:true" 
					validType="length[0, 50]" invalidMessage="描述长度不能大于50字符"
					style="width: 400px" /></td>
			</tr>
			<tr>
				<th align="center" width="35%">角色描述</th>
				<td><input class="easyui-validatebox" name="roleDesc"
					value="${role.roleDesc}" data-options="required:true"
					validType="length[0, 100]" invalidMessage="描述长度不能大于100字符"
					style="width: 400px" /></td>
			</tr>
			<tr>
				<th align="center" width="35%">角色状态</th>
				<td><input name="status" id="status"
					data-options="required:true,validType:'emptyString[\'#status\']'" value="${role.status}" panelHeight='auto'
					editable="false" style="width: 400px" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="保存"
					class="btn" onclick="saveObj();" /> <input type="button"
					value="返回" class="btn" onclick="backList();" /> <input
					type="hidden" name="roleId" value="${role.roleId}"/> <input
					type="hidden" name="flag" value="${flag}"/></td>
			</tr>
		</table>
	</form>
</div>
</body>
