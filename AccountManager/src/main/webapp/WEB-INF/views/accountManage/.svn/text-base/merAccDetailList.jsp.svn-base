<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商户账号明细</title>
<script type="text/javascript">
 
	//界面初始化
	$(function() {
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/merAccDetail/merAccDetailList.do',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'iCardid',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'iCardid',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			rownumbers : true,
			nowrap : false,
			striped : true,
			columns : [ [ {
				field : 'iCardid',
				title : '卡标识',
				width : 30,
				checkbox : true
			}, {
				field : 'merInfo',     
				title : '商户名称',
				sortable : true,
				width : 30,
				formatter: function(value,row,index){
				      if (value.sMername){
				         return value.sMername; 
			      } else {
				         return value;
					         }
				}
			}, {
				field : 'iCardno',
				title : '卡号',
				sortable : true,
				width : 30
			}, {
				field : 'sCardtype',
				title : '卡类型',
				sortable : true,
				width : 20
			}, {
				field : 'sCardstatus',
				title : '卡状态',
				width : 20,
				sortable : true/* ,
				formatter : function(value, row, index) {
					return getDictItem("SYS_MODULE", value);
				} */ 
			}, /* {
				field : 'iAcctid',
				title : '账户标识',
				width : 20,
				sortable : true
			} , */{ 
				field : 'fRmbbalance',
				title : '人民币余额', 
				width : 50,
				sortable : true

			}, {
				field : 'fPointbalance',
				title : '积分余额',  
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
				window.location.href = '${pageContext.request.contextPath}/merAccDetail/toUpdate.do?iCardid='+ rows[0].iCardid;
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
	function deleteObj() {
		var rows = $('#datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager
					.confirm(
							'信息提示',
							'您确定要删除当前选中的记录？',
							function(r) {
								if (r) {
									for (var i = 0; i < rows.length; i++) {
										ids.push(rows[i].dictId);
									}
									$
											.ajax({
												url : '${pageContext.request.contextPath}/dict/deleteDict.do',
												data : {
													ids : ids.join(',')
												},
												type : "POST",
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
			$.messager.alert('信息提示', '请勾选要删除的记录！', "info");
		}
	}

	function addNew() {
		window.location.href = '${pageContext.request.contextPath}/merAccDetail/toAdd.do';  
		if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
			try {
				CollectGarbage(); 
			} catch (e) {
			}
		}
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
						<th width="10%">卡号</th>
						<td width="30%"><input name="iCardno" style="width: 275px;"
							class="easyui-validatebox" validType="length[0,30]" /> </td>
						<th width="10%">卡类型</th>
						<td width="20%"><input name="sCardtype" style="width: 275px;"
							class="easyui-validatebox" validType="length[0,30]" /></td>
						<th width="10%">卡状态</th>
						<td width="10%"><input name="sCardstatus" style="width: 275px;"></td>
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