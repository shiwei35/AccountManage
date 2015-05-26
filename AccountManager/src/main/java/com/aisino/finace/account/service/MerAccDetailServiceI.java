package com.aisino.finace.account.service;

import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.TmMerservacctdetail; 
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public abstract interface MerAccDetailServiceI {
	public abstract PageList<TmMerservacctdetail> getMerAccDetailPageList(Page paramPage,
			TmMerservacctdetail paramTmMerservacctdetail);

	public abstract TmMerservacctdetail getMerAccDetailByPriKey(TmMerservacctdetail paramTmMerservacctdetail);

	public abstract int createMerAccDetail(TmMerservacctdetail paramTmMerservacctdetail);

	public abstract int updateMerAccDetail(TmMerservacctdetail paramTmMerservacctdetail);

	public abstract int deleteMerAccDetailByKeys(String paramString); 
}