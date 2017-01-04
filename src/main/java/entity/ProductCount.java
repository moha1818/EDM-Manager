package entity;

//产品分类数量/金额汇总
public class ProductCount {

	private int id; 			//序号
	private String typeName; 	//产品分类名称
	private int count; 			//数量
	private double money;		//价格
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
}
