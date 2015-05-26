package com.aisino.finace.account.dao;

import com.aisino.finace.account.entity.MlSysAuthority;
import com.aisino.finace.account.entity.MlSysAuthorityExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public abstract interface MlSysAuthorityMapper
{
  public abstract int countByExample(MlSysAuthorityExample paramMlSysAuthorityExample);

  public abstract int deleteByExample(MlSysAuthorityExample paramMlSysAuthorityExample);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(MlSysAuthority paramMlSysAuthority);

  public abstract int insertSelective(MlSysAuthority paramMlSysAuthority);

  public abstract List<MlSysAuthority> selectByExample(MlSysAuthorityExample paramMlSysAuthorityExample);

  public abstract MlSysAuthority selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(@Param("record") MlSysAuthority paramMlSysAuthority, @Param("example") MlSysAuthorityExample paramMlSysAuthorityExample);

  public abstract int updateByExample(@Param("record") MlSysAuthority paramMlSysAuthority, @Param("example") MlSysAuthorityExample paramMlSysAuthorityExample);

  public abstract int updateByPrimaryKeySelective(MlSysAuthority paramMlSysAuthority);

  public abstract int updateByPrimaryKey(MlSysAuthority paramMlSysAuthority);
}