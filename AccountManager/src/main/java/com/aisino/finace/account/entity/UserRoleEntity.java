package com.aisino.finace.account.entity;

import java.util.Date;

public class UserRoleEntity {
	private long roleId;
	private String orgNo;
	private String roleName;
	private String roleDesc;
	private String status;
	private Date createDate;
	private Date modifyDate;
	private Long oper;
	private String isDefaultRole;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getOper() {
		return oper;
	}

	public void setOper(Long oper) {
		this.oper = oper;
	}

	public String getIsDefaultRole() {
		return isDefaultRole;
	}

	public void setIsDefaultRole(String isDefaultRole) {
		this.isDefaultRole = isDefaultRole;
	}

}
