package com.aisino.finace.account.dao;

import org.springframework.stereotype.Repository;

import com.aisino.finace.account.entity.TcIssuserchkacct;
import com.aisino.finace.account.utils.orm.mybatis.BaseMybatisDao;



@Repository
public class AnalyseDao extends BaseMybatisDao<TcIssuserchkacct, Long> {

	@Override
	public String getNamespace() {
		return TcIssuserchkacctMapper.class.getCanonicalName();
	}

}
