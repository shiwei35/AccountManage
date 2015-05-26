<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
<!--
	var path='${pageContext.request.contextPath}';
	
//-->
</script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/font-awesome/font-awesome.min.css">
<!--[if IE 7]>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome/font-awesome-ie7.min.css">
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/public.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/js/easyui/themes/default/easyui.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/js/easyui/themes/icon.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/js/easyui/themes/uicon.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
function dateToStr(datetime){
	if(datetime == ""){
		return "";
	}
    var dd=new Date(datetime);
		var year = dd.getFullYear();
		
		var month = dd.getMonth()+1;//js从0开始取
		var date = dd.getDate();
		var hour = dd.getHours();
		var minutes = dd.getMinutes();
		var second = dd.getSeconds();
		if(month<10){
		month = "0" + month;
		}
		if(date<10){
		date = "0" + date;
		}
		if(hour <10){
		hour = "0" + hour;
		}
		if(minutes <10){
		minutes = "0" + minutes;
		}
		if(second <10){
		second = "0" + second ;
		}

		var time = year+"-"+month+"-"+date; //2009-06-12 17:18:05
		// alert(time);
		return time;
		}
		$(function(){
			
			
		});
</script>