package com.aisino.finace.account.dao;

import org.springframework.stereotype.Repository;

import com.aisino.finace.account.entity.MlOrg;
import com.aisino.finace.account.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class OrgDao extends BaseMybatisDao<MlOrg, String> {

	@Override
	public String getNamespace() {
		return MlOrgMapper.class.getCanonicalName();
	}

}
