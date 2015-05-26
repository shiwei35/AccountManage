<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loan app list</title>
<script type="text/javascript">
<!--
	$(function() {
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/loan/natural/app/loanNaturalAppList.do',
			fit : true,
			fitColumns : true,
			striped : true,
			border : false,
			pagination : true,
			idField : 'appNo',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'name',
			sortOrder : 'ASC',
			checkOnSelect : false,
			selectOnCheck : false,
			rownumbers : true,
			nowrap : false,
			columns : [ [ {
				field : 'appNo',
				title : '申请编号',
				width : 20,
				checkbox : true
			}, {
				field : 'name',
				title : '姓名',
				width : 15,
				sortable : true
			}, {
				field : 'idType',
				title : '证件类型',
				width : 15,
				sortable : true
			}, {
				field : 'idNo',
				title : '证件号码',
				sortable : true,
				width : 20
			}, {
				field : 'mobile',
				title : '手机',
				sortable : true,
				width : 20
			}, {
				field : 'educationLvl',
				title : '学历',
				sortable : true,
				width : 20
			}, {
				field : 'company',
				title : '所在公司',
				width : 20,
				sortable : true
			}, {
				field : 'position',
				title : '职务',
				width : 20,
				sortable : true
			} ] ],
			toolbar : '#toolbar'
		});
	});

	function addNew() {
		window.location.href = '${pageContext.request.contextPath}/loan/natural/app/toAddNaturalApp.do';
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
				window.location.href = '${pageContext.request.contextPath}/resc/toUpdate.do?rescId='
						+ rows[0].rescId;
			} else {
				$.messager.alert('信息提示', "只能选择一条要修改的记录！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要修改的记录！", "info");
		}
	}

	function deleteObj() {
		var rows = $('#datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('信息提示', '您确认要删除当前选中的记录？', function(r) {
				if (r) {
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].rescId);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/resc/deleteResc.do',
						data : {
							ids : ids.join(',')
						},
						type : "POST",
						dataType : 'json',
						success : function(result) {
							$.messager.alert('信息提示', result.msg, "info",
									function() {
										if (result.success) {
											$('#datagrid').datagrid('load');
											$('#datagrid').datagrid(
													'uncheckAll').datagrid(
													'unselectAll').datagrid(
													'clearSelections');
										}
									});
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
//-->
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',title:'查询条件',border:false"
			style="height: 103px; overflow: hidden; padding-left: 1px; padding-right: 1px; padding-bottom: 1px; padding-top: 1px;"
			align="center">
			<form id="searchForm">
				<table class="querytable" width="100%">
					<tr>
						<th width="20%">姓名</th>
						<td width="30%"><input name="name" style="width: 280px;" /></td>
						<th width="20%">证件号码</th>
						<td width="30%"><input name="name" style="width: 280px;" /></td>
					</tr>
					<tr>
						<td colspan="4" align="center"><input type="button"
							value="查询" class="btn" onclick="search();" /> <input
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
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-remove',plain:true"
							onClick="javascript:deleteObj();" style="float: left;">删除</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>