package com.aisino.finace.account.service;


import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.TmMerinfo;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public abstract interface MerchantServiceI {
	public abstract PageList<TmMerinfo> getMerPageList(Page page,
			TmMerinfo merObj);

	public abstract int createMer(TmMerinfo merObj);
	
	public abstract int updateMer(TmMerinfo merObj);
	
 	public abstract TmMerinfo getMerByPriKey(TmMerinfo merObj);
 	
 	
 	public abstract int deleteMerByKeys(String ids);
	/**
	 * 
	 *

	public abstract int createUser(TmMerinfo paramMlUser);

	

	

	public abstract int deleteUserRoleByKeys(String paramString);

	public abstract boolean isRoleBindWithUser(long paramLong);

	public void initializePassword(String ids);

	public void addUserRoles(String ids, long userId);
	
	public int deleteUserRole(String ids,long userId);
	 * 
	 */
	

}