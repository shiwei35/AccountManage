package com.aisino.finace.account.service;

import com.aisino.finace.account.entity.MlUser;
import com.aisino.finace.account.entity.Page;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public abstract interface UserServiceI {
	public abstract PageList<MlUser> getUserPageList(Page paramPage,
			MlUser paramMlUser);

	public abstract MlUser getUserByPriKey(MlUser paramMlUser);

	public abstract int createUser(MlUser paramMlUser);

	public abstract int updateUser(MlUser paramMlUser);

	public abstract int deleteUserByKeys(String paramString);

	public abstract int deleteUserRoleByKeys(String paramString);

	public abstract boolean isRoleBindWithUser(long paramLong);

	public void initializePassword(String ids);

	public void addUserRoles(String ids, long userId);
	
	public int deleteUserRole(String ids,long userId);
}