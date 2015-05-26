package com.aisino.finace.account.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aisino.finace.account.dao.MerchantDao;
import com.aisino.finace.account.entity.MlUserExample;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.TmMerinfo;
import com.aisino.finace.account.entity.TmMerinfoExample;
import com.aisino.finace.account.service.MerchantServiceI;
import com.aisino.finace.account.utils.SysUtil;
import com.aisino.finace.account.utils.key.KeyGenerator;
import com.github.miemiedev.mybatis.paginator.domain.PageList;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("merchantService")
public class MerchantServiceImpl implements MerchantServiceI {
	private MerchantDao merchantDao = null;

	private final String _ORDER_ATTRS = "sOrguuid,sMername,sMerstatus,dMerexpdate,sCitycode,sCityname,sMercontname,sMercontphone,sMeraddr,sMerzip,sEmail,sRemark";
	private final String _ORDER_FIELDS = "S_ORGUUID,S_MERNAME,S_MERSTATUS,D_MEREXPDATE,S_CITYCODE,S_CITYNAME,S_MERCONTNAME,S_MERCONTPHONE,S_MERADDR,S_MERZIP,S_EMAIL,S_REMARK";

	

	public MerchantDao getMerchantDao() {
		return merchantDao;
	}

	@Autowired
	public void setMerchantDao(MerchantDao merchantDao) {
		this.merchantDao = merchantDao;
	}

	public PageList<TmMerinfo> getMerPageList(Page page, TmMerinfo merObj) {
		TmMerinfoExample example = new TmMerinfoExample();
		Long iMercode = merObj.getiMercode();
		String sMername = merObj.getsMername();
		String iseffect = merObj.getsIseffect();
		TmMerinfoExample.Criteria criteria = example.createCriteria();

		if ((iMercode != null) && (!"".equals(iMercode))) {
			criteria.andIMercodeEqualTo(iMercode);
		}

		if ((sMername != null) && (!"".equals(sMername))) {
			criteria.andSMernameLike("%" + sMername + "%");
		}
		
		
			criteria.andSIseffectEqualTo("1");
		
		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!"".equals(order)) {
			example.setOrderByClause(order);
		}

		return this.merchantDao.findPage(SysUtil.convertPage(page), example);
	}
	
	public int createMer(TmMerinfo merObj) {
		merObj.setiMercode(KeyGenerator.getNextKey("TM_MERINFO", "I_MERCODE"));
		return this.merchantDao.save(merObj);
	}
	
	public int updateMer(TmMerinfo merObj) {
		
		
		
		return this.merchantDao.updateSelective(merObj);
	}

	
	
	public TmMerinfo getMerByPriKey(TmMerinfo merObj) {
		return (TmMerinfo) this.merchantDao.getById(merObj.getiMercode());
	}

		
		public int deleteMerByKeys(String ids) {
			TmMerinfoExample example = new TmMerinfoExample();
			String[] idArray = ids.split(",");
			List idList = new ArrayList();

			for (int i = 0; i < idArray.length; i++) {
				idList.add(idArray[i]);
			}
			
			TmMerinfo merObj =  new TmMerinfo();
			merObj.setiMercode(Long.valueOf(idList.get(0).toString()));
			
			merObj.setsIseffect("0");
			merObj.setTsSysupdate(new Date());
			
			

			return this.merchantDao.updateSelective(merObj);
			
		}
		
		

/**
 


	public int updateUser(MlUser user) {
		return this.userDao.updateSelective(user);
	}



	public int deleteUserRoleByKeys(String ids) {
		String[] idArray = ids.split(",");
		List idList = new ArrayList();
		MlUserRoleExample example = new MlUserRoleExample();

		for (int i = 0; i < idArray.length; i++) {
			idList.add(idArray[i]);
		}
		example.createCriteria().andUserIdIn(idList);
		int result = this.userRoleDao.deleteByExample(example);

		return result;
	}

	public boolean isRoleBindWithUser(long roleId) {
		MlUserRoleExample example = new MlUserRoleExample();
		example.createCriteria().andRoleIdEqualTo(Long.valueOf(roleId));
		List userRoleList = this.userRoleDao.findAll(example);

		return (userRoleList != null) && (userRoleList.size() > 0);
	}

	@Override
	public void initializePassword(String ids) {
		MlUserExample example = new MlUserExample();
		String[] idArray = ids.split(",");
		List idList = new ArrayList();

		for (int i = 0; i < idArray.length; ++i) {
			idList.add(idArray[i]);
		}
		example.createCriteria().andUserIdIn(idList);
		MlUser user = new MlUser();
		user.setPassword(SysUtil.encryptByMd5("888888"));
		Map param = new HashMap();
		param.put("example", example);
		param.put("record", user);
		this.userDao.updateByExampleSelective(param);
	}

	@Override
	public void addUserRoles(String ids, long userId) {
		String[] idArray = ids.split(",");

		if (idArray.length > 0) {
			for (int i = 0; i < idArray.length; i++) {
				MlUserRole userRole = new MlUserRole();
				userRole.setRoleId(Long.parseLong(idArray[i]));
				userRole.setUserId(userId);
				this.userRoleDao.save(userRole);
			}
		}
	}

	@Override
	public int deleteUserRole(String ids, long userId) {
		String[] idArray = ids.split(",");
		List idList = new ArrayList();
		for (int i = 0; i < idArray.length; ++i) {
			idList.add(idArray[i]);
		}
		MlUserRoleExample example = new MlUserRoleExample();
		example.createCriteria().andUserIdEqualTo(userId).andRoleIdIn(idList);

		int result = this.userRoleDao.deleteByExample(example);
	
		return result;
	}
 */
}