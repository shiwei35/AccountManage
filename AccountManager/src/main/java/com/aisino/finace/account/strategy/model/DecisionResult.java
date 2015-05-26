package com.aisino.finace.account.strategy.model;

import java.util.List;
import java.util.Map;

public class DecisionResult {
	private Map resultMap;
	private Map scoreResultMap;
	private List treeExcludeList;
	public Map getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map resultMap) {
		this.resultMap = resultMap;
	}
	public Map getScoreResultMap() {
		return scoreResultMap;
	}
	public void setScoreResultMap(Map scoreResultMap) {
		this.scoreResultMap = scoreResultMap;
	}
	public List getTreeExcludeList() {
		return treeExcludeList;
	}
	public void setTreeExcludeList(List treeExcludeList) {
		this.treeExcludeList = treeExcludeList;
	}
	
	
}
