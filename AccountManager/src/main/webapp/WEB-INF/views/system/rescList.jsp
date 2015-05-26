<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>the resc list page</title>
<script type="text/javascript">
<!--
	$(function() {
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/resc/rescList.do',
			fit : true,
			fitColumns : true,
			striped : true,
			border : false,
			pagination : true,
			idField : 'rescId',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'rescName',
			sortOrder : 'ASC',
			checkOnSelect : false,
			selectOnCheck : false,
			rownumbers : true,
			nowrap : false,
			columns : [ [ {
				field : 'rescId',
				title : '模块编号',
				width : 20,
				checkbox : true
			}, {
				field : 'rescTitle',
				title : '显示名称',
				width : 15,
				sortable : true
			}, {
				field : 'rescName',
				title : '模块名称',
				width : 15,
				sortable : true
			}, {
				field : 'rescDesc',
				title : '模块描述',
				sortable : true,
				width : 20
			}, {
				field : 'rescNamespace',
				title : '命名空间',
				sortable : true,
				width : 20,
				formatter : function(value, row, index) {
					return getDictItem("RESC_NAMESPACE", value);
				}
			}, {
				field : 'rescUrl',
				title : '模块URL',
				width : 20,
				sortable : true
			}, {
				field : 'parentId',
				title : '父模块',
				width : 20,
				sortable : true
			}, {
				field : 'rescSeq',
				title : '序号',
				width : 10,
				sortable : true
			}, {
				field : 'isLeaf',
				title : '叶子节点',
				width : 10,
				sortable : true,
				formatter : function(value, row, index) {
					return getDictItem("YES_OR_NO", value);
				}
			}, {
				field : 'rescStatus',
				title : '模块状态',
				width : 10,
				sortable : true,
				formatter : function(value, row, index) {
					return getDictItem("STATUS", value);
				}
			} ] ],
			toolbar : '#toolbar'
		});
	});

	function addNew() {
		window.location.href = '${pageContext.request.contextPath}/resc/toAddResc.do';
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
						<th width="20%">模块名称</th>
						<td width="30%"><input name="rescName" style="width: 315px;" /></td>
						<th width="20%">模块描述</th>
						<td width="30%"><input name="rescDesc" style="width: 315px;" /></td>
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