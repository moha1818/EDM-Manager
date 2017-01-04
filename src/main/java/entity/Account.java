package entity;

//账户表
public class Account {
	private Integer id; 		// 主键ID
	private Integer userId; 	// 用户ID（来源于as_user中的主键ID）
	private Double money; 		// 账户金额

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

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}
