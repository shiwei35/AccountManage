package com.aisino.finace.account.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.finace.account.dao.AuthorityDao;
import com.aisino.finace.account.dao.RescDao;
import com.aisino.finace.account.dao.RoleAuthDao;
import com.aisino.finace.account.dao.RoleDao;
import com.aisino.finace.account.dao.RoleRescDao;
import com.aisino.finace.account.entity.MlRole;
import com.aisino.finace.account.entity.MlRoleAuth;
import com.aisino.finace.account.entity.MlRoleAuthExample;
import com.aisino.finace.account.entity.MlRoleExample;
import com.aisino.finace.account.entity.MlRoleResc;
import com.aisino.finace.account.entity.MlRoleRescExample;
import com.aisino.finace.account.entity.MlSysAuthority;
import com.aisino.finace.account.entity.MlSysResc;
import com.aisino.finace.account.entity.MlSysRescExample;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.RescAuthModel;
import com.aisino.finace.account.service.RoleServiceI;
import com.aisino.finace.account.utils.SysUtil;
import com.aisino.finace.account.utils.key.KeyGenerator;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service("roleService")
public class RoleServiceImpl implements RoleServiceI {
	private RoleDao roleDao = null;
	private RescDao rescDao = null;
	private RoleRescDao roleRescDao=null;
	private RoleAuthDao roleAuthDao=null;
	private AuthorityDao authorityDao = null;
	private final String _ORDER_ATTRS = "roleName,status";
	private final String _ORDER_FIELDS = "ROLE_NAME,STATUS";

	public RoleDao getRoleDao() {
		return this.roleDao;
	}

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public RescDao getRescDao() {
		return rescDao;
	}

	@Autowired
	public void setRescDao(RescDao rescDao) {
		this.rescDao = rescDao;
	}

	public AuthorityDao getAuthorityDao() {
		return authorityDao;
	}

	@Autowired
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	public RoleRescDao getRoleRescDao() {
		return roleRescDao;
	}

	@Autowired
	public void setRoleRescDao(RoleRescDao roleRescDao) {
		this.roleRescDao = roleRescDao;
	}

	public RoleAuthDao getRoleAuthDao() {
		return roleAuthDao;
	}

	@Autowired
	public void setRoleAuthDao(RoleAuthDao roleAuthDao) {
		this.roleAuthDao = roleAuthDao;
	}

	public PageList<MlRole> getRolePageList(Page page, MlRole role) {
		MlRoleExample example = new MlRoleExample();
		String roleName = role.getRoleName();
		String roleDesc = role.getRoleDesc();
		MlRoleExample.Criteria criteria = example.createCriteria();
		if ((roleName != null) && (!"".equals(roleName))) {
			criteria.andRoleNameLike("%" + roleName + "%");
		}
		if ((roleDesc != null) && (!"".equals(roleDesc))) {
			criteria.andRoleDescLike("%" + roleDesc + "%");
		}

		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!"".equals(order)) {
			example.setOrderByClause(order);
		}

		return this.roleDao.findPage(SysUtil.convertPage(page), example);
	}

	public MlRole getRoleByPrikey(MlRole role) {
		return (MlRole) this.roleDao.getById(role.getRoleId());
	}

	public int createRole(MlRole role) {
		role.setRoleId(KeyGenerator.getNextKey("ML_ROLE", "ROLE_ID"));
		return this.roleDao.save(role);
	}

	public int updateRoleByPriKey(MlRole role) {
		return this.roleDao.updateSelective(role);
	}

	public int deleteRoleByPriKey(long id) {
		return this.roleDao.deleteById(Long.valueOf(id));
	}

	@Override
	public List<RescAuthModel> loadRoleAuthTree(MlRole role) {
		List<RescAuthModel> rescAuthList = null;
		// 得到所有的模块
		MlSysRescExample rescExample = new MlSysRescExample();
		MlSysRescExample.Criteria rescCriteria = rescExample.createCriteria();
		rescCriteria.andRescTypeEqualTo("M");
		rescCriteria.andRescStatusEqualTo("1");
		rescExample.setOrderByClause("RESC_ID");
		List<MlSysResc> allRescList = this.rescDao.findAll(rescExample);

		// 得到所有的权限列表
		List<MlSysAuthority> allAuthList = this.authorityDao.getAll();

		// 获取角色对应的模块信息
		List<MlSysResc> roleRescList = this.rescDao.getSavedRescByRoleId(role
				.getRoleId());

		// 获取角色对应的权限信息
		List<MlSysAuthority> roleAuthList = this.authorityDao
				.selectByRoleId(role.getRoleId());

		if (allRescList != null) {
			rescAuthList = new ArrayList<RescAuthModel>();
			generatorRescAuth(allRescList, roleRescList, allAuthList,
					roleAuthList, rescAuthList);
		}

		return rescAuthList;
	}

	/**
	 * 生成权限设置树数据
	 * 
	 * @param allRescList
	 * @param roleRescList
	 * @param allAuthList
	 * @param roleAuthList
	 * @param rescAuthList
	 */
	private void generatorRescAuth(List<MlSysResc> allRescList,
			List<MlSysResc> roleRescList, List<MlSysAuthority> allAuthList,
			List<MlSysAuthority> roleAuthList, List<RescAuthModel> rescAuthList) {
		RescAuthModel rescAuthModel = null;
		MlSysResc resc = null;

		if ((allRescList != null) && (allRescList.size() > 0))
			for (int i = 0; i < allRescList.size(); i++) {
				resc = (MlSysResc) allRescList.get(i);

				if (resc.getParentId().longValue() == 0L) {
					rescAuthModel = convertRescAuthByResc(resc);
					rescAuthModel.setChecked(isRescModelChecked(rescAuthModel, roleRescList));
					generatorAuthOfResc(rescAuthModel, allAuthList, roleAuthList);
					generatorChildRescAuth(rescAuthModel, allRescList,allAuthList,roleRescList,roleAuthList);
					rescAuthList.add(rescAuthModel);
				}
			}
	}

	/**
	 * 将模块对象转化为脚色权限设置对象
	 * 
	 * @param resc
	 * @return
	 */
	private RescAuthModel convertRescAuthByResc(MlSysResc resc) {
		RescAuthModel rescAuthModel = null;

		if (resc != null) {
			rescAuthModel = new RescAuthModel();
			rescAuthModel.setPid("");
			rescAuthModel.setId(String.valueOf(resc.getRescId()));
			rescAuthModel.setText(resc.getRescTitle());
			rescAuthModel.setType("M");
			rescAuthModel.setUrl(resc.getRescUrl() == null ? "" : resc
					.getRescUrl());
			rescAuthModel.setIconCls(resc.getRescIcon());
			rescAuthModel.setIsLeaf(resc.getIsLeaf());
			rescAuthModel.setSeq(resc.getRescSeq().intValue());
		}

		return rescAuthModel;
	}

	/**
	 * 检查当前模块权限是否应当被选中
	 * 
	 * @param rescAuthModel
	 * @param roleRescList
	 * @return
	 */
	private boolean isRescModelChecked(RescAuthModel rescAuthModel,
			List<MlSysResc> roleRescList) {
		if (roleRescList == null)
			return false;

		MlSysResc tempResc = null;
		boolean isChecked = false;
		for (int i = 0; i < roleRescList.size(); ++i) {
			tempResc = (MlSysResc) roleRescList.get(i);
			if (rescAuthModel.getId().equals(tempResc.getRescId().toString())) {
				isChecked = true;
				break;
			}
		}

		return isChecked;
	}

	/**
	 * 生成模块对应权限信息
	 * 
	 * @param rescAuthModel
	 * @param allAuthList
	 * @param roleAuthList
	 */
	private void generatorAuthOfResc(RescAuthModel rescAuthModel,
			List<MlSysAuthority> allAuthList, List<MlSysAuthority> roleAuthList) {
		if (!"Y".equals(rescAuthModel.getIsLeaf()) || allAuthList == null)
			return;

		MlSysAuthority tempAuth = null;
		RescAuthModel authChild = null;
		List<RescAuthModel> authChildList = new ArrayList<RescAuthModel>();
		for (int i = 0; i < allAuthList.size(); ++i) {
			tempAuth = (MlSysAuthority) allAuthList.get(i);
			if (rescAuthModel.getId().equals(tempAuth.getRescId().toString())) {
				authChild = convertRescAuthByAuth(tempAuth);
				authChild.setChecked(isAuthModelChecked(authChild,roleAuthList));
				authChildList.add(authChild);
			}
		}

		rescAuthModel.setChildren(authChildList);
	}

	/**
	 * 将权限对象转化为脚色权限设置对象
	 * @param auth
	 * @return
	 */
	private RescAuthModel convertRescAuthByAuth(MlSysAuthority auth) {
		RescAuthModel rescAuthModel = null;

		if (auth != null) {
			rescAuthModel = new RescAuthModel();
			rescAuthModel.setId(String.valueOf(auth.getAuthId()));
			rescAuthModel.setPid(String.valueOf(auth.getRescId()));
			rescAuthModel.setText(auth.getAuthDesc());
			rescAuthModel.setIconCls("icon-ui-auth");
			rescAuthModel.setType("A");
		}
		
		return rescAuthModel;
	}
	
	/**
	 * 检查当前权限是否应当被选中
	 * @param rescAuthModel
	 * @param roleAuthList
	 * @return
	 */
	private boolean isAuthModelChecked(RescAuthModel rescAuthModel,	List<MlSysAuthority> roleAuthList) {
		if (roleAuthList == null)
			return false;

		MlSysAuthority tempAuth = null;
		boolean isChecked = false;
		for (int i = 0; i < roleAuthList.size(); ++i) {
			tempAuth = (MlSysAuthority) roleAuthList.get(i);
			if (rescAuthModel.getId().equalsIgnoreCase(
					tempAuth.getAuthId().toString())) {
				isChecked = true;
				break;
			}
		}

		return isChecked;
	}

	/**
	 * 生成权限设置子菜单
	 * @param RescAuthModel
	 * @param rescList
	 */
	private void generatorChildRescAuth(RescAuthModel rescAuthModel,
			List<MlSysResc> allRescList,List<MlSysAuthority> allAuthList,List<MlSysResc> roleRescList, List<MlSysAuthority> roleAuthList) {
		if ("Y".equals(rescAuthModel.getIsLeaf()))
			return;

		MlSysResc resc = null;
		RescAuthModel childRescAuthModel = null;
		List<RescAuthModel> childRescAuthModelList = new ArrayList<RescAuthModel>();
		for (int i = 0; i < allRescList.size(); i++) {
			resc = (MlSysResc) allRescList.get(i);
			if (rescAuthModel.getId().equals(resc.getParentId().toString())) {
				childRescAuthModel = convertRescAuthByResc(resc);
				childRescAuthModel.setChecked(isRescModelChecked(childRescAuthModel, roleRescList));
				generatorAuthOfResc(childRescAuthModel, allAuthList,
						roleAuthList);
				generatorChildRescAuth(childRescAuthModel, allRescList,allAuthList,roleRescList,roleAuthList);
				childRescAuthModelList.add(childRescAuthModel);
			}
		}
		
		rescAuthModel.setChildren(childRescAuthModelList);
	}

	@Override
	public void saveRoleResc(long roleId, long[] rescIdList) {
		MlRoleRescExample roleRescExample = new MlRoleRescExample();
		roleRescExample.createCriteria().andRoleIdEqualTo(roleId);
		this.roleRescDao.deleteByExample(roleRescExample);

		for (int i = 0; i < rescIdList.length; i++) {
			MlRoleResc roleResc = new MlRoleResc();
			roleResc.setRoleId(roleId);
			roleResc.setRescId(rescIdList[i]);
			this.roleRescDao.save(roleResc);
		}
	}

	@Override
	public void saveRoleAuth(long roleId, long[] authIdList) {
		MlRoleAuthExample roleAuthExample = new MlRoleAuthExample();
		roleAuthExample.createCriteria().andRoleIdEqualTo(roleId);
		this.roleAuthDao.deleteByExample(roleAuthExample);

		for (int i = 0; i < authIdList.length; i++) {
			MlRoleAuth roleAuth = new MlRoleAuth();
			roleAuth.setRoleId(roleId);
			roleAuth.setAuthId(authIdList[i]);
			this.roleAuthDao.save(roleAuth);
		}
	}

	@Override
	public List<MlRole> loadUnselectedRole(long userId) {		
		return this.roleDao.getUnselectByUserId(userId);
	}

	@Override
	public List<MlRole> loadSelectedRole(long userId) {
		return this.roleDao.selectByUserId(userId);
	}
}