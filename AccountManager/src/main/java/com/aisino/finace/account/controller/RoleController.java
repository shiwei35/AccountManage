package com.aisino.finace.account.controller;

import com.aisino.finace.account.entity.DataGrid;
import com.aisino.finace.account.entity.MlRole;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.RescAuthModel;
import com.aisino.finace.account.entity.User;
import com.aisino.finace.account.service.RoleServiceI;
import com.aisino.finace.account.service.UserServiceI;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/role")
@SessionAttributes("user")
public class RoleController {
	private RoleServiceI roleService = null;
	private UserServiceI userService = null;

	public RoleServiceI getRoleService() {
		return this.roleService;
	}

	@Autowired
	public void setRoleService(RoleServiceI roleService) {
		this.roleService = roleService;
	}

	public UserServiceI getUserService() {
		return this.userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "roleList")
	@ResponseBody
	public DataGrid getRoleList(Page page, MlRole role) {
		PageList<MlRole> roleList = null;
		DataGrid result = new DataGrid();

		try {
			roleList = this.roleService.getRolePageList(page, role);
			if (roleList != null) {
				result.setTotal(Long.valueOf(roleList.getPaginator()
						.getTotalCount()));
				result.setRows(roleList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping(value = "toAddRole")
	public ModelAndView toAddRole() {
		ModelAndView modelViewRole = new ModelAndView();
		modelViewRole.setViewName("system/modifyRole");
		modelViewRole.addObject("flag", "ADD");
		return modelViewRole;
	}

	@RequestMapping(value = "toUpdateRole")
	public ModelAndView toUpdateRole(MlRole role) {
		role = this.roleService.getRoleByPrikey(role);
		ModelAndView modelViewRole = new ModelAndView();
		modelViewRole.setViewName("system/modifyRole");
		modelViewRole.addObject("flag", "UPDATE");
		modelViewRole.addObject("role", role);
		return modelViewRole;
	}

	@RequestMapping(value = "modifyRole")
	@ResponseBody
	public Map<String, Object> modifyRole(MlRole role, String flag, User user) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result = addRole(role, user);
		} else if ("UPDATE".equals(flag)) {
			result = updateRole(role, user);
		} else {
			result.put("success", false);
			result.put("msg", "角色信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addRole(MlRole role, User user) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (role != null) {
				role.setCreateDate(new Date());
				role.setModifyDate(new Date());
				role.setOrgNo(user.getOrgNo());
				role.setOper(user.getUserId());
				this.roleService.createRole(role);
				result.put("success", true);
				result.put("msg", "角色信息添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "角色信息添加失敗！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "角色信息添加失败，服务器端未获得要添加的角色信息！");
		}

		return result;
	}

	private Map<String, Object> updateRole(MlRole role, User user) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (role != null) {
				role.setModifyDate(new Date());
				role.setOrgNo(user.getOrgNo());
				role.setOper(user.getUserId());
				this.roleService.updateRoleByPriKey(role);
				result.put("success", true);
				result.put("msg", "角色信息修改成功！");
			} else {
				result.put("success", Boolean.valueOf(false));
				result.put("msg", "角色信息修改失败，填写的角色信息不完整！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "角色信息修改失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value = "deleteRole")
	@ResponseBody
	public Map<String, Object> deleteRole(long[] roleIds) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (roleIds != null) {
				for (int i = 0; i < roleIds.length; i++)
					if (!this.userService.isRoleBindWithUser(roleIds[i])) {
						this.roleService.deleteRoleByPriKey(roleIds[i]);
						result.put("success", true);
						result.put("msg", "角色信息删除成功！");
					} else {
						result.put("success", false);
						result.put("msg", "角色信息删除失败，用户正在使用该角色！");
					}
			} else {
				result.put("success", false);
				result.put("msg", "角色信息删除失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "角色信息删除失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value = "toRoleAuthManager")
	public ModelAndView toRoleAuthManager(MlRole role) {

		ModelAndView modelViewRole = new ModelAndView();
		modelViewRole.setViewName("system/modifyRoleAuth");// 新的URL
		modelViewRole.addObject("role", role);// 传递RoleId

		return modelViewRole;
	}
	
	@RequestMapping(value = "rescAuthList")
	@ResponseBody
	public Map<String, Object>  loadAuth(MlRole role) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<RescAuthModel> rescAuthList = null;
		
		try {
			rescAuthList= this.roleService.loadRoleAuthTree(role);
			if(rescAuthList!=null){
				result.put("success", true);
				result.put("data", rescAuthList);
			}else{
				result.put("success", false);
				result.put("msg", "角色权限模块未初始化，请联系管理员完成初始化！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "角色权限模块未初始化，请联系管理员完成初始化！");
		}

		return result;
	}
	
	/**
	 * 修改角色权限
	 * @return
	 */
	@RequestMapping(value = "saveRoleAuth")
	@ResponseBody
	public Map<String, Object> saveRoleAuth(long roleId,long[] rescIdList, long[] authIdList) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if(!"".equals(roleId) && (authIdList.length>0 || rescIdList.length>0)){
				//保存权限
				this.roleService.saveRoleResc(roleId, rescIdList);				
				this.roleService.saveRoleAuth(roleId, authIdList);
				
				result.put("success", true);
				result.put("msg", "角色权限设置成功！");
			}else{
				result.put("success", false);
				result.put("msg", "角色权限设置失败，服务器端未获得要修改的角色权限！");
			}
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", "角色权限设置失败，服务器端未获得要修改的角色权限！");
		}

		return result;
	}
}