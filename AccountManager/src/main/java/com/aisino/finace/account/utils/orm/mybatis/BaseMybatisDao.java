package com.aisino.finace.account.utils.orm.mybatis;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.util.Assert;

import com.aisino.finace.account.utils.orm.EntityDao;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public abstract class BaseMybatisDao<E, PK extends Serializable> extends
		SqlSessionDaoSupport implements EntityDao<E, PK> {

	protected final Log log = LogFactory.getLog(getClass());

	public abstract String getNamespace();

	@Override
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	protected void checkDaoConfig() {
		super.checkDaoConfig();
		Assert.notNull(getNamespace(), "Property 'namespace' are required");
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getById(PK primaryKey) {
		return (E) getSqlSession().selectOne(getFindByPrimaryKeyStatement(),
				primaryKey);
	}
	@SuppressWarnings("unchecked")
	public E getById(BigDecimal primaryKey) {
		return (E) getSqlSession().selectOne(getFindByPrimaryKeyStatement(),
				primaryKey);
	}
	@SuppressWarnings("unused")
	@Override
	public int deleteById(PK id) {
		return getSqlSession().delete(getDeleteStatement(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int deleteByExample(Object exampleParam) {
		return getSqlSession().delete(getDeleteByExampleStatement(),
				exampleParam);
	}

	@SuppressWarnings("unused")
	public int save(E entity) {
		prepareObjectForSaveOrUpdate(entity);
		return getSqlSession().insert(getInsertStatement(), entity);
	}

	@SuppressWarnings("unused")
	@Override
	public int saveSelective(E entity) {
		prepareObjectForSaveOrUpdate(entity);
		return getSqlSession().insert(getInsertStatement() + "Selective",
				entity);
	}

	@SuppressWarnings("unused")
	@Override
	public int update(E entity) {
		prepareObjectForSaveOrUpdate(entity);
		return getSqlSession().update(getUpdateStatement(), entity);
	}

	@SuppressWarnings("unused")
	@Override
	public int updateSelective(E entity) {
		prepareObjectForSaveOrUpdate(entity);
		return getSqlSession().update(getUpdateStatement() + "Selective",
				entity);
	}
	
	@SuppressWarnings("unused")
	@Override
	public int updateByExampleSelective(Map param){
		return getSqlSession().update(getUpdateByExampleSelectiveStatement(),param);
		
	}

	/**
	 * 用于子类覆盖,在insert,update之前调用
	 * 
	 * @param o
	 */
	protected void prepareObjectForSaveOrUpdate(E o) {
	}

	@Override
	public int saveOrUpdate(E entity) {
		int result = -1;
		Field[] fs = entity.getClass().getDeclaredFields();
		try {
			for (Field field : fs) {
				if (field.isAnnotationPresent(IdField.class)) {
					field.setAccessible(true);
					if (field.get(entity) == null)
						result = save(entity);
					else
						result = update(entity);
					field.setAccessible(false);
				}
			}
		} catch (Exception e) {
			throw new InvalidDataAccessApiUsageException(e.getMessage(),
					e.getCause());
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAll() {
		return getSqlSession().selectList(getSelectByExampleStatement());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll(Object exampleParam) {
		return getSqlSession().selectList(getSelectByExampleStatement(),
				exampleParam);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll(String statement, Object param) {
		return getSqlSession().selectList(statement, param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageList<E> findPage(PageBounds pq, Object exampleParam) {
		return (PageList<E>) MybatisPageQueryUtils.pageQueryExample(
				getSqlSession(), getNamespace(), exampleParam, pq);
	}

	@Override
	public PageList<E> findPage(String statement, PageBounds pq, Object param) {
		return findPage(statement, statement + ".count", pq, param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageList<E> findPage(String statement, String countStatement,
			PageBounds pq, Object param) {
		return (PageList<E>) MybatisPageQueryUtils.pageQuery(getSqlSession(),
				statement, countStatement, param, pq);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findOne(Object exampleParam) {
		return (E) getSqlSession().selectOne(getSelectByExampleStatement(),
				exampleParam);
	}

	public String getMybatisMapperNamesapce() {
		return this.getNamespace();
	}

	public String getFindByPrimaryKeyStatement() {
		return getMybatisMapperNamesapce() + ".selectByPrimaryKey";
	}

	public String getInsertStatement() {
		return getMybatisMapperNamesapce() + ".insert";
	}

	public String getUpdateStatement() {
		return getMybatisMapperNamesapce() + ".updateByPrimaryKey";
	}
	
	public String getUpdateByExampleSelectiveStatement() {
		return getMybatisMapperNamesapce() + ".updateByExampleSelective";
	}

	public String getDeleteStatement() {
		return getMybatisMapperNamesapce() + ".deleteByPrimaryKey";
	}

	public String getSelectByExampleStatement() {
		return getMybatisMapperNamesapce() + ".selectByExample";
	}

	public String getCountQueryStatement() {
		return getMybatisMapperNamesapce() + ".countByExample";
	}
	public String getWarningQueuesByUserId() {
		return getMybatisMapperNamesapce() + ".getWarningQueuesByUserId";
	}

	public String getDeleteByExampleStatement() {
		return getMybatisMapperNamesapce() + ".deleteByExample";
	}

	public boolean isUnique(E entity, String uniquePropertyNames) {
		throw new UnsupportedOperationException();
	}

	public void flush() {
		// ignore
	}
}