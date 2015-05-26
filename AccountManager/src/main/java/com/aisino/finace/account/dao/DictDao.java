 package com.aisino.finace.account.dao;
 
 import com.aisino.finace.account.entity.MlDict;
import com.aisino.finace.account.utils.orm.mybatis.BaseMybatisDao;

import org.springframework.stereotype.Repository;
 
 @Repository
 public class DictDao extends BaseMybatisDao<MlDict, Long>
 {
   public String getNamespace()
   {
     return MlDictMapper.class.getCanonicalName();
   }
 }