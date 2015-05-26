<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商户账户明细</title>
<script type="text/javascript">
<!--
	$(function() {
		
	});
	
	/*返回列表页*/
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/merAccList.do';
	}

	/*保存参数*/
	function saveObj() {
		$('#modifyForm').form('submit', {
			url : '${pageContext.request.contextPath}/merAccDetail/modifyParam.do',
			success : function(result) { 
				alert(result); 
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$.messager.alert('信息提示', r.msg, "info", backList);
					}
				} catch (e) {
					$.messager.alert('信息提示', result, "info");
				}
			}
		});
	}
//-->
</script>
</head>
<body>
	<div id="updatePanel" class="easyui-panel" title="修改明细"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table id="update" class="modifytable" width="100%">
				<tr>
					<th align="center" width="20%">账号编号</th>
					<td><input value="${currentParam.sAcctcode}" name="sAcctcode"></input></td> 
				</tr>
				<tr>
					<th align="center" width="20%">卡号</th>
					<td><input value="${currentParam.iCardno}" name="iCardno"  validType="length[1,50]" data-options="required:true"  class="easyui-validatebox" ></input></td>
				</tr>
				<tr>
					<th align="center" width="20%">卡类型</th>
					<td ><input value="${currentParam.sCardtype}" name="sCardtype"></input></td>
				</tr>
				<tr>
					<th align="center" width="20%">卡状态</th>
					<td><input value="${currentParam.sCardstatus}" name="sCardstatus"></input> </td>
				</tr>
					<tr>
					<th align="center" width="20%">账户标识</th>
					<td><input value="${currentParam.iAcctid}" name="iAcctid"></input> </td>
				</tr>
					<tr>
					<th align="center" width="20%">人民币余额</th>
					<td><input value="${currentParam.fRmbbalance}" name="fRmbbalance"></input> </td>
				</tr>	
				<tr>
					<th align="center" width="20%">积分余额</th>
					<td><input value="${currentParam.fPointbalance}" name="fPointbalance"></input></td> 
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObj();" /> <input type="button"
						value="返回" class="btn" onclick="backList();" /> <input
						type="hidden" name="iCardid" value="${currentParam.iCardid}" /> <input
						type="hidden" name="flag" value="${flag}" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>