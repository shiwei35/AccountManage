package com.aisino.finace.account.service;

import com.aisino.finace.account.entity.DataDictionary;
import com.aisino.finace.account.entity.MlDict;
import com.aisino.finace.account.entity.Page;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public abstract interface DataDictServiceI
{
  public abstract PageList<MlDict> getDictList(Page paramPage, MlDict paramMlDict);

  public abstract int createDict(MlDict paramMlDict);

  public abstract int updateDict(MlDict paramMlDict);

  public abstract MlDict queryDictById(MlDict paramMlDict);

  public abstract int deleteDict(String paramString);

  public abstract DataDictionary getDictItemsByDictName(String paramString);
}