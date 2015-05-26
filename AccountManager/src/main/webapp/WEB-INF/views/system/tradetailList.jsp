<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tradetail list page</title>
<script type="text/javascript">
<!--
//界面初始化
$(function() {
		$('#datagrid').datagrid({
			url : "${pageContext.request.contextPath}/tradetail/tradetailList.do",
			fit : true,
			fitColumns : false,
			striped : true,
			loadMsg : '数据加载中,请稍后......',
			border : false,
			pagination : true,
			idField : 'sMeracct',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'sMeracct',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			remoteSort : true,
			rownumbers : true,
			nowrap : false,
			columns : [ [ {
				field : 'sTrasrlno',
				title : '交易流水号',
				width : 80,
				sortable : true
			}, {
				field : 'sConntype',
				title : '接入类型',
				width : 60,
				sortable : true,
				formatter : function(value,row,index) {
					return getDictItem("CONN_TYPE", value);
				}
				
				
			}, {
				field : 'sMeracct',
				title : '商户账号',
				width : 60,
				sortable : true
			}, {
				field : 'sTermcode',
				title : '终端号',
				width : 50,
				sortable : true
			}, {
				field : 'sTranstype',
				title : '交易类型',
				width : 60,
				sortable : true,
				
			} , {
				field : 'sCardiotype',
				title : '内外卡种',
				width : 60,
				sortable : true,
				formatter : function(value,row,index) {
					return getDictItem("S_CARDIOTYPE", value);
				}
				
				
			} , {
				field : 'dTransdate',
				title : '交易日期',
				width : 100,
				sortable : true,
				formatter : function(value,row,index) {
					if(value != null){
						return value.toString().substring(0,11);
						
					     }
					     else return "";
				}
				
			} , {
				field : 'dBalancedate',
				title : '结算日期',
				width : 100,
				sortable : true,
				formatter : function(value,row,index) {
					if(value != null){
						return value.toString().substring(0,11);
						
					     }
					     else return "";
				}
				
			} , {
				field : 'fTransamt',
				title : '交易金额',
				width : 60,
				sortable : true,
				
			} , {
				field : 'sMcc',
				title : 'MCC码',
				width : 60,
				sortable : true,
				
			} , {
				field : 'sHandlchargdcttype',
				title : '手续费扣率类型',
				width : 100,
				sortable : true,
				formatter : function(value,row,index) {
					return getDictItem("S_HANDLCHARGDCTTYPE", value);
				}
				
				
				
			} , {
				field : 'fFeeratio',
				title : '手续费率',
				width : 60,
				sortable : true,
				
			} , {
				field : 'fFeeratioamt',
				title : '手续费比率金额',
				width : 100,
				sortable : true,
				
			} , {
				field : 'fHandlchargratioulmt',
				title : '手续费比率上限',
				width : 100,
				sortable : true,
				
			} , {
				field : 'fHandlchargratiollmt',
				title : '手续费比率下限',
				width : 100,
				sortable : true,
				
			}, {
				field : 'fHandlcharg',
				title : '手续费',
				width : 50,
				sortable : true,
				
			}, {
				field : 'fActualamt',
				title : '实拨金额',
				width : 60,
				sortable : true,
				
			} , {
				field : 'sBcdno',
				title : '银行卡卡号',
				width : 70,
				sortable : true,
				
			}, {
				field : 'sBcdtype',
				title : '银行卡类型',
				width : 70,
				sortable : true,
				formatter : function(value,row,index) {
					return getDictItem("S_BCDTYPE", value);
				}
				
			}, {
				field : 'sIssuerusercode',
				title : '发卡方代码',
				width : 70,
				sortable : true,
				
			}, {
				field : 'sOpenorg',
				title : '开户机构号',
				width : 70,
				sortable : true,
				
			}] ],
			toolbar : '#toolbar'
		});
		
		$("input[dateFormat='date']").each(function(){
			var time=dateToStr($(this).val());
			var id = $(this).attr("id");//获取id的值
			if(id == "dTransdate") {
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
						<th width="15%">商户号</th>
						<td width="15%"><input id="sMeracct" name="sMeracct"
							style="width: 275px;" class="easyui-validatebox"
							validType="length[0,30]" " /></td>
							<th width="15%">终端号</th>
						<td width="15%"><input id="sTermcode" name="sTermcode"
							style="width: 275px;" class="easyui-validatebox"
							validType="length[0,30]" " /></td>
						<th width="10%">交易日期</th>
						<td width="30%"><input name="dTransdate" dateFormat ="date" type="text" class="easyui-datebox" editable="false"></td>
						
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
							data-options="iconCls:'icon-ui-edit',plain:true"
							onClick="javascript:updateObj();" style="float: left;"></a></td>
						<td><div class="datagrid-btn-separator"></div></td> -->
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>