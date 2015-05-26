package com.aisino.finace.account.dao;

import java.util.List;

import com.aisino.finace.account.entity.MlSysResc;
import com.aisino.finace.account.utils.orm.mybatis.BaseMybatisDao;

import org.springframework.stereotype.Repository;

@Repository
public class RescDao extends BaseMybatisDao<MlSysResc, Long> {
	public String getNamespace() {
		return MlSysRescMapper.class.getCanonicalName();
	}

	/**
	 * 查询角色对应的菜单
	 * 
	 * @param roleId
	 * @return
	 */
	public List<MlSysResc> selectRealRescByRoleId(Long roleId) {
		return getSqlSession().selectList(
				getMybatisMapperNamesapce() + ".selectRealRescByRoleId", roleId);
	}
	
	/**
	 * 查询角色权限设置时保存的Resc信息，因Jquery easyui Tree控件的原因，模块信息保存并不完全，权限表中涉及模块信息最完全。
	 * 角色权限编码采用：模块命名空间+":"+权限码的方式 
	 * @param roleId
	 * @return
	 */
	public List<MlSysResc> getSavedRescByRoleId(Long roleId) {
		return getSqlSession().selectList(
				getMybatisMapperNamesapce() + ".getSavedRescByRoleId", roleId);
	}
}