package com.aisino.finace.account.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.finace.account.dao.AuthorityDao;
import com.aisino.finace.account.dao.OrgDao;
import com.aisino.finace.account.dao.RescDao;
import com.aisino.finace.account.dao.RoleDao;
import com.aisino.finace.account.dao.UserDao;
import com.aisino.finace.account.entity.MlOrg;
import com.aisino.finace.account.entity.MlRole;
import com.aisino.finace.account.entity.MlSysAuthority;
import com.aisino.finace.account.entity.MlSysResc;
import com.aisino.finace.account.entity.MlSysRescExample;
import com.aisino.finace.account.entity.MlUser;
import com.aisino.finace.account.entity.MlUserExample;
import com.aisino.finace.account.entity.User;
import com.aisino.finace.account.service.LoginServiceI;

@Service("loginService")
public class LoginServiceImpl implements LoginServiceI {
	private UserDao userDao = null;
	private RoleDao roleDao = null;
	private RescDao rescDao = null;
	private AuthorityDao authorityDao = null;
	private OrgDao orgDao = null;

	public UserDao getUserDao() {
		return this.userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public RescDao getRescDao() {
		return rescDao;
	}

	@Autowired
	public void setRescDao(RescDao rescDao) {
		this.rescDao = rescDao;
	}

	public AuthorityDao getAuthorityDao() {
		return authorityDao;
	}

	@Autowired
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	public OrgDao getOrgDao() {
		return orgDao;
	}

	@Autowired
	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}

	@Override
	public MlUser getUserInfoByLoginId(String loginId) {
		MlUserExample example = new MlUserExample();
		example.createCriteria().andLoginIdEqualTo(loginId);
		return (MlUser) this.userDao.findOne(example);
	}

	@Override
	public User getLoginUserPersistInfo(String loginId) {
		MlUser mlUser = this.getUserInfoByLoginId(loginId);
		if (mlUser == null)
			return null;

		User user = initSessionUser(mlUser);
		Long roleId = user.getRoleId();
		// 搜索用户所有角色
		List<MlRole> roles = this.roleDao.selectByUserId(user.getUserId());
		if (roles != null) {
			user.setRoles(roles);
			MlRole tmpRole = null;
			for (int i = 0; i < roles.size(); ++i) {
				tmpRole = (MlRole) roles.get(i);
				if (tmpRole.getRoleId() == roleId) {
					user.setDefaultRole(tmpRole);
					user.setCurrRole(tmpRole);
					break;
				}
			}
		}

		if (user.getCurrRole() != null) {
			// 查询用户角色对应的菜单
			List<MlSysResc> rescs = this.rescDao.selectRealRescByRoleId(roleId);
			MlSysRescExample example = new MlSysRescExample();
			example.createCriteria().andRescTypeEqualTo("M")
					.andRescStatusEqualTo("1");
			example.setOrderByClause("RESC_SEQ ASC");
			List<MlSysResc> menuList = this.rescDao.findAll(example);
			if (rescs != null) {
				MlSysResc tempResc = null;
				for (int i = 0; i < rescs.size(); ++i) {
					tempResc = rescs.get(i);

					while (tempResc.getParentId() != 0l) {
						tempResc = getParentResc(menuList, tempResc);
						if (!isExistRescs(rescs, tempResc)) {
							rescs.add(tempResc);
						}
					}
				}
			}
			user.setRescs(rescs);

			// 查询角色拥有的操作权限
			List<MlSysAuthority> authorities = this.authorityDao
					.selectByRoleId(roleId);
			user.setAuthorities(authorities);
		}

		// 设置用户机构信息
		MlOrg org = this.orgDao.getById(user.getOrgNo());
		user.setOrg(org);

		return user;
	}

	private MlSysResc getParentResc(List<MlSysResc> menuList, MlSysResc resc) {
		MlSysResc parentResc = null;
		MlSysResc tempResc = null;

		for (int i = 0; i < menuList.size(); ++i) {
			tempResc = menuList.get(i);
			if (tempResc.getRescId() == resc.getParentId()) {
				parentResc = tempResc;
				break;
			}
		}

		return parentResc;
	}

	private boolean isExistRescs(List<MlSysResc> ownerRescs, MlSysResc resc) {
		boolean result = false;

		MlSysResc tempResc = null;
		for (int i = 0; i < ownerRescs.size(); ++i) {
			tempResc = (MlSysResc) ownerRescs.get(i);
			if (tempResc.getRescId() == resc.getRescId()) {
				result = true;
				break;
			}
		}

		return result;
	}

	/**
	 * 将User对象convert to session Obj
	 * 
	 * @param mlUser
	 * @return
	 */
	private User initSessionUser(MlUser mlUser) {
		User user = new User();

		user.setUserId(mlUser.getUserId());
		user.setOrgNo(mlUser.getOrgNo());
		user.setName(mlUser.getName());
		user.setDescription(mlUser.getDescription());
		user.setLoginId(mlUser.getLoginId());
		user.setPassword(mlUser.getPassword());
		user.setRoleId(mlUser.getRoleId());
		user.setStatus(mlUser.getStatus());
		user.setCreated(mlUser.getCreated());
		user.setLastLogin(mlUser.getLastLogin());
		user.setLastLogip(mlUser.getLastLogip());
		user.setPassInvalidDate(mlUser.getPassInvalidDate());
		user.setPassErrCount(mlUser.getPassErrCount());

		return user;
	}
}