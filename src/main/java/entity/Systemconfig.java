package entity;

//系统配置表
public class Systemconfig {
	private Integer id;					// 主键
	private Integer configType;			// 配置类型（ 1、财务类型 2、服务类型 3、服务年限 4、 APP 地址 5、客户类型 6、证件类型 7、优惠类型）
	private String configTypeName;		// 具体配置类型的配置参数 name
	private Integer configTypeValue;	// 具体配置类型的配置参数 id
	private String configValue;			// 具体配置类型的配置参数对应的 value（服务年限、 APP地址、服务类型、优惠类型会用到这个字段）
	private Integer isStart;			// 是否启用（ 1、启用 0、 未启用）

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConfigType() {
		return configType;
	}

	public void setConfigType(Integer configType) {
		this.configType = configType;
	}

	public String getConfigTypeName() {
		return configTypeName;
	}

	public void setConfigTypeName(String configTypeName) {
		this.configTypeName = configTypeName;
	}

	public Integer getConfigTypeValue() {
		return configTypeValue;
	}

	public void setConfigTypeValue(Integer configTypeValue) {
		this.configTypeValue = configTypeValue;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public Integer getIsStart() {
		return isStart;
	}

	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}
}
