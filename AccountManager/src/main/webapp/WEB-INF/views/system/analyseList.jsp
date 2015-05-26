<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>analyse list page</title>
<script type="text/javascript">
<!--
//界面初始化
$(function() {
		$('#datagrid').datagrid({
			url : "${pageContext.request.contextPath}/analyse/analyseList.do",
			fit : true,
			fitColumns : true,
			striped : true,
			loadMsg : '数据加载中,请稍后......',
			border : false,
			pagination : true,
			idField : 'sIssuerusercode',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'sIssuerusercode',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			remoteSort : true,
			rownumbers : true,
			nowrap : false,
			striped:true,
			collapsible:true,
	        remoteSort:false,
	        rownumbers:true,
	        width:800,
	        striped: true,
	        nowrap:false,
			 	
			columns : [ [ {
				field : 'dChkacctdate',
				title : '对账日期',
				width : 20,
				sortable : true,
				formatter : function(value,row,index) {
					if(value != null){
						return value.toString().substring(0,11);
						
					     }
					     else return "";
				}
				
			}, {
				field : 'sIssuerusercode',
				title : '发卡方代码',
				width : 20,
				sortable : true
			}, {
				field : 'iOpencountnum',
				title : '开户总笔数',
				width : 20,
				sortable : true
			}, {
				field : 'fOpenamt',
				title : '开户面值金额',
				width : 20,
				sortable : true
			}, {
				field : 'iGcardcountnum',
				title : '礼品卡销售总笔数',
				width : 25,
				sortable : true,
				
			} , {
				field : 'fGcardsumamt',
				title : '礼品卡销售总金额',
				width : 25,
				sortable : true,
				
			} , {
				field : 'iCashcountnum',
				title : '现金充值总笔数',
				width : 22,
				sortable : true,
				
			} , {
				field : 'fCashsumamt',
				title : '现金充值总笔数',
				width : 22,
				sortable : true,
				
			} , {
				field : 'iBcdpaycountnum',
				title : '银行卡支付充值总笔数',
				width : 32,
				sortable : true,
				
			} , {
				field : 'fBcdpaysumamt',
				title : '银行卡支付充值总金额',
				width : 32,
				sortable : true,
				
			} , {
				field : 'iConsumecountnum',
				title : '消费总笔数',
				width : 20,
				sortable : true,
				
			} , {
				field : 'fConsumesumamt',
				title : '消费总金额',
				width : 20,
				sortable : true,
				
			} , {
				field : 'iRefundcountnum',
				title : '退货总笔数',
				width : 20,
				sortable : true,
				
			} , {
				field : 'fRefundsumamt',
				title : '退货总金额',
				width : 20,
				sortable : true,
				
			}  ] ],
			toolbar : '#toolbar'
		});
		
		$("input[dateFormat='date']").each(function(){
			var time=dateToStr($(this).val());
			var id = $(this).attr("id");//获取id的值
			if(id == "dChkacctdate") {
				$(this).val(time);
			} else {
				$(this).datebox('setValue',time);
			}
		});

	});

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
						<th width="20%">商户号</th>
						<td width="30%"><input id="sIssuerusercode" name="sIssuerusercode"
							style="width: 275px;" class="easyui-validatebox"
							validType="length[0,30]" " /></td>
						<th width="20%">时间</th>
						<td width="30%"><input name="dChkacctdate" dateFormat ="date" type="text" class="easyui-datebox" required="required" editable="false"></td>
						
					</tr>
					<tr>
						<td colspan="4" align="center"><input type="button"
							class="btn" value="查询" onclick="search();" /> <input
							type="button" value="清空" class="btn" onclick="resetSearch();" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:true" style="width:600px;height:100px;">
			<table id="datagrid"></table>
			<!-- <div id="toolbar"
				style="height: auto !important; height: 28px; min-height: 28px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						 <td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-edit',plain:true"
							onClick="javascript:updateObj();" style="float: left;"></a></td>
						<td><div class="datagrid-btn-separator"></div></td>
					</tr>
				</table>
			</div>-->
		</div>
	</div>
</body>
</html>