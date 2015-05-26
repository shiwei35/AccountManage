package com.aisino.finace.account.service;

import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.TmMerservacctdetail; 
import com.aisino.finace.account.entity.TmMsinfo;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public abstract interface MsinfoServiceI {
	public abstract PageList<TmMsinfo> getTmMsinfoPageList(Page paramPage,
			TmMsinfo msinfo);

	public abstract TmMsinfo getTmMsinfoByPriKey(TmMsinfo paramTmMsinfo);

	public abstract int createTmMsinfo(TmMsinfo paramTmMsinfo);

	public abstract int updateTmMsinfo(TmMsinfo paramTmMsinfo);

	public abstract int deleteTmMsinfoByKeys(String paramString); 
}