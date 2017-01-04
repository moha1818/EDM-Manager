package entity;

import java.util.Date;

//账户明细表
public class Accountdetail {
	private Integer id; 			// 主键ID
	private Integer userId; 		// 用户ID（来源于as_user中的主键ID）
	private Integer detailType; 	// 财务类型/流水类型
	private String detailTypeName;	// 财务类型名称/流水类型名称
	private Double money; 			// 账务资金（+为账户进账，-为账户出账）
	private Double accountMoney;	// 账户余额
	private String memo; 			// 备注信息
	private Date detailDateTime;	// 明细交易时间
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public Integer getDetailType() {
		return detailType;
	}

	public void setDetailType(Integer detailType) {
		this.detailType = detailType;
	}

	public String getDetailTypeName() {
		return detailTypeName;
	}

	public void setDetailTypeName(String detailTypeName) {
		this.detailTypeName = detailTypeName;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getAccountMoney() {
		return accountMoney;
	}

	public void setAccountMoney(Double accountMoney) {
		this.accountMoney = accountMoney;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getDetailDateTime() {
		return detailDateTime;
	}

	public void setDetailDateTime(Date detailDateTime) {
		this.detailDateTime = detailDateTime;
	}

}
