<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>the user list page</title>
<script type="text/javascript">
<!--
	$(function() {
		$('#datagrid').datagrid({
			url : "${pageContext.request.contextPath}/user/userlist.do",
			fit : true,
			fitColumns : true,
			striped : true,
			loadMsg : '数据加载中,请稍后......',
			border : false,
			pagination : true,
			idField : 'userId',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'loginId',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			remoteSort : true,
			rownumbers : true,
			nowrap : false,
			columns : [ [ {
				field : 'usertId',
				title : '编号',
				width : 150,
				checkbox : true
			}, {
				field : 'name',
				title : '姓名',
				width : 50,
				sortable : true
			}, {
				field : 'loginId',
				title : '登录名',
				width : 50,
				sortable : true
			}, {
				field : 'description',
				title : '描述',
				width : 110,
				sortable : true
			}, {
				field : 'status',
				title : '状态',
				width : 50,
				sortable : true,
				formatter : function(value, row, index) {
					return getDictItem("STATUS", value);
				}
			} ] ],
			toolbar : '#toolbar'
		});
	});

	function addNew() {
		window.location.href = '${pageContext.request.contextPath}/user/toAddUser.do';
		if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
			try {
				CollectGarbage();
			} catch (e) {
			}
		} 
	}

	function updateObj() {
		var rows = $('#datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/user/toUpdateUser.do?userId='
						+ rows[0].userId;
			} else {
				$.messager.alert('信息提示', "只能选择一条记录，请重新选择！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要修改的记录！", "info");
		}
	}

	function deleteObj() {
		var rows = $('#datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager
					.confirm(
							'信息提示',
							'您确认要删除当前选中的记录吗？',
							function(r) {
								if (r) {
									for (var i = 0; i < rows.length; i++) {
										ids.push(rows[i].userId);
									}
									$
											.ajax({
												url : '${pageContext.request.contextPath}/user/deleteUser.do',
												data : {
													ids : ids.join(',')
												},
												type : "POST",
												dataType : 'json',
												success : function(result) {
													if (result.success) {
														$('#datagrid')
																.datagrid(
																		'load');
														$('#datagrid')
																.datagrid(
																		'uncheckAll')
																.datagrid(
																		'unselectAll')
																.datagrid(
																		'clearSelections');
													}
													$.messager.alert('信息提示',
															result.msg, "info");
												}
											});
								}
							});
		} else {
			$.messager.alert('信息提示', '请勾选要删除的记录！', "info");
		}
	}

	//查询
	function search() {
		$('#datagrid').datagrid('load', serializeObject($('#searchForm')));
	}

	//清空
	function resetSearch() {
		$('#searchForm :text').val('');
		$('#datagrid').datagrid('load', {});
	}

	/*  初始化密码*/
	function initPwd() {
		var rows = $('#datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager
					.confirm(
							'信息提示',
							'您确认要初始化当前选中用户密码吗？',
							function(r) {
								if (r) {
									for (var i = 0; i < rows.length; i++) {
										ids.push(rows[i].userId);
									}
									$
											.ajax({
												url : '${pageContext.request.contextPath}/user/initPwd.do',
												data : {
													ids : ids.join(',')
												},
												type : "POST",
												dataType : 'json',
												success : function(result) {
													if (result.success) {
														$('#datagrid')
																.datagrid(
																		'load');
														$('#datagrid')
																.datagrid(
																		'uncheckAll')
																.datagrid(
																		'unselectAll')
																.datagrid(
																		'clearSelections');
													}
													$.messager.alert('信息提示',
															result.msg, "info");
												}
											});
								}
							});
		} else {
			$.messager.alert('信息提示', '请勾选要初始化密码的记录！', "info");
		}
	}

	/*  用户角色信息 */
	function setUserRole() {
		var rows = $('#datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/user/toUserRoleConfig.do?userId='
						+ rows[0].userId;
			} else {
				$.messager.alert('信息提示', "只能选择一条记录，请重新选择！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要设置角色的记录！", "info");
		}
	}
//-->
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',title:'查询条件',border:false"
			style="height: 100px; overflow: hidden; padding-left: 1px; padding-right: 1px; padding-bottom: 1px; padding-top: 1px;"
			align="center">
			<form id="searchForm">
				<table class="querytable" width="100%">
					<tr>
						<th width="20%">姓名</th>
						<td width="30%"><input name="name" style="width: 315px;" /></td>
						<th width="20%">登录名</th>
						<td width="30%"><input name="loginId" style="width: 315px;" /></td>
					</tr>
					<tr>
						<td colspan="6" align="center"><input type="button"
							class="btn" value="查询" onclick="search();" /> <input
							type="button" value="清空" class="btn" onclick="resetSearch();" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false">
			<table id="datagrid"></table>
			<div id="toolbar"
				style="height: auto !important; height: 28px; min-height: 28px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-add',plain:true"
							onClick="javascript:addNew();" style="float: left;">新增</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-edit',plain:true"
							onClick="javascript:updateObj();" style="float: left;">修改</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-remove',plain:true"
							onClick="javascript:deleteObj();" style="float: left;">删除</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-back',plain:true"
							onClick="javascript:initPwd();" style="float: left;">密码初始化</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
						<shiro:hasPermission name="SYS_MANAGE:USER_ROLE_CFG">
							<td><a href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-ui-ok',plain:true"
								onClick="javascript:setUserRole();" style="float: left;">角色设置</a>
							</td>
						</shiro:hasPermission>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>