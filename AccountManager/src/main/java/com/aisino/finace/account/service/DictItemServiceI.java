package com.aisino.finace.account.service;

import com.aisino.finace.account.entity.MlDictItem;
import com.aisino.finace.account.entity.Page;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public abstract interface DictItemServiceI
{
  public abstract PageList<MlDictItem> getDictItemList(Page paramPage, MlDictItem paramMlDictItem);

  public abstract int creatDictItem(MlDictItem paramMlDictItem);

  public abstract int deleteItem(String paramString);

  public abstract int updateItem(MlDictItem paramMlDictItem);

  public abstract MlDictItem getDictItemById(MlDictItem paramMlDictItem);
}