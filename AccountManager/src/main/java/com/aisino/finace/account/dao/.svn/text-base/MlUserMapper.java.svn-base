package com.aisino.finace.account.dao;

import com.aisino.finace.account.entity.MlUser;
import com.aisino.finace.account.entity.MlUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public abstract interface MlUserMapper
{
  public abstract int countByExample(MlUserExample paramMlUserExample);

  public abstract int deleteByExample(MlUserExample paramMlUserExample);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(MlUser paramMlUser);

  public abstract int insertSelective(MlUser paramMlUser);

  public abstract List<MlUser> selectByExample(MlUserExample paramMlUserExample);

  public abstract MlUser selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(@Param("record") MlUser paramMlUser, @Param("example") MlUserExample paramMlUserExample);

  public abstract int updateByExample(@Param("record") MlUser paramMlUser, @Param("example") MlUserExample paramMlUserExample);

  public abstract int updateByPrimaryKeySelective(MlUser paramMlUser);

  public abstract int updateByPrimaryKey(MlUser paramMlUser);
}