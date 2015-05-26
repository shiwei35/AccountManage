<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>the dict modify page</title>
<script type="text/javascript">
	$(function() {
		//初始化combobox
		initComboboxContent("dictType", "DICT_TYPE");
		initComboboxContent("status", "STATUS");
		
		if ($("input[name='flag']").val() == "ADD") {
			$('#updatePanel').panel({
				title : '添加数据字典'
			});
		} else {
			$('#updatePanel').panel({
				title : '修改数据字典'
			});
		}
	});

	/*返回列表页*/
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/dictList.do';
	}

	/*保存信息*/
	function saveObj() {
		$('#modifyForm').form(
				'submit',
				{
					url : '${pageContext.request.contextPath}/dict/modifyDict.do',
					success : function(result) {
						try {
							var r = $.parseJSON(result);
							if (r.success) {
								$.messager.alert('信息提示', r.msg, "info",
										backList);
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
<div id="updatePanel" class="easyui-panel"
	data-options="border:false,fit:true"
	style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
	<form id="modifyForm" method="post">
		<table id="update" class="modifytable" width="100%">
			<tr>
				<th align="center" width="35%">字典名称</th>
				<td><input class="easyui-validatebox" name="dictTitle"
					data-options="required:true" value="${dict.dictTitle}"
					style="width: 400px" validType="length[1,50]" /></td>
			</tr>

			<tr>
				<th align="center" width="35%">字典描述</th>
				<td><input class="easyui-validatebox" name="dictDesc"
					data-options="required:true" value="${dict.dictDesc}"
					style="width: 400px" validType="length[1,50]" /></td>
			</tr>

			<tr>
				<th align="center" width="35%">字典类型</th>
				<td><input name="dictType" value="${dict.dictType}"
					id="dictType" style="width: 150px" data-options="required:true,validType:'emptyString[\'#dictType\']'" /></td>
			</tr>

			<tr>
				<th align="center" width="35%">字典状态</th>
				<td><input name="status" value="${dict.status}"
					id="status" style="width: 100px" data-options="required:true,validType:'emptyString[\'#status\']'" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="button" value="保存"
					class="btn" onclick="saveObj();" /> <input type="button" value="返回"
					class="btn" onclick="backList();" /> <input type="hidden"
					name="dictId" value="${dict.dictId}" /> <input type="hidden"
					name="flag" value="${flag}" /></td>
			</tr>
		</table>
	</form>
</div>
</body>