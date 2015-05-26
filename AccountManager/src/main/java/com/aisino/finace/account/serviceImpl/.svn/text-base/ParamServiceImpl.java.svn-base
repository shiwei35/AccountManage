package com.aisino.finace.account.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.finace.account.dao.ParamDao;
import com.aisino.finace.account.entity.MlSysParam;
import com.aisino.finace.account.entity.MlSysParamExample;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.service.ParamServiceI;
import com.aisino.finace.account.utils.SysUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service("paramService")
public class ParamServiceImpl implements ParamServiceI {
	private ParamDao paramDao = null;
	private final String _ORDER_ATTRS = "paramTitle,paramCode,paramVal,module,operId,opTime";
	private final String _ORDER_FIELDS = "PARAM_TITLE,PARAM_CODE,PARAM_VAL,MODULE,OPER_ID,OP_TIME";

	public ParamDao getParamDao() {
		return paramDao;
	}

	@Autowired
	public void setParamDao(ParamDao paramDao) {
		this.paramDao = paramDao;
	}

	@Override
	public PageList<MlSysParam> getParamList(Page page, MlSysParam param) {
		MlSysParamExample example = new MlSysParamExample();
		MlSysParamExample.Criteria criteria = example.createCriteria();
		if (param.getParamCode() != null && !"".equals(param.getParamCode())) {
			criteria.andParamCodeLike("%" + param.getParamCode() + "%");
		}
		if (param.getParamTitle() != null && !"".equals(param.getParamTitle())) {
			criteria.andParamTitleLike("%" + param.getParamTitle() + "%");
		}
		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!"".equals(order)) {
			example.setOrderByClause(order);
		}

		return this.paramDao.findPage(SysUtil.convertPage(page), example);
	}

	@Override
	public MlSysParam queryParamById(MlSysParam param) {
		return this.paramDao.getById(param.getParamId());
	}

	@Override
	public int updateParam(MlSysParam param) {
		return this.paramDao.updateSelective(param);
	}

}
