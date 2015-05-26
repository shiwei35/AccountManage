package com.aisino.finace.account.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.finace.account.dao.MsinfoDao;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.TmMerinfoExample;
import com.aisino.finace.account.entity.TmMsinfo;
import com.aisino.finace.account.entity.TmMsinfoExample;
import com.aisino.finace.account.service.MsinfoServiceI;
import com.aisino.finace.account.utils.SysUtil;
import com.aisino.finace.account.utils.key.KeyGenerator;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service("msinfoService")
public class MsinfoServiceImpl implements MsinfoServiceI  {
	private MsinfoDao msinfoDao = null;
 
	private final String _ORDER_ATTRS = "sOrguuid,iMercode,sMsname,sMsstatus,sCitycode,sCityname,sMsaddr,sMszip,sMsmanagername,sMsmanagerphone,sEmail,sRemark";
	private final String _ORDER_FIELDS =  "S_ORGUUID,I_MERCODE,S_MSNAME,S_MSSTATUS,S_CITYCODE,S_CITYNAME,S_MSADDR,S_MSZIP,S_MSMANAGERNAME,S_MSMANAGERPHONE,S_EMAIL,S_REMARK";



	public MsinfoDao getMsinfoDao() {
		return msinfoDao;
	}

	@Autowired
	public void setMsinfoDao(MsinfoDao msinfoDao) {
		this.msinfoDao = msinfoDao;
	}

	@Override
	public PageList<TmMsinfo> getTmMsinfoPageList(Page paramPage,
			TmMsinfo msinfo) {
		
		
		
		TmMsinfoExample example = new TmMsinfoExample();	
		TmMsinfoExample.Criteria criteria = example.createCriteria();
		//门店编号
		if (msinfo.getsMsuuid() != null && !"".equals(msinfo.getsMsuuid())) {
			criteria.andSMsuuidEqualTo(msinfo.getsMsuuid());
		}
		//门店名称
		if (msinfo.getsMsname() != null && !"".equals(msinfo.getsMsname())) {
			criteria.andSMsnameLike("%"+ msinfo.getsMsname()+"%"); 
		}
		
			criteria.andSIseffectEqualTo("1");
		
		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!"".equals(order)) {
			example.setOrderByClause(order);
		}
		return this.msinfoDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public TmMsinfo getTmMsinfoByPriKey(TmMsinfo paramTmMsinfo){
		return (TmMsinfo) this.msinfoDao.getById( Long.parseLong(paramTmMsinfo.getsMsuuid()));
	}

	@Override
	public int createTmMsinfo(TmMsinfo paramTmMsinfo) {
		paramTmMsinfo.setsMsuuid(KeyGenerator.getNextKey("tm_MSInfo", "S_MSUUID").toString()); 
		return this.msinfoDao.save(paramTmMsinfo);
	}

	@Override
	public int updateTmMsinfo(TmMsinfo paramTmMsinfo) {
		return this.msinfoDao.updateSelective(paramTmMsinfo);
	}

	@Override
	public int deleteTmMsinfoByKeys(String paramString){
		TmMsinfoExample example = new TmMsinfoExample();
		String[] idArray = paramString.split(",");
		List idList = new ArrayList();

		for (int i = 0; i < idArray.length; i++) {
			idList.add(idArray[i]);
		}
		example.createCriteria().andSMsuuidIn(idList);
		int result = this.msinfoDao.deleteByExample(example);

		return result;
	}

}