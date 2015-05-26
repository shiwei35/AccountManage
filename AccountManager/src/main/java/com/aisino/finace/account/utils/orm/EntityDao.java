package com.aisino.finace.account.utils.orm;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface EntityDao<E, PK extends Serializable>
{
  public abstract Object getById(PK paramPK);

  public abstract int deleteById(PK paramPK);

  public abstract int deleteByExample(Object paramObject);

  public abstract int save(E paramE);

  public abstract int saveSelective(E paramE);

  public abstract int update(E paramE);

  public abstract int updateSelective(E paramE);
  
  public abstract int updateByExampleSelective(Map param);

  public abstract int saveOrUpdate(E paramE);

  public abstract List<E> getAll();

  public abstract List<E> findAll(Object paramObject);

  public abstract List<E> findAll(String paramString, Object paramObject);

  public abstract PageList<E> findPage(PageBounds paramPageBounds, Object paramObject);

  public abstract PageList<E> findPage(String paramString, PageBounds paramPageBounds, Object paramObject);

  public abstract PageList<E> findPage(String paramString1, String paramString2, PageBounds paramPageBounds, Object paramObject);

  public abstract E findOne(Object paramObject);
}