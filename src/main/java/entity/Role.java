package entity;

import java.util.Date;

//角色表
public class Role {
	private Integer id;				// 主键
	private String roleName;		// 角色名称
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
