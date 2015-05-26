package com.aisino.finace.account.dao;

import org.springframework.stereotype.Repository;

import com.aisino.finace.account.entity.MlRoleAuth;
import com.aisino.finace.account.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class RoleAuthDao extends BaseMybatisDao<MlRoleAuth, Long> {

	@Override
	public String getNamespace() {
		return MlRoleAuthMapper.class.getCanonicalName();
	}

}
