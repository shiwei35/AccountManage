package com.aisino.finace.account.service;



import com.aisino.finace.account.entity.Page;

import com.aisino.finace.account.entity.TvTradetail;
import com.github.miemiedev.mybatis.paginator.domain.PageList;


public interface TradetailServiceI {
	//public PageList<TcIssuserchkacct> getParamList(Page page, TcIssuserchkacct tcIssuserchkacct);
	


	public PageList<TvTradetail> getTradetaiList(Page page, String sMeracct,
			String sTermcode, String dTransdate);
	
}
