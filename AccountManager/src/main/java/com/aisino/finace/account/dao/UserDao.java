package com.aisino.finace.account.dao;

import com.aisino.finace.account.entity.MlUser;
import com.aisino.finace.account.entity.User;
import com.aisino.finace.account.utils.orm.mybatis.BaseMybatisDao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseMybatisDao<MlUser, Long> {
	public String getNamespace() {
		return MlUserMapper.class.getCanonicalName();
	}
}