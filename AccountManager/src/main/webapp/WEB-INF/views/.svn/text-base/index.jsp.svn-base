<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<html>
<head>
	<meta charset="utf-8">
	<title>欢迎使用航信账户管理系统</title>
    <link rel="stylesheet" href="${path}resources/css/login.css" type="text/css" media="all" />  
</head> 
<body onload="init();">
<div class="main-content">
  <div id="login-logo"></div>
  <div class="centertable">
  <form action="${path}logon.do" method="post" id="form" >
    <table width="100%" cellpadding="0" cellspacing="0" class="content">
      <tr>
        <td align="right" style="font-size: 12px;">用户名：</td>
        <td align="left"> 
        	<input class="easyui-validatebox" data-options="required:true" type="text" name="loginId" id="loginId" style="width: 180px;"  onMouseOver="this.className='inputover'" onMouseOut="this.className='inputout'" value="sysadmin" />  </td>
			<td><input id="nameInfo" style="display: none;"><font style="color: red;"></font></input></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="right" style="font-size: 12px;">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
        <td align="left">
        <input class="easyui-validatebox" data-options="required:true" type="password" name="password" id="password" style="width: 180px;"  onMouseOver="this.className='inputover'" onMouseOut="this.className='inputout'" value="password" />        </td>
    	<td><div id="passwordInfo" style="display: none;"><font style="color: red;">密码不能为空</font></div></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
	  <tr height="40">
          <td>&nbsp;</td>
          <td align="left">
              <input type="submit" onmouseover="this.className='btn-over'"  onMouseOut="this.className='btn'" class="btn" value="登录" />&nbsp;&nbsp;&nbsp;
              <input id="reset" type="button" onClick="myreset()" value="重置" onMouseOver="this.className='btn-over'" onMouseOut="this.className='btn'" class="btn" />
          </td>						
      </tr>
      <tr height="40">
      	<td>&nbsp;</td>
      	<td id="errorMsg" style="color: red; font-size: 12px;">${errorMsg}</td>
      </tr>
    </table>
    </form>
  </div>


   <div id="login-footer">Copyright ©Aisino 2014-2015 www.aisino-pay.com</div>
</div>
</body>
</html>
