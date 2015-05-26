package com.aisino.finace.account.service;

import com.aisino.finace.account.entity.MlSysParam;
import com.aisino.finace.account.entity.Page;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface ParamServiceI {
	public PageList<MlSysParam> getParamList(Page page, MlSysParam param);
	
	public MlSysParam queryParamById(MlSysParam param);
	
	public int updateParam(MlSysParam param);
}
