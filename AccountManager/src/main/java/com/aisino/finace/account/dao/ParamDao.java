package com.aisino.finace.account.dao;

import org.springframework.stereotype.Repository;

import com.aisino.finace.account.entity.MlSysParam;
import com.aisino.finace.account.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class ParamDao extends BaseMybatisDao<MlSysParam, Long> {

	@Override
	public String getNamespace() {
		return MlSysParamMapper.class.getCanonicalName();
	}

}
