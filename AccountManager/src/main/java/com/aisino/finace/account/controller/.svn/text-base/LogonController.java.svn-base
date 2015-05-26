package com.aisino.finace.account.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aisino.finace.account.entity.MlUser;
import com.aisino.finace.account.entity.User;
import com.aisino.finace.account.service.LoginServiceI;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({ "/" })
@SessionAttributes("user")
public class LogonController {
	private static final Logger logger = LoggerFactory
			.getLogger(LogonController.class);

	private LoginServiceI loginService = null;

	public LoginServiceI getLoginService() {
		return this.loginService;
	}

	@Autowired
	public void setLoginService(LoginServiceI loginService) {
		this.loginService = loginService;
	}

	@RequestMapping(value = "toLogin")
	public String toLogin() {
		return "index";
	}

	@RequestMapping(value = "logon", method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public ModelAndView logon(String loginId, String password) {
		ModelAndView modelAndView = new ModelAndView();
		Subject currUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(loginId,
				password);
		token.setRememberMe(false);

		try {
			currUser.login(token);

			// 用户信息保存进入session
			User user = this.loginService.getLoginUserPersistInfo(loginId);
			// 获取登陆时间
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String dateStr = dateFormat.format(date);
			user.setLastLogin(date);
			user.setLastLoginDateStr(dateStr);

			Session session = currUser.getSession(true);
			session.setAttribute("user", user);

			modelAndView.setViewName("main");
			modelAndView.addObject("user", user);
		} catch (IncorrectCredentialsException e) {
			modelAndView.addObject("errorMsg", "您所输入的密码不正确！");
			modelAndView.setViewName("index");
		} catch (DisabledAccountException e) {
			modelAndView.addObject("errorMsg", "当前用户已被禁用，请与系统管理员联系！");
			modelAndView.setViewName("index");
		} catch (ExpiredCredentialsException e) {
			modelAndView.addObject("errorMsg", "您输入的密码已过有效期，请与系统管理员联系！");
			modelAndView.setViewName("index");
		} catch (ExcessiveAttemptsException e) {
			modelAndView.addObject("errorMsg", "您输入密码的错误次数已过系统设定，请与系统管理员联系！");
			modelAndView.setViewName("index");
		} catch (UnknownAccountException e) {
			modelAndView.addObject("errorMsg", "系统无此用户！");
			modelAndView.setViewName("index");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			modelAndView.addObject("errorMsg", "未知异常！");
			modelAndView.setViewName("index");
		}

		return modelAndView;
	}

	@RequestMapping(value = "toMenu")
	public String toMenu() {
		return "menu";
	}

	@RequestMapping(value = "toContent")
	public String toContent() {
		return "content";
	}

	@RequestMapping(value = "toHome")
	public String toHome() {
		return "home";
	}
}