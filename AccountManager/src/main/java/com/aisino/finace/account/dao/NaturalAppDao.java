package com.aisino.finace.account.dao;

import org.springframework.stereotype.Repository;

import com.aisino.finace.account.entity.MlNaturalApp;
import com.aisino.finace.account.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class NaturalAppDao  extends BaseMybatisDao<MlNaturalApp, String>{
	@Override
	public String getNamespace() {
		return MlNaturalAppMapper.class.getCanonicalName();
	}

}
