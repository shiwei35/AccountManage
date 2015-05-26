package com.aisino.finace.account.dao;

import com.aisino.finace.account.entity.MlRoleResc;
import com.aisino.finace.account.entity.MlRoleRescExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public abstract interface MlRoleRescMapper
{
  public abstract int countByExample(MlRoleRescExample paramMlRoleRescExample);

  public abstract int deleteByExample(MlRoleRescExample paramMlRoleRescExample);

  public abstract int insert(MlRoleResc paramMlRoleResc);

  public abstract int insertSelective(MlRoleResc paramMlRoleResc);

  public abstract List<MlRoleResc> selectByExample(MlRoleRescExample paramMlRoleRescExample);

  public abstract int updateByExampleSelective(@Param("record") MlRoleResc paramMlRoleResc, @Param("example") MlRoleRescExample paramMlRoleRescExample);

  public abstract int updateByExample(@Param("record") MlRoleResc paramMlRoleResc, @Param("example") MlRoleRescExample paramMlRoleRescExample);
}