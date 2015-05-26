<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>the dictItem modify page</title>
<script type="text/javascript">
<!--
var dictId = "${dictId}";

$(function() {
	//初始化combobox
	initComboboxContent("status", "STATUS");
	
	
	if ($("input[name='flag']").val() == "Add") {
		$('#updatePanel').panel({
			title : '添加字典项'
		});
	} else {
		$('#updatePanel').panel({
			title : '修改字典项'
		});
	}
});

function backList() {
	window.location.href = '${pageContext.request.contextPath}/dictItem/toItemList.do?dictId='
		+ dictId;
}

function saveObj() {
	$('#modifyForm').form(
			'submit',
			{
				url : '${pageContext.request.contextPath}/dictItem/modifyDictItem.do',
				success : function(result) {
					try {
						var r = $.parseJSON(result);
						if (r.success) {
							$.messager.alert('信息提示', r.msg, "info",
									backList);

						}
					} catch (e) {
						$.messager.alert('信息提示', result);
					}
				}
			});
}
//-->
</script>
</head>
<body>
<div id="updatePanel" class="easyui-panel" title="数据信息"
	data-options="border:false,fit:true"
	style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
	<form id=modifyForm method="post">
		<table id="update" class="modifytable" width="100%">
			<tr>
				<th align="center" width="35%">数据字典项名称</th>
				<td><input class="easyui-validatebox" name="itemTitle"
					value="${item.itemTitle}" required="true" style="width: 400px"
					validType="length[0,20]" /></td>
			</tr>
			<tr>
				<th align="center" width="35%">描述</th>
				<td><input class="easyui-validatebox" name="itemDesc"
					value="${item.itemDesc}" style="width: 400px"
					validType="length[0,20]" /></td>
			</tr>

			<tr>
				<th align="center" width="35%">编码</th>
				<td><input class="easyui-validatebox" name="itemCode"
					value="${item.itemCode}" required="true" style="width: 200px"
					validType="length[0,20]" /></td>
			</tr>
			<tr>
				<th align="center" width="35%">数据字典项值</th>
				<td><input name="itemVal" id="itemVal" value="${item.itemVal}"
					style="width: 200px"/>
				</td>
			</tr>
			<tr>
				<th align="center" width="35%">顺序号</th>
				<td><input name="seq" value="${item.seq}" id="itemSeq" validType="seqChk"
					style="width: 100px" class="easyui-validatebox" /></td>
			</tr>
			<tr>
				<th align="center" width="35%">状态</th>
				<td><input name="status" value="${item.status}" id="status" data-options="required:true,validType:'emptyString[\'#status\']'"
					style="width: 100px" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="button" value="保存"
					class="btn" onclick="saveObj();" /> <input type="button"
					value="返回" class="btn" onclick="backList();" /> <input
					type="hidden" name="itemId" value="${item.itemId}" /> <input
					type="hidden" name="flag" value="${flag}" /> <input type="hidden"
					name="dictId" value="${dictId}"></td>
			</tr>
		</table>
	</form>
</div>
</body>