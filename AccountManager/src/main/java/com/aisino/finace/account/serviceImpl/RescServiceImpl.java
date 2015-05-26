package com.aisino.finace.account.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.finace.account.dao.RescDao;
import com.aisino.finace.account.entity.MlSysResc;
import com.aisino.finace.account.entity.MlSysRescExample;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.service.RescServiceI;
import com.aisino.finace.account.utils.SysUtil;
import com.aisino.finace.account.utils.key.KeyGenerator;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service("rescService")
public class RescServiceImpl implements RescServiceI {
	private RescDao rescDao = null;
	private final String _ORDER_ATTRS = "rescTitle,rescName,rescDesc,rescUrl,parentId,rescSeq,isLeaf,rescStatus";
	private final String _ORDER_FIELDS = "RESC_TITLE,RESC_NAME,RESC_DESC,RESC_URL,PARENT_ID,RESC_SEQ,IS_LEAF,RESC_STATUS";

	public RescDao getRescDao() {
		return this.rescDao;
	}

	@Autowired
	public void setRescDao(RescDao rescDao) {
		this.rescDao = rescDao;
	}

	public PageList<MlSysResc> getRescPageList(Page page,MlSysResc resc) {
		MlSysRescExample example = new MlSysRescExample();
		String rescName = resc.getRescName();
		String rescDesc = resc.getRescDesc();
		MlSysRescExample.Criteria criteria = example.createCriteria();
		if (rescName != null && !"".equals(rescName)) {
			criteria.andRescNameLike("%" + rescName + "%");
		}
		if (rescDesc != null && !"".equals(rescDesc)) {
			criteria.andRescDescLike("%" + rescDesc + "%");
		}
		
		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.rescDao.findPage(SysUtil.convertPage(page), example);
	}

	public int createResc(MlSysResc resc) {
		resc.setRescId(KeyGenerator.getNextKey("ML_SYS_RESC", "RESC_ID"));
		resc.setRescType("M");
		if ("Y".equals(resc.getIsLeaf())) {
			resc.setRescIcon("icon-ui-tree-leaf");
		} else {
			resc.setParentId(0l);
		}

		return this.rescDao.save(resc);
	}

	public int updateResc(MlSysResc resc) {
		resc.setRescType("M");
		if ("Y".equals(resc.getIsLeaf())) {
			resc.setRescIcon("icon-ui-tree-leaf");
		} else {
			resc.setParentId(0l);
		}

		return this.rescDao.updateSelective(resc);
	}

	public List<MlSysResc> getParentRescList() {
		MlSysRescExample example = new MlSysRescExample();
		example.createCriteria().andIsLeafEqualTo("N");
		example.setOrderByClause("RESC_SEQ ASC");
		return this.rescDao.findAll(example);
	}

	public MlSysResc getRescById(MlSysResc resc) {
		return (MlSysResc) this.rescDao.getById(resc.getRescId());
	}

	public int deleteRescByKeys(String ids) {
		String[] idArray = ids.split(",");
		List list = new ArrayList();
		for (int i = 0; i < idArray.length; i++) {
			list.add(idArray[i]);
		}
		MlSysRescExample example = new MlSysRescExample();
		example.createCriteria().andRescIdIn(list);
		return this.rescDao.deleteByExample(example);
	}
}