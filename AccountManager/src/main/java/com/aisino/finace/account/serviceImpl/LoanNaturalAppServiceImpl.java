package com.aisino.finace.account.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.finace.account.dao.NaturalAppDao;
import com.aisino.finace.account.entity.MlNaturalApp;
import com.aisino.finace.account.entity.MlNaturalAppExample;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.service.LoanNaturalAppServiceI;
import com.aisino.finace.account.utils.SysUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
public class LoanNaturalAppServiceImpl implements LoanNaturalAppServiceI {
	private NaturalAppDao naturalAppDao = null;
	private final String _ORDER_ATTRS = "appNo,name,idType,idNo,idSignDate,idExpireDate,gender,birthday,age,nation,educationLvl,politicsStatus,mobile,homePhone,email,industryType,company,position,workYears,currJobStDate,compAddr,compZip,homeAddr,homeZip,residentStatus,liveStartTime,carBrand,carNo,carStatus,carBuyDate,spouseName,spouseIdType,spouseIdNo,spouseIdSignDate,spouseIdExpireDate,spouseIndustryType,spouseCompany,spousePosition,spouseCompAddr,spouseCompZip,spouseMobile,spouseHomePhone,spouseEmail,linkmanName,linkmanIdType,linkmanIdNo,linkmanSignDate,linkmanExpireDate,linkmanIndustryType,linkmanCompany,linkmanPosition,linkmanCompAddr,linkmanCompZip,linkmanMobile,linkmanHomePhone,linkmanEmail,handler,dealStartTime,previousStep,currStep,nextStep";
	private final String _ORDER_FIELDS = "APP_NO,NAME,ID_TYPE,ID_NO,ID_SIGN_DATE,ID_EXPIRE_DATE,GENDER,BIRTHDAY,AGE,NATION,EDUCATION_LVL,POLITICS_STATUS,MOBILE,HOME_PHONE,EMAIL,INDUSTRY_TYPE,COMPANY,POSITION,WORK_YEARS,CURR_JOB_ST_DATE,COMP_ADDR,COMP_ZIP,HOME_ADDR,HOME_ZIP,RESIDENT_STATUS,LIVE_START_TIME,CAR_BRAND,CAR_NO,CAR_STATUS,CAR_BUY_DATE,SPOUSE_NAME,SPOUSE_ID_TYPE,SPOUSE_ID_NO,SPOUSE_ID_SIGN_DATE,SPOUSE_ID_EXPIRE_DATE,SPOUSE_INDUSTRY_TYPE,SPOUSE_COMPANY,SPOUSE_POSITION,SPOUSE_COMP_ADDR,SPOUSE_COMP_ZIP,SPOUSE_MOBILE,SPOUSE_HOME_PHONE,SPOUSE_EMAIL,LINKMAN_NAME,LINKMAN_ID_TYPE,LINKMAN_ID_NO,LINKMAN_SIGN_DATE,LINKMAN_EXPIRE_DATE,LINKMAN_INDUSTRY_TYPE,LINKMAN_COMPANY,LINKMAN_POSITION,LINKMAN_COMP_ADDR,LINKMAN_COMP_ZIP,LINKMAN_MOBILE,LINKMAN_HOME_PHONE,LINKMAN_EMAIL,HANDLER,DEAL_START_TIME,PREVIOUS_STEP,CURR_STEP,NEXT_STEP";

	public NaturalAppDao getNaturalAppDao() {
		return naturalAppDao;
	}

	@Autowired
	public void setNaturalAppDao(NaturalAppDao naturalAppDao) {
		this.naturalAppDao = naturalAppDao;
	}

	@Override
	public PageList<MlNaturalApp> getLoanNaturalAppPageList(Page page,
			MlNaturalApp naturalApp) {
		MlNaturalAppExample example = new MlNaturalAppExample();
		String name = naturalApp.getName();
		String idNo = naturalApp.getIdNo();
		MlNaturalAppExample.Criteria criteria = example.createCriteria();
		if (name != null && !"".equals(name)) {
			criteria.andNameLike("%" + name + "%");
		}
		if (idNo != null && !"".equals(idNo)) {
			criteria.andIdNoLike("%" + idNo + "%");
		}

		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.naturalAppDao.findPage(SysUtil.convertPage(page), example);
	}

}
