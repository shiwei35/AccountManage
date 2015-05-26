<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
<!--
function refreshMainTab(title) {
	$('#mainTabs').tabs('getTab', title).panel('refresh');
}

function addTab(params) {
	var iframe = '<iframe src="' + params.url + '" frameborder="0" style="border:0;width:100%;height:100%;"></iframe>';
	var t = $('#mainTabs');
	var opts = {
		title : params.title,
		closable : true,
		iconCls : params.iconCls,
		content : iframe,
		border : false,
		fit : true
	};
	if (t.tabs('exists', opts.title)) {
		t.tabs('select', opts.title);
		var tab =t.tabs('getSelected');  // get selected panel
		tab.panel('refresh', opts.href);
	} else {
		t.tabs('add', opts);
	}
}

/* function addMainTab(opts) {
	var t = $('#mainTabs');
	if (t.tabs('exists', opts.title)) {
		t.tabs('select', opts.title);
		var tab =t.tabs('getSelected');  // get selected panel
		tab.panel('refresh', opts.href);
	} else {
		t.tabs('add', opts);
	}
} */
//-->
</script>
<div id="mainTabs" class="easyui-tabs"
	data-options="fit:true,border:false" style="overflow: hidden;">
	<div title="首页" data-options="border:false" style="overflow: hidden;">
		<iframe src="${path}toHome.do" frameborder="0" style="border: 0; width: 100%; height: 100%;"></iframe>
	</div>
</div>
<div id="mainTabsMenu" style="width: 120px; display: none;">
	<div type="refresh">刷新</div>
	<div class="menu-sep"></div>
	<div type="close">关闭</div>
	<div type="closeOther">关闭其他</div>
	<div type="closeAll">关闭所有</div>
</div>