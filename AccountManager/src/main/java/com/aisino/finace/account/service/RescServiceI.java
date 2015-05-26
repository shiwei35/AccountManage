package com.aisino.finace.account.service;

import com.aisino.finace.account.entity.MlSysResc;
import com.aisino.finace.account.entity.Page;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;

public abstract interface RescServiceI
{
  public abstract PageList<MlSysResc> getRescPageList(Page paramPage,MlSysResc resc);

  public abstract List<MlSysResc> getParentRescList();

  public abstract int createResc(MlSysResc paramMlSysResc);

  public abstract int updateResc(MlSysResc paramMlSysResc);

  public abstract MlSysResc getRescById(MlSysResc paramMlSysResc);

  public abstract int deleteRescByKeys(String paramString);
  
}