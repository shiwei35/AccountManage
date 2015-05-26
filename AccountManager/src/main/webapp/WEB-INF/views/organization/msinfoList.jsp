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
<title>Ms list page</title>
<script type="text/javascript">

	$(function() {
		 $('#datagrid').datagrid({
				url : "${pageContext.request.contextPath}/msinfo/msinfoList.do",
				fit : true,
				fitColumns : true,
				striped : true,
				loadMsg : '数据加载中,请稍后......',
				border : false,
				pagination : true,
				idField : 'sMsuuid',
				pageSize : 10,
				pageList : [ 10, 20, 30, 40, 50 ],
				sortName : 'sMsuuid',
				sortOrder : 'asc',
				checkOnSelect : false,
				selectOnCheck : false,
				remoteSort : true,
				rownumbers : true,
				nowrap : false,
				columns : [ [ {
					field : 'sMsuuid',
					title : '商户编码',
					width : 20,
					checkbox : true
				}, {
				 
					field : 'sOrguuid',
					title : '机构UUID',
					width : 20,
					sortable : true
				}, {
					field : 'iMercode',
					title : '商户编码',
					width : 20,
					sortable : true
				},{
					field : 'sMsname',
					title : '商户名称',
					width : 20,
					sortable : true
				}, {
					field : 'sMsstatus',
					title : '商户状态',
					width : 20,
					sortable : true,
					formatter : function(value,row,index) {
						return getDictItem("STATUS", value);
					}
					
				},  {
					field : 'sCitycode',
					title : '城市代码',
					width : 20,
					sortable : true,
					
				} , {
					field : 'sCityname',
					title : '城市名称',
					width : 20,
					sortable : true,
					
				} , {
					field : 'sMsaddr',
					title : '商户地址',
					width : 20,
					sortable : true,
					
				} , {
					field : 'sMszip',
					title : '商户邮编',
					width : 20,
					sortable : true,
					
				}, {
					field : 'sMsmanagername',
					title : '商户联系人姓名',
					width : 20,
					sortable : true,
					
				} , {
					field : 'sMsmanagerphone',
					title : '商户联系人电话',
					width : 20,
					sortable : true,
					
				}  , {
					field : 'sEmail',
					title : '邮件地址',
					width : 20,
					sortable : true,
					
				} , {
					field : 'sRemark',
					title : '备注',
					width : 20,
					sortable : true,
					
				} ] ],
				toolbar : '#toolbar'
			});
			
			
		});

	

	

	//查询
	function search() {
		$('#datagrid').datagrid('load', serializeObject($('#searchForm')));
	}

	//清空
	function resetSearch() {
		$('#searchForm :text').val('');
		$('#datagrid').datagrid('load', {});
	}

	

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
						<th width="20%">门店编码</th>
						<td width="30%"><input name="sMsuuid" style="width: 315px;" /></td>
						<th width="20%">门店名称</th>
						<td width="30%"><input name="sMsname" style="width: 315px;" /></td>
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
						<!-- <td><a href="#" class="easyui-linkbutton"
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
							onClick="javascript:deleteObj();" style="float: left;">删除</a></td> -->
					
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>