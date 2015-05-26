package com.aisino.finace.account.dao;

import com.aisino.finace.account.entity.MlDict;
import com.aisino.finace.account.entity.MlDictExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public abstract interface MlDictMapper
{
  public abstract int countByExample(MlDictExample paramMlDictExample);

  public abstract int deleteByExample(MlDictExample paramMlDictExample);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(MlDict paramMlDict);

  public abstract int insertSelective(MlDict paramMlDict);

  public abstract List<MlDict> selectByExample(MlDictExample paramMlDictExample);

  public abstract MlDict selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(@Param("record") MlDict paramMlDict, @Param("example") MlDictExample paramMlDictExample);

  public abstract int updateByExample(@Param("record") MlDict paramMlDict, @Param("example") MlDictExample paramMlDictExample);

  public abstract int updateByPrimaryKeySelective(MlDict paramMlDict);

  public abstract int updateByPrimaryKey(MlDict paramMlDict);
}