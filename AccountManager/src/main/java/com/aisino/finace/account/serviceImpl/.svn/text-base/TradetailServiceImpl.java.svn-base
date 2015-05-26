package com.aisino.finace.account.serviceImpl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.finace.account.dao.TradetailDao;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.TvTradetail;
import com.aisino.finace.account.entity.TvTradetailExample;
import com.aisino.finace.account.service.TradetailServiceI;
import com.aisino.finace.account.utils.SysUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageList;


@Service("tradetailService")
public class TradetailServiceImpl implements TradetailServiceI {
	private TradetailDao tradetailDao = null;
	private final String _ORDER_ATTRS = "sTrasrlno,sConntype,sMeracct,sTermcode,sTranstype,sCardiotype,dTransdate,dBalancedate,fTransamt,sMcc,sHandlchargdcttype,fFeeratio,fFeeratioamt,fHandlchargratioulmt,fHandlchargratiollmt,fHandlcharg,fActualamt,sBcdno,sBcdtype,sIssuerusercode,sOpenorg";
	private final String _ORDER_FIELDS = "S_TRASRLNO,S_CONNTYPE,S_MERACCT,S_TERMCODE,S_TRANSTYPE,S_CARDIOTYPE,D_TRANSDATE,D_BALANCEDATE,F_TRANSAMT,S_MCC,S_HANDLCHARGDCTTYPE,F_FEERATIO,F_FEERATIOAMT,F_HANDLCHARGRATIOULMT,F_HANDLCHARGRATIOLLMT,F_HANDLCHARG,F_ACTUALAMT,S_BCDNO,S_BCDTYPE,S_ISSUERUSERCODE,S_OPENORG";



	public TradetailDao getTradetailDao() {
		return tradetailDao;
	}


	@Autowired
	public void setTradetailDao(TradetailDao tradetailDao) {
		this.tradetailDao = tradetailDao;
	}



	@Override
	public PageList<TvTradetail> getTradetaiList(Page page, String sMeracct,
			String sTermcode, String dTransdate) {
		//TcIssuserchkacctExample example = new TcIssuserchkacctExample();
		//TcIssuserchkacctExample.Criteria criteria = example.createCriteria();
		//return this.analyseDao.findPage(SysUtil.convertPage(page), sIssuerusercode);
		TvTradetailExample example = new TvTradetailExample();
	
		TvTradetailExample.Criteria criteria = example.createCriteria();

		if ((sMeracct != null) && (!"".equals(sMeracct))) {
			criteria.andSMeracctLike("%" + sMeracct + "%");
		}
		if ((sTermcode != null) && (!"".equals(sTermcode))) {
			criteria.andSTermcodeLike("%" + sTermcode + "%");
		}

		if ((dTransdate != null) && (!"".equals(dTransdate))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			try {
				date = sdf.parse(dTransdate);
				criteria.andDTransdateEqualTo(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!"".equals(order)) {
			example.setOrderByClause(order);
		}

		return this.tradetailDao.findPage(SysUtil.convertPage(page), example);
	}

}
