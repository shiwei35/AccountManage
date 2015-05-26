package com.aisino.finace.account.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.finace.account.dao.UserDao;
import com.aisino.finace.account.dao.UserRoleDao;
import com.aisino.finace.account.entity.MlUser;
import com.aisino.finace.account.entity.MlUserExample;
import com.aisino.finace.account.entity.MlUserRole;
import com.aisino.finace.account.entity.MlUserRoleExample;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.service.UserServiceI;
import com.aisino.finace.account.utils.SysUtil;
import com.aisino.finace.account.utils.key.KeyGenerator;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	private UserDao userDao = null;
	private UserRoleDao userRoleDao = null;
	private final String _ORDER_ATTRS = "name,loginId,description,status";
	private final String _ORDER_FIELDS = "NAME,LOGIN_ID,DESCRIPTION,STATUS";

	public UserDao getUserDao() {
		return this.userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserRoleDao getUserRoleDao() {
		return this.userRoleDao;
	}

	@Autowired
	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	public PageList<MlUser> getUserPageList(Page page, MlUser user) {
		MlUserExample example = new MlUserExample();
		String name = user.getName();
		String loginId = user.getLoginId();
		MlUserExample.Criteria criteria = example.createCriteria();

		if ((name != null) && (!"".equals(name))) {
			criteria.andNameLike("%" + name + "%");
		}

		if ((loginId != null) && (!"".equals(loginId))) {
			criteria.andLoginIdLike("%" + loginId + "%");
		}

		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!"".equals(order)) {
			example.setOrderByClause(order);
		}

		return this.userDao.findPage(SysUtil.convertPage(page), example);
	}

	public MlUser getUserByPriKey(MlUser user) {
		return (MlUser) this.userDao.getById(user.getUserId());
	}

	public int createUser(MlUser user) {
		user.setUserId(KeyGenerator.getNextKey("ML_USER", "USER_ID"));
		return this.userDao.save(user);
	}

	public int updateUser(MlUser user) {
		return this.userDao.updateSelective(user);
	}

	public int deleteUserByKeys(String ids) {
		MlUserExample example = new MlUserExample();
		String[] idArray = ids.split(",");
		List idList = new ArrayList();

		for (int i = 0; i < idArray.length; i++) {
			idList.add(idArray[i]);
		}
		example.createCriteria().andUserIdIn(idList);
		int result = this.userDao.deleteByExample(example);

		return result;
	}

	public int deleteUserRoleByKeys(String ids) {
		String[] idArray = ids.split(",");
		List idList = new ArrayList();
		MlUserRoleExample example = new MlUserRoleExample();

		for (int i = 0; i < idArray.length; i++) {
			idList.add(idArray[i]);
		}
		example.createCriteria().andUserIdIn(idList);
		int result = this.userRoleDao.deleteByExample(example);

		return result;
	}

	public boolean isRoleBindWithUser(long roleId) {
		MlUserRoleExample example = new MlUserRoleExample();
		example.createCriteria().andRoleIdEqualTo(Long.valueOf(roleId));
		List userRoleList = this.userRoleDao.findAll(example);

		return (userRoleList != null) && (userRoleList.size() > 0);
	}

	@Override
	public void initializePassword(String ids) {
		MlUserExample example = new MlUserExample();
		String[] idArray = ids.split(",");
		List idList = new ArrayList();

		for (int i = 0; i < idArray.length; ++i) {
			idList.add(idArray[i]);
		}
		example.createCriteria().andUserIdIn(idList);
		MlUser user = new MlUser();
		user.setPassword(SysUtil.encryptByMd5("888888"));
		Map param = new HashMap();
		param.put("example", example);
		param.put("record", user);
		this.userDao.updateByExampleSelective(param);
	}

	@Override
	public void addUserRoles(String ids, long userId) {
		String[] idArray = ids.split(",");

		if (idArray.length > 0) {
			for (int i = 0; i < idArray.length; i++) {
				MlUserRole userRole = new MlUserRole();
				userRole.setRoleId(Long.parseLong(idArray[i]));
				userRole.setUserId(userId);
				this.userRoleDao.save(userRole);
			}
		}
	}

	@Override
	public int deleteUserRole(String ids, long userId) {
		String[] idArray = ids.split(",");
		List idList = new ArrayList();
		for (int i = 0; i < idArray.length; ++i) {
			idList.add(idArray[i]);
		}
		MlUserRoleExample example = new MlUserRoleExample();
		example.createCriteria().andUserIdEqualTo(userId).andRoleIdIn(idList);

		int result = this.userRoleDao.deleteByExample(example);
	
		return result;
	}
}