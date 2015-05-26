package com.aisino.finace.account.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.finace.account.dao.RescDao;
import com.aisino.finace.account.entity.Menu;
import com.aisino.finace.account.entity.MlSysResc;
import com.aisino.finace.account.entity.MlSysRescExample;
import com.aisino.finace.account.entity.User;
import com.aisino.finace.account.service.MenuServiceI;

@Service("menuService")
public class MenuServiceImpl implements MenuServiceI {
	private RescDao rescDao = null;

	public RescDao getRescDao() {
		return this.rescDao;
	}

	@Autowired
	public void setRescDao(RescDao rescDao) {
		this.rescDao = rescDao;
	}

	public List<Menu> loadMenu(User user) {
		List<MlSysResc> rescList = null;
		List<Menu> menuList = null;

		try {
			rescList = user.getRescs();
			if (rescList != null) {
				List rescIds = new ArrayList();
				MlSysResc tempResc = null;
				for (int i = 0; i < rescList.size(); ++i) {
					tempResc = (MlSysResc) rescList.get(i);
					rescIds.add(tempResc.getRescId());
				}

				MlSysRescExample example = new MlSysRescExample();
				example.createCriteria().andRescTypeEqualTo("M")
						.andRescStatusEqualTo("1").andRescIdIn(rescIds);
				example.setOrderByClause("RESC_SEQ ASC");
				rescList = this.rescDao.findAll(example);
			}
			
			menuList = new ArrayList<Menu>();
			generatorMenu(rescList, menuList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return menuList;
	}

	private void generatorMenu(List<MlSysResc> rescList, List<Menu> menuList) {
		Menu menu = null;
		MlSysResc resc = null;

		if ((rescList != null) && (rescList.size() > 0))
			for (int i = 0; i < rescList.size(); i++) {
				resc = (MlSysResc) rescList.get(i);

				if (resc.getParentId().longValue() == 0L) {
					menu = convertMenu(resc);
					generatorChildMenu(menu, rescList);
					menuList.add(menu);
				}
			}
	}

	private Menu convertMenu(MlSysResc resc) {
		Menu menu = null;

		if (resc != null) {
			menu = new Menu();
			menu.setPid("");
			menu.setId(String.valueOf(resc.getRescId()));
			menu.setText(resc.getRescTitle());
			menu.setUrl(resc.getRescUrl() == null ? "" : resc.getRescUrl());
			menu.setIconCls(resc.getRescIcon());
			menu.setIsLeaf(resc.getIsLeaf());
			menu.setSeq(resc.getRescSeq().intValue());
		}

		return menu;
	}

	private void generatorChildMenu(Menu menu, List<MlSysResc> rescList) {
		if ("Y".endsWith(menu.getIsLeaf()))
			return;

		MlSysResc resc = null;
		Menu childMenu = null;
		List<Menu> childMenuList = new ArrayList<Menu>();
		for (int i = 0; i < rescList.size(); i++) {
			resc = (MlSysResc) rescList.get(i);
			if (menu.getId().equals(resc.getParentId().toString())) {
				childMenu = convertMenu(resc);
				generatorChildMenu(childMenu, rescList);
				childMenuList.add(childMenu);
			}
		}
		menu.setChildren(childMenuList);
	}
}
