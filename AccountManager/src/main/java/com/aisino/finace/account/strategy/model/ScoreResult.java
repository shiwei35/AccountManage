package com.aisino.finace.account.strategy.model;

import java.util.List;

public class ScoreResult {
	private String name=null;
	private float score;
	private List<ExcludeInfo> excludes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public List<ExcludeInfo> getExcludes() {
		return excludes;
	}
	public void setExcludes(List<ExcludeInfo> excludes) {
		this.excludes = excludes;
	}
	
	
}
