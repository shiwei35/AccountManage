<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>param list page</title>
<script type="text/javascript">
<!--
	//界面初始化
	$(function() {
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/param/paramList.do',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'paramId',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'paramId',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			rownumbers : true,
			nowrap : false,
			striped : true,
			columns : [ [ {
				field : 'paramId',
				title : '参数编号',
				width : 30,
				checkbox : true
			}, {
				field : 'paramTitle',
				title : '参数名称',
				sortable : true,
				width : 30
			}, {
				field : 'paramCode',
				title : '参数编码',
				sortable : true,
				width : 30
			}, {
				field : 'paramVal',
				title : '参数值',
				sortable : true,
				width : 20
			}, {
				field : 'module',
				title : '所属模块',
				width : 20,
				sortable : true,
				formatter : function(value, row, index) {
					return getDictItem("SYS_MODULE", value);
				}
			}, {
				field : 'operId',
				title : '操作员',
				width : 20,
				sortable : true
			}, {
				field : 'opTime',
				title : '操作时间',
				width : 50,
				sortable : true

			} ] ],
			toolbar : '#toolbar'
		});
	});

	function updateObj() {
		var rows = $('#datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/param/toUpdate.do?paramId='+ rows[0].paramId;
			} else {
				$.messager.alert('信息提示', "只能选择一条要修改的记录！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要修改的记录！", "info");
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
						<th width="20%">参数名称</th>
						<td width="30%"><input name="paramTitle"
							style="width: 275px;" class="easyui-validatebox"
							validType="length[0,30]" " /></td>
						<th width="20%">参数编码</th>
						<td width="30%"><input name="paramCode" style="width: 275px;"
							class="easyui-validatebox" validType="length[0,30]" /></td>
					</tr>
					<tr>
						<td colspan="4" align="center"><input type="button"
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
							data-options="iconCls:'icon-ui-edit',plain:true"
							onClick="javascript:updateObj();" style="float: left;">修改</a></td>
						<td><div class="datagrid-btn-separator"></div></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>