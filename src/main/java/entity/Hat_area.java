package entity;

//区域表
public class Hat_area {
	private Integer id;			// 主键ID
	private String areaID;		// 区ID
	private String area;		// 区的中文名称
	private String father;		// 所属市ID（来源于：表hat_city中的cityID）

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaID() {
		return areaID;
	}

	public void setAreaID(String areaID) {
		this.areaID = areaID;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

}
