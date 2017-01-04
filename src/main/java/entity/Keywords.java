package entity;

import java.util.Date;

public class Keywords {
	private Integer id;					// 主键
	private String keywords;			// 关键词
	private Integer agentId;			// 代理商 ID（ 来源于 as_user 中的主键 ID）
	private String agentName;			// 代理商 Name（ 来源于 as_user 中的 userName）
	private Customs customs;
	private Integer customId;			// 客户（企业） ID
	private String customName;			// 企业名称  
	private Double preRegFrozenMoney;	// 预注册冻结款
	private Double price;				// 消费金额
	private Systemconfig systemconfig;
	private Integer productType;		// 服务类型（来源于系统配置表 as_systemconfig中 configType=2 的 configTypeValue）
	private Integer serviceYears;		// 申请年限
	private Integer openApp;			// 是否开通 APP（ 0 未开通 1 开通）
	private String appUserName;			// APP 登录账号
	private String appPassword;			// APP 登录密码
	private String loginUrl;			// APP 登录地址
	private String iosDownloadUrl;		// ios 客户端下载地址
	private String androidDownloadUrl;	// android 客户端下载地址
	private String codeIosUrl;			// IOS 二维码下载地址
	private String codeAndroidUrl;		// android 二维码下载地址
	private Date preRegDatetime;		// 关键词预申请注册时间
	private Date preRegPassDatetime;	// 关键词预到期时间
	private Date regDatetime;			// 关键词申请注册时间
	private Date regPassDatetime;		// 关键词到期时间
	private Integer isPass;				// 申请到期状态（ 0 为不过期， 1 为预注册过期，2 为正式注册过期）
	private Integer checkStatus;		// 审核状态（ 0 为已申请 1 为审核中 2 为已通过 3 未通过）
	private Integer isUse;				// 使用状态（ 1 为已使用 0 为未使用）

	
	public Systemconfig getSystemconfig() {
		return systemconfig;
	}

	public void setSystemconfig(Systemconfig systemconfig) {
		this.systemconfig = systemconfig;
	}

	public Customs getCustoms() {
		return customs;
	}

	public void setCustoms(Customs customs) {
		this.customs = customs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
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

	public Integer getCustomId() {
		return customId;
	}

	public void setCustomId(Integer customId) {
		this.customId = customId;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public Double getPreRegFrozenMoney() {
		return preRegFrozenMoney;
	}

	public void setPreRegFrozenMoney(Double preRegFrozenMoney) {
		this.preRegFrozenMoney = preRegFrozenMoney;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Integer getServiceYears() {
		return serviceYears;
	}

	public void setServiceYears(Integer serviceYears) {
		this.serviceYears = serviceYears;
	}

	public Integer getOpenApp() {
		return openApp;
	}

	public void setOpenApp(Integer openApp) {
		this.openApp = openApp;
	}

	public String getAppUserName() {
		return appUserName;
	}

	public void setAppUserName(String appUserName) {
		this.appUserName = appUserName;
	}

	public String getAppPassword() {
		return appPassword;
	}

	public void setAppPassword(String appPassword) {
		this.appPassword = appPassword;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getIosDownloadUrl() {
		return iosDownloadUrl;
	}

	public void setIosDownloadUrl(String iosDownloadUrl) {
		this.iosDownloadUrl = iosDownloadUrl;
	}

	public String getAndroidDownloadUrl() {
		return androidDownloadUrl;
	}

	public void setAndroidDownloadUrl(String androidDownloadUrl) {
		this.androidDownloadUrl = androidDownloadUrl;
	}

	public String getCodeIosUrl() {
		return codeIosUrl;
	}

	public void setCodeIosUrl(String codeIosUrl) {
		this.codeIosUrl = codeIosUrl;
	}

	public String getCodeAndroidUrl() {
		return codeAndroidUrl;
	}

	public void setCodeAndroidUrl(String codeAndroidUrl) {
		this.codeAndroidUrl = codeAndroidUrl;
	}

	public Date getPreRegDatetime() {
		return preRegDatetime;
	}

	public void setPreRegDatetime(Date preRegDatetime) {
		this.preRegDatetime = preRegDatetime;
	}

	public Date getPreRegPassDatetime() {
		return preRegPassDatetime;
	}

	public void setPreRegPassDatetime(Date preRegPassDatetime) {
		this.preRegPassDatetime = preRegPassDatetime;
	}

	public Date getRegDatetime() {
		return regDatetime;
	}

	public void setRegDatetime(Date regDatetime) {
		this.regDatetime = regDatetime;
	}

	public Date getRegPassDatetime() {
		return regPassDatetime;
	}

	public void setRegPassDatetime(Date regPassDatetime) {
		this.regPassDatetime = regPassDatetime;
	}

	public Integer getIsPass() {
		return isPass;
	}

	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}

	public Integer getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Integer getIsUse() {
		return isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

}
