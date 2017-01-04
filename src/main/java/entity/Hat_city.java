package entity;

//城市表
public class Hat_city {
	private Integer id;			// 主键ID
	private String cityID;		// 市ID
	private String city;		// 市的中文名称
	private String father;		// 所属省ID（来源于：表hat_province中的provinceID）

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

}
