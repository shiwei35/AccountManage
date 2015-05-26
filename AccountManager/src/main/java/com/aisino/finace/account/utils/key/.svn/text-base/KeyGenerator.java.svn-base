/**
 * 
 */
package com.aisino.finace.account.utils.key;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component("keyGenerator")
public class KeyGenerator implements ApplicationContextAware {

	private static ApplicationContext context;

	private static volatile Map<String, KeyPool> keyMap = new HashMap<String, KeyPool>(
			64);

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 * @author xtuali 时间：2013-6-24
	 */
	@Override
	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}

	public static Long getNextKey(String tableName, String keyName) {
		tableName = tableName.intern();
		KeyPool key = null;
		key = keyMap.get(tableName);

		if (null == key) {
			synchronized (tableName) {
				key = keyMap.get(tableName);
				if (key == null) {
					key = (KeyPool) context.getBean("keyPool");
					keyMap.put(tableName, key);
				}
			}
			if (!key.isInitFinish()) {
				key.setTableName(tableName);
				key.setTableKeyName(keyName);
				key.init();
			}
		}
		return key.getNextKey();
	}
}
