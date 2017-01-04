package entity;

import java.util.Date;

//功能权限表
public class Role_premission {
	private Integer id;				// 主键
	private Integer roleId;			// 角色 ID（来源于： as_role 表中的 id）
	private Integer functionId;		// 功能 ID（来源于： as_function 表中的 id）
	private Date creationTime;		// 创建日期
	private String createdBy;		// 创建人（来源 as_user 表中 userCode）
	private Date lastUpdateTime;	// 最新更新日期
	private Integer isStart;		// 是否启用（ 1、启用 0 未启用）


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getFunctionId() {
		return functionId;
	}

	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Integer getIsStart() {
		return isStart;
	}

	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}

}
