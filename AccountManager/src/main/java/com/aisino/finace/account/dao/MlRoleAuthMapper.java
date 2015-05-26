package com.aisino.finace.account.dao;

import com.aisino.finace.account.entity.MlRoleAuth;
import com.aisino.finace.account.entity.MlRoleAuthExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public abstract interface MlRoleAuthMapper
{
  public abstract int countByExample(MlRoleAuthExample paramMlRoleAuthExample);

  public abstract int deleteByExample(MlRoleAuthExample paramMlRoleAuthExample);

  public abstract int insert(MlRoleAuth paramMlRoleAuth);

  public abstract int insertSelective(MlRoleAuth paramMlRoleAuth);

  public abstract List<MlRoleAuth> selectByExample(MlRoleAuthExample paramMlRoleAuthExample);

  public abstract int updateByExampleSelective(@Param("record") MlRoleAuth paramMlRoleAuth, @Param("example") MlRoleAuthExample paramMlRoleAuthExample);

  public abstract int updateByExample(@Param("record") MlRoleAuth paramMlRoleAuth, @Param("example") MlRoleAuthExample paramMlRoleAuthExample);
}