<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>the resc modify page</title>
<script type="text/javascript">
<!--
	$(function() {
		//初始化combobox
		initComboboxContent("isLeaf", "YES_OR_NO");
		initComboboxContent("rescStatus", "STATUS");
		initComboboxContent("rescNamespace", "RESC_NAMESPACE");
		initRescParentId();
	});

	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/rescList.do';
	}

	//保存信息
	function saveObj() {
		if (!validate()) {
			return;
		}

		$('#modifyForm').form('submit', {
			url : '${pageContext.request.contextPath}/resc/modifyResc.do',
			success : function(result) {
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$.messager.alert('信息提示', r.msg, "info", backList);
					}
				} catch (e) {
					$.messager.alert('信息提示', result);
				}
			}
		});
	}

	//检查输入是否有效
	function validate() {
		return true;
	}

	function initRescParentId() {
		$("#parentId").combobox({
			url : '${pageContext.request.contextPath}/resc/getParentResc.do',
			valueField : 'value',
			textField : 'title',
			editable : false,
			multiple : false,
			panelHeight : 200
		});
	}
//-->
</script>
</head>
<body>
	<div id="updatePanel" class="easyui-panel" title="数据信息"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="35%">模块名称</th>
					<td><input class="easyui-validatebox" name="rescName"
						value="${resc.rescName}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 400px;" id="rescName" /></td>
				</tr>

				<tr>
					<th align="center" width="35%">模块描述</th>
					<td><input class="easyui-validatebox" name="rescDesc"
						data-options="validType:'length[0,80]'" value="${resc.rescDesc}"
						style="width: 400px" /></td>
				</tr>

				<tr>
					<th align="center" width="35%">显示名称</th>
					<td><input name="rescTitle" id="rescTitle"
						class="easyui-validatebox"
						data-options="required:true,validType:'length[0,50]'"
						value="${resc.rescTitle}" style="width: 400px" /></td>
				</tr>
				<tr>
					<th align="center" width="35%">命名空间</th>
					<td><input name="rescNamespace" id="rescNamespace"
						value="${resc.rescNamespace}" style="width: 200px" data-options="required:true,validType:'emptyString[\'#rescNamespace\']'" />
					</td>
				</tr>
				<tr>
					<th align="center" width="35%">模块链接</th>
					<td><input class="easyui-validatebox" name="rescUrl"
						value="${resc.rescUrl}" data-options="validType:'length[0,50]'"
						style="width: 400px" /></td>
				</tr>

				<tr>
					<th align="center" width="35%">父级模块</th>
					<td><input name="parentId" id="parentId" style="width: 200px"
						value="${resc.parentId=='0'?'':resc.parentId}" /></td>
				</tr>
				<tr>
					<th align="center" width="35%">是否叶子节点</th>
					<td><input name="isLeaf" value="${resc.isLeaf}" id="isLeaf"
						data-options="required:true,validType:'emptyString[\'#isLeaf\']'"
						style="width: 100px" /></td>
				</tr>

				<tr>
					<th align="center" width="35%">顺序号</th>
					<td><input name="rescSeq" value="${resc.rescSeq}"
						class="easyui-validatebox" data-options="validType:'number'"
						style="width: 150px" /></td>
				</tr>

				<tr>
					<th align="center" width="35%">模块状态</th>
					<td><input name="rescStatus" value="${resc.rescStatus}"
						id="rescStatus"
						data-options="required:true,validType:'emptyString[\'#rescStatus\']'"
						style="width: 100px" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="button" value="保存"
						class="btn" onclick="javascript:saveObj();" /> <input
						type="button" value="返回" class="btn"
						onclick="javascript:backList();" /> <input type="hidden"
						name="rescId" value="${resc.rescId}" /> <input type="hidden"
						name="flag" value="${flag}"></td>
				</tr>
			</table>
		</form>
	</div>
</body>