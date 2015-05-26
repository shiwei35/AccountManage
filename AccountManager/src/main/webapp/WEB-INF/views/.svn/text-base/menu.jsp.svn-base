<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
<!--
	$(function() {
		loadMenu();
	});

	function loadMenu() {
		var menu = $('#menu');
		$.ajax({
			type : "GET",
			url : "${path}menu/loadMenu.do",
			dataType : "json",
			success : function(result) {
				if (result && result.success == "Y") {
					menu.tree("loadData", result.data);
				} else if (result && result.success == "N") {
					$.messager.alert('错误提示', "导航菜单加载失败，请检查系统状态！");
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$.messager.progress('close');
				$.messager.alert('错误提示', XMLHttpRequest.responseText);
			}
		});
	}
//-->
</script>
<div class="easyui-panel"
	data-options="fit:true,border:false,title:'系统菜单', tools:[{  
                    iconCls:'icon-ui-reload',  
                    handler:loadMenu  
                },{
                	iconCls : 'icon-ui-redo',
					handler : function() {
						var node = $('#menu').tree('getSelected');
						if (node) {
							$('#menu').tree('expandAll', node.target);
						} else {
							$('#menu').tree('expandAll');
						}
					}
                },{
                	iconCls : 'icon-ui-undo',
					handler : function() {
						var node = $('#menu').tree('getSelected');
						if (node) {
							$('#menu').tree('collapseAll', node.target);
						} else {
							$('#menu').tree('collapseAll');
						}
					}
                }]">
	<ul id="menu" class="easyui-tree"
		data-options="parentField : 'pid',lines : true,onClick: function(node){
			if(node.isLeaf=='Y'){
				var url;
				if (node.url) {
					url = '${path}' + node.url;
				} else {
					url = '${path}toError.do';
				}
				addTab({
					title : node.text,
					iconCls : node.iconCls,
					url : url
				});	
			}		
		}" />
</div>