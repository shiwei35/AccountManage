<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>the param modify page</title>
<script type="text/javascript">
<!--
	$(function() {
		$("#paramModule").text(getDictItem("SYS_MODULE",'${currentParam.module}'));
	});
	
	/*返回列表页*/
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/paramList.do';
	}

	/*保存参数*/
	function saveObj() {
		$('#modifyForm').form('submit', {
			url : '${pageContext.request.contextPath}/param/modifyParam.do',
			success : function(result) {
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
	<div id="updatePanel" class="easyui-panel" title="修改参数"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table id="update" class="modifytable" width="100%">
				<tr>
					<th align="center" width="35%">参数名称</th>
					<td>${currentParam.paramTitle}</td>
				</tr>
				<tr>
					<th align="center" width="35%">参数编码</th>
					<td>${currentParam.paramCode}</td>
				</tr>
				<tr>
					<th align="center" width="35%">所属模块</th>
					<td id="paramModule">${currentParam.module}</td>
				</tr>
				<tr>
					<th align="center" width="35%">参数值</th>
					<td><input class="easyui-validatebox" name="paramVal"
						validType="length[1,6]" value="${currentParam.paramVal}"
						style="width: 100px" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObj();" /> <input type="button"
						value="返回" class="btn" onclick="backList();" /> <input
						type="hidden" name="paramId" value="${currentParam.paramId}" /> <input
						type="hidden" name="flag" value="${flag}" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>