package com.aisino.finace.account.service;

import java.util.Date;

import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.TcIssuserchkacct;
import com.github.miemiedev.mybatis.paginator.domain.PageList;


public interface AnalyseServiceI {
	//public PageList<TcIssuserchkacct> getParamList(Page page, TcIssuserchkacct tcIssuserchkacct);
	
	public PageList<TcIssuserchkacct> getAnalyseList(Page page,String sIssuerusercode, String dChkacctdate);
	
}
