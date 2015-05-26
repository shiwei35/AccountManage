package com.aisino.finace.account.service;

import com.aisino.finace.account.entity.Menu;
import com.aisino.finace.account.entity.User;

import java.util.List;

public abstract interface MenuServiceI {
	public abstract List<Menu> loadMenu(User user);
}