package com.aisino.finace.account.dao;

import com.aisino.finace.account.entity.MlSysResc;
import com.aisino.finace.account.entity.MlSysRescExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public abstract interface MlSysRescMapper
{
  public abstract int countByExample(MlSysRescExample paramMlSysRescExample);

  public abstract int deleteByExample(MlSysRescExample paramMlSysRescExample);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(MlSysResc paramMlSysResc);

  public abstract int insertSelective(MlSysResc paramMlSysResc);

  public abstract List<MlSysResc> selectByExample(MlSysRescExample paramMlSysRescExample);

  public abstract MlSysResc selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(@Param("record") MlSysResc paramMlSysResc, @Param("example") MlSysRescExample paramMlSysRescExample);

  public abstract int updateByExample(@Param("record") MlSysResc paramMlSysResc, @Param("example") MlSysRescExample paramMlSysRescExample);

  public abstract int updateByPrimaryKeySelective(MlSysResc paramMlSysResc);

  public abstract int updateByPrimaryKey(MlSysResc paramMlSysResc);
}