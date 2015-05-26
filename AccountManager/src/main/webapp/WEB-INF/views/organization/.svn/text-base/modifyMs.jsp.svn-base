<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>the mer modify page</title>
<script type="text/javascript">
<!--
$(function() {
	//初始化combobox
	initComboboxContent("sMerstatus", "STATUS");
});

function backList() {
	window.location.href = '${pageContext.request.contextPath}/menu/merchantList.do';
}

function saveObj() { 
	$("input[dateFormat='date']").each(function(){
		var time=dateToStr($(this).val());
		var id = $(this).attr("id");//获取id的值
		if(id == "dMerexpdate") {
			$(this).val(time);
		} else {
			$(this).datebox('setValue',time);
		}
	});
	
	$('#modifyForm').form('submit', {
	   url : '${pageContext.request.contextPath}/org/modifyMer.do',
	   success : function(result) {
		  try {
				var r = $.parseJSON(result);
				
                if (r.success) {
						$.messager.alert('信息提示', r.msg, "info", backList);
					}else{
					   $.messager.alert('信息提示', r.msg, "info");
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
<div id="updatePanel" class="easyui-panel" title="修改商户"
	data-options="border:false,fit:true"
	style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
	<form id="modifyForm" method="get">
		<table id="update" class="modifytable" width="100%">
			<tr>
				<th align="center" width="35%">机构编号</th>
				<td><input  class="easyui-validatebox" name="sOrguuid"
					validType="length[1,10]" data-options="required:true"
					value="${merObj.sOrguuid}" style="width: 400px" /></td>
			</tr>
			<tr>
				<th align="center" width="35%">商户名称</th>
				<td><input class="easyui-validatebox" name="sMername"
					style="width: 400px" validType="length[1,50]" data-options="required:true" value="${merObj.sMername}" /></td>
			</tr>
				
            <tr>
				<th align="center" width="35%">商户状态</th>
				<!-- <td><input  name="sMerstatus" id="sMerstatus"
					data-options="required:true,validType:'emptyString[\'#sMerstatus\']'" value="${merObj.sMerstatus}"
					style="width: 400px" />
				</td> -->
				<td><input class="easyui-validatebox" name="sMerstatus"
					style="width: 400px" validType="length[1,50]" data-options="required:true" value="${merObj.sMerstatus}" /></td>
			</tr>
			</tr>
			<tr>
				<th align="center" width="35%">商户到期时间</th>
				 <td><input name="dMerexpdate" id="dMerexpdate" 
				style="width: 400px" dateFormat ="date" type="text" class="easyui-validatebox"
				 value="${merObj.dMerexpdate}" required="required" editable="false" ></td> 
			</tr>	
				<tr>
				<!-- 城市代码未知，后续加入字典表中 -->
				<th align="center" width="35%">城市代码</th>
				<td><input class="easyui-validatebox" name="sCitycode"
					style="width: 400px" validType="length[1,100]" value="${merObj.sCitycode}" /></td>
			</tr>	
					<tr>
			
				<th align="center" width="35%">城市名称</th>
				<td><input class="easyui-validatebox" name="sCityname"
					style="width: 400px" validType="length[1,100]" value="${merObj.sCityname}" /></td>
			</tr>	
				<tr>
				<th align="center" width="35%">商户联系人姓名</th>
				<td><input class="easyui-validatebox" name="sMercontname"
					style="width: 400px" validType="length[1,100]" value="${merObj.sMercontname}" /></td>
			</tr>
				<tr>
				<th align="center" width="35%">商户联系人电话</th>
				<td><input class="easyui-validatebox" name="sMercontphone"
					style="width: 400px" validType="length[1,100]" value="${merObj.sMercontphone}" /></td>
			</tr>
			<tr>
				<th align="center" width="35%">商户地址</th>
				<td><input class="easyui-validatebox" name="sMeraddr"
					style="width: 400px" validType="length[1,100]" value="${merObj.sMeraddr}" /></td>
			</tr>
			
			<tr>
				<th align="center" width="35%">商户邮编</th>
				<td><input class="easyui-validatebox" name="sMerzip"
					style="width: 400px" validType="length[1,100]" value="${merObj.sMerzip}" /></td>
			</tr>
			<tr>
				<th align="center" width="35%">邮件地址</th>
				<td><input class="easyui-validatebox" name="sEmail"
					style="width: 400px" validType="length[1,100]" value="${merObj.sEmail}" /></td>
			</tr><tr>
				<th align="center" width="35%">备注</th>
				<td><input class="easyui-validatebox" name="sRemark"
					style="width: 400px" validType="length[1,100]" value="${merObj.sRemark}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="保存" class="btn" onclick="saveObj();" />
			    <input type="button" value="返回" class="btn" onclick="backList();" />
         	   <input type="hidden" name="iMercode" value="${merObj.iMercode}" /> 
				<input type="hidden" name="flag" value="${flag}"></td>
			</tr>
		</table>
	</form>
</div>
</body>