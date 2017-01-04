package action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Keywords;
import entity.User;
import service.LogsService;
import service.impl.KeywordsServiceImpl;

@Controller(value = "portalAction")
@Scope(scopeName = "prototype")
public class PortalAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier(value="keywordsServiceImpl")
	private KeywordsServiceImpl keywordsServiceImpl;
	
	@Autowired
	@Qualifier(value = "logsServiceImpl")
	private LogsService logsServiceImpl;
	
	private List<entity.Keywords> keywords;
	private Keywords keyword;
	private int kid;
	private String appUserName;
	private String appPassword;
	private String iosDownloadUrl;
	private String codeIosUrl;
	private String androidDownloadUrl;
	private String codeAndroidUrl;
	private int pageIndex = 1;
	private int pageSize = 2;
	private int totalPage;
	private String keywordName;
	private String customName;
	private int begin;
	private String msg;
	
	//门户管理界面列表
	public String getPortal(){
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		
		keywords = keywordsServiceImpl.getportal(user.getId(), pageIndex, pageSize, keywordName, customName);
		int total = keywordsServiceImpl.getCount(user.getId(), keywordName, customName);
		totalPage = total%pageSize==0?(total/pageSize):(total/pageSize+1);
		if(keywords.size()==0){
			msg = "无数据";
		}
		
		// 添加日志
		String info = "用户进行门户查看操作";
		logsServiceImpl.addLogs(info);
		
		return SUCCESS;
		
	}
	//查看门户
	public String portalView(){
		
		keyword = keywordsServiceImpl.portalView(kid);
		return SUCCESS;
	}

	//修改门户
	public String portalUpdate(){

		keywordsServiceImpl.portalUpdate(appUserName, appPassword, iosDownloadUrl, codeIosUrl, androidDownloadUrl, codeAndroidUrl, kid);
		
		return SUCCESS;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
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
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public String getKeywordName() {
		return keywordName;
	}
	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
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

	public String getIosDownloadUrl() {
		return iosDownloadUrl;
	}

	public void setIosDownloadUrl(String iosDownloadUrl) {
		this.iosDownloadUrl = iosDownloadUrl;
	}

	public String getCodeIosUrl() {
		return codeIosUrl;
	}

	public void setCodeIosUrl(String codeIosUrl) {
		this.codeIosUrl = codeIosUrl;
	}

	public String getAndroidDownloadUrl() {
		return androidDownloadUrl;
	}

	public void setAndroidDownloadUrl(String androidDownloadUrl) {
		this.androidDownloadUrl = androidDownloadUrl;
	}

	public String getCodeAndroidUrl() {
		return codeAndroidUrl;
	}

	public void setCodeAndroidUrl(String codeAndroidUrl) {
		this.codeAndroidUrl = codeAndroidUrl;
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public Keywords getKeyword() {
		return keyword;
	}

	public void setKeyword(Keywords keyword) {
		this.keyword = keyword;
	}

	public List<entity.Keywords> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<entity.Keywords> keywords) {
		keywords = keywords;
	}
	

}
