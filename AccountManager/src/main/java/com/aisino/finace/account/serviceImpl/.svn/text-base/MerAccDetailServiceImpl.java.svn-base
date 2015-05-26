package com.aisino.finace.account.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.finace.account.dao.TmMerservacctdetailDao;
import com.aisino.finace.account.entity.MlUser;
import com.aisino.finace.account.entity.TmMerservacctdetailExample;
import com.aisino.finace.account.entity.TmMerservacctdetailExample;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.TmMerservacctdetail;
import com.aisino.finace.account.service.MerAccDetailServiceI;
import com.aisino.finace.account.utils.SysUtil;
import com.aisino.finace.account.utils.key.KeyGenerator;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service("merAccDetailService")
public class MerAccDetailServiceImpl implements MerAccDetailServiceI  {
	private TmMerservacctdetailDao tmMeracctdetailDao = null;
 
	private final String _ORDER_ATTRS = "sAcctcode,iCardno,sCardtype,sCardstatus,iAcctid,fRmbbalance,fPointbalance";
	private final String _ORDER_FIELDS =  "S_ACCTCODE,I_CARDNO,S_CARDTYPE,S_CARDSTATUS,I_ACCTID,F_RMBBALANCE,F_POINTBALANCE";

	public TmMerservacctdetailDao getTmMerservacctdetailDao() {
		return this.tmMeracctdetailDao;
	}

	@Autowired
	public void setTmMerservacctdetailDao(TmMerservacctdetailDao tmMeracctdetailDao) {
		this.tmMeracctdetailDao = tmMeracctdetailDao;
	} 

	@Override
	public PageList<TmMerservacctdetail> getMerAccDetailPageList(Page page,
			TmMerservacctdetail param) {
		
		TmMerservacctdetailExample example = new TmMerservacctdetailExample();
		TmMerservacctdetailExample.Criteria criteria = example.createCriteria();
		//卡号
		if (param.getiCardno() != null && !"".equals(param.getiCardno())) {
			criteria.andICardnoEqualTo(param.getiCardno());
		}
		//卡类型
		if (param.getsCardtype() != null && !"".equals(param.getsCardtype())) {
			criteria.andSCardtypeEqualTo( param.getsCardtype()); 
		}
		//卡状态
		if (param.getsCardstatus() != null && !"".equals(param.getsCardstatus())) {
			criteria.andSCardstatusEqualTo( param.getsCardstatus()); 
		}
		
		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!"".equals(order)) {
			example.setOrderByClause(order);
		}
		return this.tmMeracctdetailDao.findPage(SysUtil.convertPage(page), example);
	}

	@Override
	public TmMerservacctdetail getMerAccDetailByPriKey(
			TmMerservacctdetail paramTmMerservacctdetail) {
		return (TmMerservacctdetail) this.tmMeracctdetailDao.getById(paramTmMerservacctdetail.getiCardid());
	}

	@Override
	public int createMerAccDetail(TmMerservacctdetail tmMerservacctdetail) {
		tmMerservacctdetail.setiCardid(new BigDecimal(KeyGenerator.getNextKey("tm_MerServAcctDetail", "I_CARDID"))); 
		return this.tmMeracctdetailDao.save(tmMerservacctdetail);
	}

	@Override
	public int updateMerAccDetail(TmMerservacctdetail paramTmMerservacctdetail) {
		return this.tmMeracctdetailDao.updateSelective(paramTmMerservacctdetail);
	}

	@Override
	public int deleteMerAccDetailByKeys(String ids) {
		TmMerservacctdetailExample example = new TmMerservacctdetailExample();
		String[] idArray = ids.split(",");
		List idList = new ArrayList();

		for (int i = 0; i < idArray.length; i++) {
			idList.add(idArray[i]);
		}
		example.createCriteria().andICardidIn(idList);
		int result = this.tmMeracctdetailDao.deleteByExample(example);

		return result;
	}

}