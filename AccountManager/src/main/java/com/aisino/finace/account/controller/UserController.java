package com.aisino.finace.account.controller;

import com.aisino.finace.account.entity.DataGrid;
import com.aisino.finace.account.entity.MlRole;
import com.aisino.finace.account.entity.MlUser;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.User;
import com.aisino.finace.account.entity.UserRoleEntity;
import com.aisino.finace.account.service.RoleServiceI;
import com.aisino.finace.account.service.UserServiceI;
import com.aisino.finace.account.utils.SysUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes("user")
public class UserController {
	private UserServiceI userService = null;
	private RoleServiceI roleService = null;

	public UserServiceI getUserService() {
		return this.userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	public RoleServiceI getRoleService() {
		return roleService;
	}

	@Autowired
	public void setRoleService(RoleServiceI roleService) {
		this.roleService = roleService;
	}

//	@RequiresPermissions("SYS_MANAGE:USER_LIST")
	@RequestMapping(value = "userlist")
	@ResponseBody
	public DataGrid getUserList(Page page, MlUser userObj) {
		PageList<MlUser> userList = null;
		DataGrid result = new DataGrid();

		try {
			userList = this.userService.getUserPageList(page, userObj);
			if (userList != null) {
				result.setTotal(Long.valueOf(userList.getPaginator()
						.getTotalCount()));
				result.setRows(userList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping(value = "toAddUser")
	public ModelAndView toAddUser() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("system/modifyUser");
		modelView.addObject("flag", "ADD");
		return modelView;
	}

	@RequestMapping(value = "toUpdateUser")
	public ModelAndView toUpdateUser(MlUser userObj) {
		try {
			userObj = this.userService.getUserByPriKey(userObj);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("system/modifyUser");
		modelView.addObject("flag", "UPDATE");
		modelView.addObject("userObj", userObj);
		return modelView;
	}

	@RequestMapping(value = "modifyUser")
	@ResponseBody
	public Map<String, Object> modifyUser(MlUser userObj, String flag,
			@ModelAttribute("user") User user) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result = addUser(userObj, user);
		} else if ("UPDATE".equals(flag)) {
			result = updateUser(userObj, user);
		} else {
			result.put("success", false);
			result.put("msg", "用户信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public HashMap<String, Object> addUser(MlUser userObj, User user) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		try {
			if (userObj != null) {
				userObj.setOrgNo(user.getOrgNo());
				userObj.setCreated(new Date());
				userObj.setPassErrCount(0);
				userObj.setPassword(SysUtil.encryptByMd5("888888"));
				this.userService.createUser(userObj);
				result.put("success", true);
				result.put("msg", "用户信息添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "用户信息添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常");
		}

		return result;
	}

	public Map<String, Object> updateUser(MlUser userObj, User user) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (userObj != null) {
				this.userService.updateUser(userObj);
				result.put("success", true);
				result.put("msg", "用户信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "用户信息修改失败，服务器端未获得要修改的用户信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "用户信息修改失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value = "deleteUser")
	@ResponseBody
	public Map<String, Object> deleteUser(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.userService.deleteUserRoleByKeys(ids);

				this.userService.deleteUserByKeys(ids);
				result.put("success", true);
				result.put("msg", "用户信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "用户信息删除失败，服务器端未获得要删除的用户信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "用户信息删除失败，服务器端处理异常！");
		}

		return result;
	}

	/**
	 * Description 初始化用户密码
	 * 
	 * @param ids
	 * @return result
	 * @author
	 */
	@RequestMapping(value = "initPwd")
	@ResponseBody
	public Map<String, Object> toInitializePwd(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (ids != null && !"".equals(ids.trim())) {
				this.userService.initializePassword(ids);
				result.put("success", true);
				result.put("msg", "用户密码初始化成功！");
			} else {
				result.put("success", false);
				result.put("msg", "用户密码初始化失败，服务器端未获得要用户密码初始化的信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "用户密码初始化失败，服务器端处理异常！");
		}

		return result;
	}

	/**
	 * Description 进入用戶角色管理界面
	 * 
	 * @param userId
	 * @return modelViewRole
	 * @author
	 */
	@RequestMapping(value = "toUserRoleConfig")
	public ModelAndView toUserRoleManager(long userId) {

		ModelAndView modelViewRole = new ModelAndView();
		MlUser userObj = new MlUser();
		userObj.setUserId(userId);
		userObj = this.userService.getUserByPriKey(userObj);
		modelViewRole.setViewName("system/userRoleConfig");// 新的URL
		modelViewRole.addObject("userObj", userObj);// 传递UserId
		return modelViewRole;
	}

	@RequestMapping(value = "loadUnselectedRole")
	@ResponseBody
	public DataGrid loadUnselectedRole(MlRole role, long userId) {
		List<MlRole> roleList = null;
		DataGrid dataGrid = new DataGrid();

		try {
			roleList = this.roleService.loadUnselectedRole(userId);
			if (roleList != null) {
				dataGrid.setRows(roleList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataGrid;
	}

	@RequestMapping(value = "loadSelectedRole")
	@ResponseBody
	public DataGrid loadSelectedRole(MlRole role, long userId) {
		List<MlRole> roleList = null;
		List<UserRoleEntity> userRoleList = new ArrayList<UserRoleEntity>();
		;
		DataGrid dataGrid = new DataGrid();

		try {
			roleList = this.roleService.loadSelectedRole(userId);
			if (roleList != null) {
				MlUser selUser = new MlUser();
				selUser.setUserId(userId);
				selUser = this.userService.getUserByPriKey(selUser);

				MlRole tempRole = null;
				UserRoleEntity userRoleEntity = null;
				for (int i = 0; i < roleList.size(); ++i) {
					tempRole = (MlRole) roleList.get(i);
					userRoleEntity = new UserRoleEntity();
					userRoleEntity.setRoleId(tempRole.getRoleId());
					userRoleEntity.setRoleName(tempRole.getRoleName());
					userRoleEntity.setRoleDesc(tempRole.getRoleDesc());
					userRoleEntity.setOrgNo(tempRole.getOrgNo());
					if (selUser.getRoleId() != null
							&& selUser.getRoleId() == tempRole.getRoleId()) {
						userRoleEntity.setIsDefaultRole("Y");
					}
					userRoleList.add(userRoleEntity);
				}
			}

			dataGrid.setRows(userRoleList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataGrid;
	}

	@RequestMapping(value = "addUserRole")
	@ResponseBody
	public Map<String, Object> addUserRole(String ids, long userId) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (ids != null && !"".equals(ids.trim())) {
				this.userService.addUserRoles(ids, userId);
				result.put("success", true);
				result.put("msg", "用户角色添加成功！");
			} else {
				result.put("success", false);
				result.put("msg", "用户角色添加失败，服务器端未获得要添加的角色信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "用户角色添加失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value = "setDefaultRole")
	@ResponseBody
	public Map<String, Object> addDefaultRole(long roleId, long userId) {

		Map<String, Object> result = new HashMap<String, Object>();
		MlUser userObj = new MlUser();
		try {
			// 修改用户信息里面的roleId
			userObj.setUserId(userId);
			userObj.setRoleId(roleId);
			this.userService.updateUser(userObj);
			result.put("success", true);
			result.put("msg", "用户默认角色添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "用户默认角色添加失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value = "deleteUserRole")
	@ResponseBody
	public Map<String, Object> deleteUserRole(String ids, long userId) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (ids != null && !"".equals(ids.trim())) {
				this.userService.deleteUserRole(ids, userId);
				result.put("success", true);
				result.put("msg", "用户角色取消成功！");
			} else {
				result.put("success", false);
				result.put("msg", "用户角色取消失败，服务器端未获得要取消的角色信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "用户角色取消失败，服务器端处理异常！");
		}

		return result;
	}	
	
	/**
	 * Description 修改用户基本信息
	 * 
	 * @param user
	 * @return result
	 * @author 
	 */
	@RequestMapping(value = "saveOwnerInfo")
	@ResponseBody
	public Map<String, Object> basicUserInfoModfiy(@ModelAttribute("user") User user) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (user != null) {
				this.userService.updateUser(user);
				result.put("success", true);
				result.put("msg", "用户基本信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "用户基本信息修改失败，服务器端未获得要修改的用户基本信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "用户基本信息修改失败，服务器端处理异常！");
		}

		return result;
	}
	
	/**
	 * Description 修改密码
	 * 
	 * @param user
	 * @param oldPassword
	 * @param newPassword
	 * @return result
	 * @author 
	 */
	@RequestMapping(value = "modifyPassWord")
	@ResponseBody
	public Map<String, Object> modifyPassword(String oldPassword,
			String newPassword, @ModelAttribute("user") User user) {

		Map<String, Object> result = new HashMap<String, Object>();
		String encryptInputOldPwd = SysUtil.encryptByMd5(oldPassword);
		String encryptOldPwd = user.getPassword();

		if (!encryptOldPwd.equals(encryptInputOldPwd)) {
			result.put("msg", "您输入的原密码有误，请重新输入！");
		} else {
			try {
				if (user != null) {
					user.setPassword(SysUtil.encryptByMd5(newPassword));
					this.userService.updateUser(user);
					result.put("success", true);
					result.put("msg", "密码修改成功！");
				} else{
					result.put("success", false);
					result.put("msg", "密码修改失败，服务器端未获得要修改的用户密码信息！");
				}
			} catch (Exception e) {
				e.printStackTrace();
				result.put("success", false);
				result.put("msg", "用户密码修改失败，服务器端处理异常！");
			}
		}

		return result;
	}
}