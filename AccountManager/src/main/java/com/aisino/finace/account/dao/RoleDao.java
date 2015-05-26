package com.aisino.finace.account.dao;

import java.util.List;

import com.aisino.finace.account.entity.MlRole;
import com.aisino.finace.account.utils.orm.mybatis.BaseMybatisDao;

import org.springframework.stereotype.Repository;

@Repository
public class RoleDao extends BaseMybatisDao<MlRole, Long> {
	public String getNamespace() {
		return MlRoleMapper.class.getCanonicalName();
	}

	/**
	 * 查询用户所具有的角色信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<MlRole> selectByUserId(Long userId) {
		return getSqlSession().selectList(
				getMybatisMapperNamesapce() + ".selectByUserId", userId);
	}
	
	/**
	 * 查询用户未选择的角色信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<MlRole> getUnselectByUserId(Long userId) {
		return getSqlSession().selectList(
				getMybatisMapperNamesapce() + ".getUnselectByUserId", userId);
	}
}