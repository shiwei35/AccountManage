/**
 * 
 */
package com.aisino.finace.account.utils.key;

import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * @author xtuali 备用key池，如果不够了，会重新更新数据库，将备用的key池填满 每一个类维护一个对象池
 */
@Component("keyPool")
@Scope("prototype")
public class KeyPool {
	private static final Long POOLSIZE = 100L;
	/**
	 * 标志当前这个对象是否经过初始化，必须经过初始化才能获取nextValue
	 */
	private volatile boolean isInitFinish = false;

	public boolean isInitFinish() {
		return isInitFinish;
	}

	public void setInitFinish(boolean isInitFinish) {
		this.isInitFinish = isInitFinish;
	}

	private AtomicLong maxValue;

	private AtomicLong nextValue;

	private String tableName;

	private String tableKeyName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableKeyName() {
		return tableKeyName;
	}

	public void setTableKeyName(String tableKeyName) {
		this.tableKeyName = tableKeyName;
	}

	private KeyDao dao;

	public KeyDao getDao() {
		return dao;
	}

	@Autowired
	public void setDao(KeyDao dao) {
		this.dao = dao;
	}

	public static Long getPoolSize() {
		return POOLSIZE;
	}

	public AtomicLong getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(AtomicLong maxValue) {
		this.maxValue = maxValue;
	}

	public AtomicLong getNextValue() {
		return nextValue;
	}

	public void setNextValue(AtomicLong nextValue) {
		this.nextValue = nextValue;
	}

	public KeyPool() {

	}

	/**
	 * @param keyName
	 */
	public KeyPool(String tableName) {
		super();
		this.tableName = tableName;
		init();
	}

	/**
	 * 进行key对象池的初始化
	 * 
	 * @author xtuali 时间：2013-6-24
	 */
	public synchronized void init() {
		if (!isInitFinish) {
			if (tableName==null || "".equals(tableName)) {
				return;
			}
			if (maxValue == null || nextValue == null) {
				dao.initKeyPool(this);
			}
			isInitFinish = true;
		}
	}

	/**
	 * 此处必须要进行同步 2013-07-23 已修正为原子操作不需要同步
	 * 
	 * @return
	 * @author xtuali 时间：2013-6-24
	 */
	public Long getNextKey() {
		// 如果类没有初始化完成，是不能获取key的
		while (!isInitFinish) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		while (nextValue.get() > maxValue.get()) {
			dao.initKeyPool(this);
		}
		return nextValue.getAndIncrement();
	}
}
