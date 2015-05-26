<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>the role list page</title>
<script type="text/javascript">
<!--
	$(function() {
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/role/roleList.do',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'roleId',
			loadMsg : '数据加载中，请稍后......',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
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
				width : 80,
				sortable : true
			}, {
				field : 'roleDesc',
				title : '角色描述',
				width : 160
			}, {
				field : 'status',
				title : '状态',
				width : 50,
				sortable : true,
				formatter : function(value, row, index) {
					return getDictItem('STATUS', value);
				}
			} ] ],
			toolbar : '#toolbar'
		});
	});

	function addNew() {
		window.location.href = '${pageContext.request.contextPath}/role/toAddRole.do';
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
				window.location.href = '${pageContext.request.contextPath}/role/toUpdateRole.do?roleId='
						+ rows[0].roleId;
			} else {
				$.messager.alert('信息提示', "只能选择一条要修改的角色！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要修改的角色！", "info");
		}
	}

	function deleteObj() {
		var rows = $('#datagrid').datagrid('getChecked');
		var ids = [];

		if (rows.length > 0) {
			$.messager
					.confirm(
							'信息提示',
							'您确定要删除勾选的记录吗？',
							function(r) {
								if (r) {
									for (var i = 0; i < rows.length; i++) {
										ids.push(rows[i].roleId);
									}
									$
											.ajax({
												type : 'post',//可选get
												url : '${pageContext.request.contextPath}/role/deleteRole.do', //这里是接收数据的
												data : 'roleIds=' + ids, //传给数据，多个参数用&连接
												dataType : 'json',
												success : function(result) {
													$.messager
															.alert(
																	'信息提示',
																	result.msg,
																	"info",
																	function() {
																		if (result.success) {
																			$(
																					'#datagrid')
																					.datagrid(
																							'load');
																			$(
																					'#datagrid')
																					.datagrid(
																							'uncheckAll')
																					.datagrid(
																							'unselectAll')
																					.datagrid(
																							'clearSelections');
																		}
																	});
												}
											});
								}
							});
		} else {
			$.messager.alert('信息提示', "请您选择要删除的角色！", "info");
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
    
    //角色权限配置
    function roleAuthManager(){
    	var rows = $('#datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/role/toRoleAuthManager.do?roleId='+rows[0].roleId;
			} else {
				$.messager.alert('信息提示', "只能选择一条要修改权限的角色！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要修改权限的角色！", "info");
		}
    }
//-->
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',title:'查询条件',border:false"
			style="height: 101px; overflow: hidden; padding-left: 1px; padding-right: 1px; padding-bottom: 1px; padding-top: 1px;"
			align="center">
			<form id="searchForm">
				<table class="querytable" width="100%">
					<tr>
						<th width="20%">角色名称</th>
						<td width="30%"><input name="roleName" style="width: 315px;" /></td>
						<th width="20%">角色描述</th>
						<td width="30%"><input name="roleDesc" style="width: 315px;" /></td>
					</tr>
					<tr>
						<td colspan="4" align="center"><input type="button"
							class="btn" value="查询" onclick="search();" /> <input
							type="button" value="清空" class="btn" onclick="resetSearch();" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false"
			style="padding-top: 0px;">
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
						<td><div class="datagrid-btn-separator"></div></td>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-remove',plain:true"
							onClick="javascript:deleteObj();" style="float: left;">删除</a></td>
						<td><div class="datagrid-btn-separator"></div></td>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-ok',plain:true"
							onClick="javascript:roleAuthManager();" style="float: left;">角色权限管理</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>