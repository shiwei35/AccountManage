<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user role configuration</title>
<script type="text/javascript">
<!--
	var userId = "${userObj.userId}";

	$(function() {
		$('#datagridRoles')
				.datagrid(
						{
							url : "${pageContext.request.contextPath}/user/loadUnselectedRole.do?userId="
									+ userId,
							fit : true,
							fitColumns : true,
							border : false,
							idField : 'roleId',
							checkOnSelect : false,
							selectOnCheck : false,
							nowrap : false,
							rownumbers : true,
							striped : true,
							columns : [ [ {
								field : 'roleId',
								title : '角色编号',
								checkbox : true
							}, {
								field : 'roleName',
								title : '角色名称',
								width : 80
							} ] ]
						});

		$('#datagridUserRole')
				.datagrid(
						{
							url : "${pageContext.request.contextPath}/user/loadSelectedRole.do?userId="
									+ userId,
							fit : true,
							fitColumns : true,
							border : false,
							idField : 'roleId',
							checkOnSelect : false,
							selectOnCheck : false,
							nowrap : false,
							rownumbers : true,
							striped : true,
							columns : [ [ {
								field : 'roleId',
								title : '角色编号',
								checkbox : true
							}, {
								field : 'roleName',
								title : '角色名称',
								width : 80
							}, {
								field : 'isDefaultRole',
								title : '是否为默认角色',
								width : 80,
								formatter : function(isDefaultRole, row, index) {
									if (isDefaultRole == "Y") {
										return "是";
									} else {
										return "否";
									}
								}
							} ] ]
						});
	});

	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/userList.do';
	}

	/* 添加新角色 */
	function addUserRole() {
		var rows = $('#datagridRoles').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager
					.confirm(
							'信息提示',
							'确定为用户添加所选中的角色？',
							function(r) {
								if (r) {
									for (var i = 0; i < rows.length; i++) {
										ids.push(rows[i].roleId);
									}
									$
											.ajax({
												type : 'post',//可选get
												url : '${pageContext.request.contextPath}/user/addUserRole.do', //这里是接收数据的
												data : 'userId=' + userId
														+ "&ids=" + ids, //传给数据，多个参数用&连接
												dataType : 'text',
												success : function(result) {
													try {
														var r = $
																.parseJSON(result);
														if (r.success) {
															$.messager
																	.alert(
																			'信息提示',
																			r.msg,
																			"info",
																			reloadDatagrid);
														}
													} catch (e) {
														$.messager.alert(
																'信息提示',
																result.msg,
																"info");
													}
												}
											});
								}
							});
		} else {
			$.messager.alert('信息提示', "请选择要为用户添加的角色！", "info");
		}
	}

	/* 添加默认角色 */
	function defaultRole() {
		var rows = $('#datagridUserRole').datagrid('getChecked');

		if (rows.length > 0) {
			if (rows.length == 1) {
				$.messager
						.confirm(
								'信息提示',
								'确定设置此角色为用户默认角色？',
								function(r) {
									if (r) {
										$
												.ajax({
													type : 'post',//可选get
													url : '${pageContext.request.contextPath}/user/setDefaultRole.do', //这里是接收数据的
													data : 'userId=' + userId
															+ "&roleId="
															+ rows[0].roleId, //传给数据，多个参数用&连接
													dataType : 'text',
													success : function(result) {
														try {
															var r = $
																	.parseJSON(result);
															if (r.success) {
																$.messager
																		.alert(
																				'信息提示',
																				r.msg,
																				"info",
																				reloadDatagrid);
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
																	result.msg,
																	"info");
														}
													}
												});
									}
								});
			} else {
				$.messager.alert('信息提示', "用户的默认角色唯一！", "info");

			}
		} else {
			$.messager.alert('信息提示', "请选择要为用户添加的角色！", "info");
		}
	}

	/* 删除角色 */
	function removeUserRole() {
		var rows = $('#datagridUserRole').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			var hasDefaultRole=false;
			for (var i = 0; i < rows.length; i++) {
				if(rows[i].isDefaultRole=='Y'){
					hasDefaultRole=true;
					break;
				}
			}
			if(hasDefaultRole){
				$.messager.alert('信息提示','默认角色不能被删除，请重新设置默认角色后，再进行删除。','info');
				return;
			}
			
			$.messager
					.confirm(
							'信息提示',
							'您确定为用户删除所选中的角色？',
							function(r) {
								if (r) {
									for (var i = 0; i < rows.length; i++) {
										ids.push(rows[i].roleId);
									}
									$.ajax({
												type : 'post',//可选get
												url : '${pageContext.request.contextPath}/user/deleteUserRole.do', //这里是接收数据的
												data : 'userId=' + userId
														+ "&ids=" + ids, //传给数据，多个参数用&连接
												dataType : 'text',
												success : function(result) {
													try {
														var r = $
																.parseJSON(result);
														if (r.success) {
															$.messager
																	.alert(
																			'信息提示',
																			r.msg,
																			"info",
																			reloadDatagrid);
														}
													} catch (e) {
														$.messager.alert(
																'信息提示',
																result.msg,
																"info");
													}
												}
											});
								}
							});
		} else {
			$.messager.alert('信息提示', "请选择要取消用户的角色！", "info");
		}
	}

	function reloadDatagrid() {
		$('#datagridRoles').datagrid('load');
		$('#datagridRoles').datagrid('uncheckAll').datagrid('unselectAll')
				.datagrid('clearSelections');

		$('#datagridUserRole').datagrid('load');
		$('#datagridUserRole').datagrid('uncheckAll').datagrid('unselectAll')
				.datagrid('clearSelections');
	}
//-->
</script>
</head>
<body>
	<div id="userRole" class="easyui-layout"
		data-options="fit : true,border : false">
		<div
			data-options="region:'west',iconCls:'icon-reload',title:'未添加角色列表',border : false"
			style="width: 510px;">
			<table id=datagridRoles></table>
		</div>
		<div
			data-options="region:'east',iconCls:'icon-reload',title:'已添加角色列表',border : false"
			style="width: 510px;">
			<table id=datagridUserRole></table>
		</div>
		<div data-options="region:'center'"
			style="width: 70px; border-bottom-style: none; border-top: 0px;">
			<table align="center" valign="middle" height="100%">
				<tr>
					<td><input type="button" class="btn" value="添加角色"
						onclick="addUserRole();"
						style="width: 100px; height: 25px; line-height: 20px; margin: 2px" /><br>
						<input type="button" class="btn" value="设置默认角色"
						onclick="defaultRole();"
						style="width: 100px; height: 25px; line-height: 20px; margin: 2px" /><br>
						<input type="button" value="取消角色" class="btn"
						onclick="removeUserRole();"
						style="width: 100px; height: 25px; line-height: 20px; margin: 2px" />
					</td>
				</tr>
			</table>
		</div>
		<div data-options="region:'south',border : false"
			style="height: 40px; padding: 1px">
			<table class="modifytable" width="100%" height="100%">
				<tr>
					<td colspan="10" align="center"><input type="button"
						value="返回" class="btn" onclick="backList();" /></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>