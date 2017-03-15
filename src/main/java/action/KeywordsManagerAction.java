package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.AccountdetailService;
import service.LogsService;
import service.SystemconfigService;
import service.impl.AccountServiceImpl;
import service.impl.KeywordsServiceImpl;

import java.util.List;
import java.util.Map;

@Controller(value = "keywordsManagerAction")
@Scope(scopeName = "prototype")
public class KeywordsManagerAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier(value="keywordsServiceImpl")
	private KeywordsServiceImpl keywordsServiceImpl;
	
	@Autowired
	@Qualifier(value="accountServiceImpl")
	private AccountServiceImpl accountServiceImpl;
	
	@Autowired
	@Qualifier(value = "systemconfigServiceImpl")
	private SystemconfigService systemconfigServiceImpl;
	
	@Autowired
	@Qualifier(value = "accountdetailServiceImpl")
	private AccountdetailService accountdetailServiceImpl;
	
	@Autowired
	@Qualifier(value = "logsServiceImpl")
	private LogsService logsServiceImpl;
	
	private List<Keywords> keywords;
	private Keywords key;
	private String keywordName;
	private int pageIndex = 1;
	private int pageSize = 10;
	private int totalPage;
	private int x;
	private int y;
	private String appUserName;
	private String appPassword;
	private double money;
	private double price;
	private int sys_years;
	private List<Systemconfig> sys_type;
	private List<Systemconfig> sys_discount;
	private int years;
	private int kid;
	//关键词管理和关键词审核页面共用动态查询分页显示
	public String getKeywodsList(){
		
		keywords = keywordsServiceImpl.getKeywords(pageIndex, pageSize, keywordName);
		int total = keywordsServiceImpl.keywordsCount(keywordName);
		totalPage = total%pageSize==0?(total/pageSize):(total/pageSize+1);
		
		return SUCCESS;
		
	}
	
	//app开通窗口页面信息
	public String showKey(){
		key = keywordsServiceImpl.showKey(keywordName);
		return SUCCESS;
	}
	
	//开通app
	public String openApp(){
		try{
			keywordsServiceImpl.openApp(appPassword,appUserName,kid);
		}catch(Exception e){
			e.printStackTrace();
		}
		// 添加日志
		String info = "用户进行开通app操作";
		logsServiceImpl.addLogs(info);
		return SUCCESS;
	}
	//续费窗口页面信息
	public String showKey2(){

		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		money = accountServiceImpl.getAccount(user.getId()).getMoney();
		
		// 服务年限
		sys_years = systemconfigServiceImpl.type(3, 1).get(0).getConfigTypeValue();
		// 服务类型
		sys_type = systemconfigServiceImpl.type(2, 1);
		// 优惠类型
		sys_discount = systemconfigServiceImpl.type(7, 1);
		
		key = keywordsServiceImpl.showKey(keywordName);
		return SUCCESS;
	}
	
	//关键词续费
	public String renew(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		//修改到期年限
		int time = 0;
		if(years==4){
			time = 3;
		}else{
			time = years;
		}
		keywordsServiceImpl.renew(kid, time);
		//账户详情表插入
		Account account = accountServiceImpl.getAccount(user.getId());
		Accountdetail accountdetail = new Accountdetail();
		accountdetail.setUserId(user.getId());
		accountdetail.setDetailType(5);
		accountdetail.setDetailTypeName("扣除续费资金");
		accountdetail.setMoney(price);
		accountdetail.setAccountMoney(account.getMoney() - price);
		String memo = user.getUserName() + "对" + keywordName + "进行关键词续费操作，扣除续费资金资金："+ time +"年"+ price + "元";
		accountdetail.setMemo(memo);
		accountdetailServiceImpl.freezeMoney(accountdetail);
		// 添加日志
		String info = "用户进行关键词续费操作";
		logsServiceImpl.addLogs(info);
		
		return SUCCESS;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getSys_years() {
		return sys_years;
	}

	public void setSys_years(int sys_years) {
		this.sys_years = sys_years;
	}

	public List<Systemconfig> getSys_type() {
		return sys_type;
	}

	public void setSys_type(List<Systemconfig> sys_type) {
		this.sys_type = sys_type;
	}

	public List<Systemconfig> getSys_discount() {
		return sys_discount;
	}

	public void setSys_discount(List<Systemconfig> sys_discount) {
		this.sys_discount = sys_discount;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Keywords getKey() {
		return key;
	}

	public void setKey(Keywords key) {
		this.key = key;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Keywords> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<Keywords> keywords) {
		this.keywords = keywords;
	}
	public String getKeywordName() {
		return keywordName;
	}
	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}
