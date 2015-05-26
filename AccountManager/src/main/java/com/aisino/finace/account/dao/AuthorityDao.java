package com.aisino.finace.account.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aisino.finace.account.entity.MlSysAuthority;
import com.aisino.finace.account.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class AuthorityDao extends BaseMybatisDao<MlSysAuthority, Long> {

	@Override
	public String getNamespace() {
		return MlSysAuthorityMapper.class.getCanonicalName();
	}

	/**
	 * 查询菜单对应权限信息
	 * 
	 * @param rescId
	 * @return
	 */
	public List<MlSysAuthority> selectByRescId(Long rescId) {
		return getSqlSession().selectList(
				getMybatisMapperNamesapce() + ".selectByRescId", rescId);
	}

	/**
	 * 查询角色对应权限信息
	 * 
	 * @param roleId
	 * @return
	 */
	public List<MlSysAuthority> selectByRoleId(Long roleId) {
		return getSqlSession().selectList(
				getMybatisMapperNamesapce() + ".selectByRoleId", roleId);
	}

}
