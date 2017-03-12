package entity;

import java.util.Date;
import java.util.List;

//客户表
public class Customs {
	private Integer id; 			// 主键ID
	private Integer agentId; 		// 代理商ID（来源于as_user中的主键ID）
	private String agentCode; 		// 必填，代理商CODE（来源于as_user中的userCode）
	private String agentName; 		// 代理商Name（来源于as_user中的userName）
	private String customName; 		// 企业名称
	private Integer customType; 	// 客户类型（来源于系统配置表as_systemconfig中configType=5的configTypeValue）
	private String customTypeName; 	// 客户类型（来源于系统配置表as_systemconfig中configType=5的configTypeName）
	private String siteUrl; 		// 企业主页
	private Integer customStatus; 	// 客户状态（1、启用0、停用）
	private String bossName; 		// 法人代表
	private Integer cardType; 		// 证件类型（来源于系统配置表as_systemconfig中configType=6 的configTypeValue）
	private String cardTypeName; 	// 证件类型（来源于系统配置表as_systemconfig中configType=6 的configTypeName）
	private String cardNum; 		// 证件号码
	private String companyTel; 		// 公司电话
	private String companyFax; 		// 公司传真
	private Date regDatetime; 		// 注册时间
	private String country; 		// 国家（默认中国）
	
	private Hat_province pro;
	private Hat_city cit;
	private Hat_area are;
	private List<Contacts> contacts;
	
	private String province; 		// 省（来源于hat_province中的provinceID）
	private String city; 			// 市（来源于hat_city中的cityID）
	private String area; 			// 区（来源于hat_area中的areaID）
	private String companyAddress; 	// 公司地址
	private String memo; 			// 备注
    private String email;

    public Hat_province getPro() {
		return pro;
	}

	public void setPro(Hat_province pro) {
		this.pro = pro;
	}

	public Hat_city getCit() {
		return cit;
	}

	public void setCit(Hat_city cit) {
		this.cit = cit;
	}

	public Hat_area getAre() {
		return are;
	}

	public void setAre(Hat_area are) {
		this.are = are;
	}
	
	public List<Contacts> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public Integer getCustomType() {
		return customType;
	}

	public void setCustomType(Integer customType) {
		this.customType = customType;
	}

	public String getCustomTypeName() {
		return customTypeName;
	}

	public void setCustomTypeName(String customTypeName) {
		this.customTypeName = customTypeName;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public Integer getCustomStatus() {
		return customStatus;
	}

	public void setCustomStatus(Integer customStatus) {
		this.customStatus = customStatus;
	}

	public String getBossName() {
		return bossName;
	}

	public void setBossName(String bossName) {
		this.bossName = bossName;
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public String getCardTypeName() {
		return cardTypeName;
	}

	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCompanyTel() {
		return companyTel;
	}

	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	public String getCompanyFax() {
		return companyFax;
	}

	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
	}

	public Date getRegDatetime() {
		return regDatetime;
	}

	public void setRegDatetime(Date regDatetime) {
		this.regDatetime = regDatetime;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
