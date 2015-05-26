package com.aisino.finace.account.entity;

import java.util.ArrayList;
import java.util.List;

public class DataGrid {
	private Long total = Long.valueOf(0L);
	private List rows = new ArrayList();

	public Long getTotal() {
		return this.total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return this.rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
}