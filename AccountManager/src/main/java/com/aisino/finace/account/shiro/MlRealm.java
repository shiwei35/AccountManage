package com.aisino.finace.account.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aisino.finace.account.entity.MlRole;
import com.aisino.finace.account.entity.MlSysAuthority;
import com.aisino.finace.account.entity.MlSysResc;
import com.aisino.finace.account.entity.MlUser;
import com.aisino.finace.account.entity.User;
import com.aisino.finace.account.service.LoginServiceI;

@Component
public class MlRealm extends AuthorizingRealm {
	private LoginServiceI loginService = null;

	public LoginServiceI getLoginService() {
		return loginService;
	}

	@Autowired
	public void setLoginService(LoginServiceI loginService) {
		this.loginService = loginService;
	}

	@PostConstruct
	public void initCredentialsMatcher() {// MD5加密
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("MD5");

		setCredentialsMatcher(matcher);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		Subject currUser = SecurityUtils.getSubject();
		Session session = currUser.getSession(false);
		User user = (User) session.getAttribute("user");

		if (user != null) {
			List<MlRole> roles = user.getRoles();
			List<String> roleStrs = new ArrayList<String>();
			MlRole tmpRole = null;
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

			if (roles != null) {
				for (int i = 0; i < roles.size(); ++i) {
					tmpRole = (MlRole) roles.get(i);
					roleStrs.add(tmpRole.getRoleName());
				}
			}

			List<String> authorityStrs = new ArrayList<String>(); // 权限码
			List<MlSysResc> rescs = user.getRescs(); // 用户拥有权限的资源

			List<MlSysAuthority> authorities = user.getAuthorities();
			MlSysResc tmpResc = null;
			MlSysAuthority tmpAuthority = null;
			// 生成用户的权限字符串，格式为："模块编号:操作权限"
			if (rescs != null) {
				String tmpPermissionStr = null;
				for (int i = 0; i < rescs.size(); ++i) {
					tmpResc = (MlSysResc) rescs.get(i);
					if ("Y".equals(tmpResc.getIsLeaf())) {
						tmpPermissionStr = tmpResc.getRescNamespace();
						String permissionStr = null;
						if (authorities != null) {
							for (int j = 0; j < authorities.size(); ++j) {
								tmpAuthority = (MlSysAuthority) authorities
										.get(j);
								if (tmpResc.getRescId() == tmpAuthority
										.getRescId()) {
									permissionStr = tmpPermissionStr + ":"
											+ tmpAuthority.getAuthCode();
									System.out.println("=====>>>>>>>权限码："
											+ permissionStr);
									authorityStrs.add(permissionStr);
								}
							}
						}
					}
				}
			}

			info.addRoles(roleStrs);
			info.addStringPermissions(authorityStrs);
			return info;
		} else {
			return null;
		}
	}

	/**
	 * 认证用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		MlUser user = this.loginService.getUserInfoByLoginId(token
				.getUsername());

		if (user != null) {
			// if ("1".equals(user.getStatus())) {
			// // 用户被禁用，抛出异常
			// throw new DisabledAccountException("用户已被禁用");
			// }
			// Date currDate = new Date();
			// if (user.getPassInvalidDate() != null) {
			// if (currDate.after(user.getPassInvalidDate())) {
			// // 密码失效，抛出异常
			// throw new ExpiredCredentialsException("用户密码失效");
			// }
			// }
			// if (user.getPassErrCount() > 3) {
			// // 连续验密错误超过系统配置次数，抛出异常
			// throw new ExcessiveAttemptsException("连续验密错误超过系统设置");
			// }

			return new SimpleAuthenticationInfo(user.getLoginId(),
					user.getPassword(), getName());
		} else {
			// 用户不存在，抛出异常
			throw new UnknownAccountException("系统无此用户");
		}
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
}
