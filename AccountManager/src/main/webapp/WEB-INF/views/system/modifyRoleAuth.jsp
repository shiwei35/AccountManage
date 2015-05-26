<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>the role auth modify page</title>
<script type="text/javascript">
<!--
	var roleId = ${role.roleId};

	$(function() {
		loadRoleAuth();
	});

	//加载模块权限信息
	function loadRoleAuth() {
		$.messager.progress({
			title : '请稍后',
			msg : '页面加载中...'
		});

		$.ajax({
					type : "GET",
					url : '${pageContext.request.contextPath}/role/rescAuthList.do?roleId='
							+ roleId,
					dataType : "json",
					cache : false,
					success : function(result) {
						if (result && result.success) {
							$('#treeRoleAuth').tree({
								animate : true,
								lines : true,
								data : result.data
							});

							$.messager.progress('close');
						} else {
							$.messager.progress('close');
							$.messager.alert('信息提示', result.msg, "error");
						}
					}
				});
	}

	//保存选中的权限
	function saveRoleAuth() {
		var rows = $('#treeRoleAuth').tree('getChecked');
		var authIdList = [];
		var rescIdList = [];

		if (rows.length > 0) {
			$.messager.confirm('信息提示','确定设置此角色权限？',	function(r) {
								if (r) {
									$.messager.progress({
										title : '请稍后',
										msg : '数据保存中...'
									});

									var strP = /^\d+$/;//正则表达式，判断是否是整数，保存时要去掉父节点，因为父节点ID包含英文字母
									for (var i = 0; i < rows.length; i++) {
										if (strP.test(rows[i].id)) {
											if(rows[i].type=='M'){
												rescIdList.push(rows[i].id);
											}else{
												authIdList.push(rows[i].id);
											}
										}
									}

									$.ajax({
												type : 'post',//可选get
												url : '${pageContext.request.contextPath}/role/saveRoleAuth.do', //这里是接收数据的
												data : 'roleId=' + roleId
														+ "&rescIdList="
														+ rescIdList
														+ "&authIdList="
														+ authIdList, //传给数据，多个参数用&连接
												dataType : 'text',
												success : function(result) {
													try {
														var r = $.parseJSON(result);
														if (r.success) {
															$.messager.progress('close');
															$.messager.alert('信息提示',r.msg,	"info",	backList);
														}
													} catch (e) {
														$.messager.progress('close');
														$.messager.alert('信息提示',	result.msg,	"error");
													}
												}
											});
								}
							});
		} else {
			$.messager.alert('信息提示', "请您选择要保存的权限！", "info");
		}
	}

	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/roleList.do';
	}
//-->
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',title:'角色权限配置',border:false"
			style="padding: 1px;">
			<table class="modifytable" width="100%">
				<tr>
					<td>
						<ul id="treeRoleAuth" class="easyui-tree" checkbox="true"
							animate="true" data-options="parentField : 'pid',lines : true"></ul>
					</td>
				</tr>
			</table>
		</div>
		<div data-options="border:false,region:'south',split:false"
			style="height: 42px; overflow: hidden; padding-left: 1px; padding-right: 1px; padding-bottom: 1px; padding-top: 1px;">
			<table width="100%" style="border: 0px;">
				<tr>
					<td align="center"><input type="button" class="btn" value="保存"
						onclick="saveRoleAuth();" /> <input type="button" value="返回"
						class="btn" onclick="backList();" /></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>