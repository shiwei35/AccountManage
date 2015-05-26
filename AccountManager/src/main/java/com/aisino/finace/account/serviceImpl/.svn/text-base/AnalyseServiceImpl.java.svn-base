package com.aisino.finace.account.serviceImpl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.finace.account.dao.AnalyseDao;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.TcIssuserchkacct;
import com.aisino.finace.account.entity.TcIssuserchkacctExample;
import com.aisino.finace.account.service.AnalyseServiceI;
import com.aisino.finace.account.utils.SysUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageList;


@Service("analyseService")
public class AnalyseServiceImpl implements AnalyseServiceI {
	private AnalyseDao analyseDao = null;
	private final String _ORDER_ATTRS = "dChkacctdate,sIssuerusercode,iOpencountnum,fOpenamt,iGcardcountnum,fGcardsumamt,iCashcountnum,fCashsumamt,iBcdpaycountnum,fBcdpaysumamt,iConsumecountnum,fConsumesumamt,iRefundcountnum,fRefundsumamt";
	private final String _ORDER_FIELDS = "D_CHKACCTDATE,S_ISSUERUSERCODE,I_OPENCOUNTNUM,F_OPENAMT,I_GCARDCOUNTNUM,F_GCARDSUMAMT,I_CASHCOUNTNUM,F_CASHSUMAMT,I_BCDPAYCOUNTNUM,F_BCDPAYSUMAMT,I_CONSUMECOUNTNUM,F_CONSUMESUMAMT,I_REFUNDCOUNTNUM,F_REFUNDSUMAMT";

	@Autowired
	public void setAnalyseDao(AnalyseDao analyseDao) {
		this.analyseDao = analyseDao;
	}

	public AnalyseDao getAnalyseDao() {
		return analyseDao;
	}

	@Override
	public PageList<TcIssuserchkacct> getAnalyseList(Page page, String sIssuerusercode,String dChkacctdate) {
		//TcIssuserchkacctExample example = new TcIssuserchkacctExample();
		//TcIssuserchkacctExample.Criteria criteria = example.createCriteria();
		//return this.analyseDao.findPage(SysUtil.convertPage(page), sIssuerusercode);
		TcIssuserchkacctExample example = new TcIssuserchkacctExample();
	
		TcIssuserchkacctExample.Criteria criteria = example.createCriteria();

		if ((sIssuerusercode != null) && (!"".equals(sIssuerusercode))) {
			criteria.andSIssuerusercodeLike("%" + sIssuerusercode + "%");
		}

		if ((dChkacctdate != null) && (!"".equals(dChkacctdate))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			try {
				date = sdf.parse(dChkacctdate);
				criteria.andDChkacctdateEqualTo(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!"".equals(order)) {
			example.setOrderByClause(order);
		}

		return this.analyseDao.findPage(SysUtil.convertPage(page), example);
	}

}
