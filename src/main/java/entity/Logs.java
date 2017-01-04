package entity;

import java.util.Date;

//日志表
public class Logs {
	private Integer id;				// 主键
	private Integer userId;			// 用户 ID（ 来源于 as_user 中的主键 ID）
	private String userName;		// 用户姓名（ 来源于 as_user 中的 userName）
	private String operateInfo;		// 操作信息
	private Date operateDatetime;	// 操作时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOperateInfo() {
		return operateInfo;
	}

	public void setOperateInfo(String operateInfo) {
		this.operateInfo = operateInfo;
	}

	public Date getOperateDatetime() {
		return operateDatetime;
	}

	public void setOperateDatetime(Date operateDatetime) {
		this.operateDatetime = operateDatetime;
	}
}
