package com.aisino.finace.account.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RelationResolverDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public Object getEntityInfo(String entity, String column, Object filter)
			throws Exception {
		String className = "com.aisino.finace.account.dao." + entity + "Mapper";
		String pojo = "com.aisino.finace.account.entity." + entity;
		Class<?> clazz = Class.forName(pojo);
		Field field = clazz.getDeclaredField(column);
		String type = field.getType().toString();
		Object new_entity = null;

		if (type.indexOf("Long") > 0) {
			filter = Long.parseLong((String) filter);
		} else if (type.indexOf("BigDecimal") > 0) {
			filter = new BigDecimal(filter.toString());
		} else if (type.indexOf("String") > 0) {
			filter = (String) filter;
		} else if (type.indexOf("int") > 0) {
			filter = Integer.parseInt((String) filter);
		}
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			new_entity = sqlSession.selectOne(
					className + ".selectByPrimaryKey", filter);
		} finally {
			sqlSession.close();
		}
		return new_entity;
	}

}
