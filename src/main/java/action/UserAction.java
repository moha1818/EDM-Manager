package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Account;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.LogsService;
import service.impl.AccountServiceImpl;
import service.impl.UserServiceImpl;

import java.util.Date;
import java.util.Map;

@Controller(value="userAction")
@Scope(scopeName="prototype")
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier(value="userServiceImpl")
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	@Qualifier(value="accountServiceImpl")
	private AccountServiceImpl accountServiceImpl;
	
	@Autowired
	@Qualifier(value = "logsServiceImpl")
	private LogsService logsServiceImpl;
	
	private Account account;
	private String usercode;
	private String password;
	private String msg;
	private String oldpwd;
	private String newpwd;
	private String repwd;
	private String msg2;
	private Date lastLoginT;
	private String code;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Date getLastLoginT() {
		return lastLoginT;
	}
	public void setLastLoginT(Date lastLoginT) {
		this.lastLoginT = lastLoginT;
	}
	public String getMsg2() {
		return msg2;
	}
	public void setMsg2(String msg2) {
		this.msg2 = msg2;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String system(){
		return SUCCESS;
	}
	//登录
	public String login(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		if(session.get("user")==null){
				if(usercode==null&&password==null){
				return INPUT;
			}
		User user = userServiceImpl.login(usercode, password);
		if(user==null){
			msg = "登录失败，用户名或密码错误";
			return INPUT;
		}
		String sessionCode = (String) session.get("code");
		if(!code.equalsIgnoreCase(sessionCode)){
			msg = "验证码错误";
			return INPUT;
		}
		session.put("user", user);
		}
		String info = "用户进行登录操作操作成功";
		logsServiceImpl.addLogs(info);
		
		return SUCCESS;
	}
	
	//退出
	public String loginOut(){
		
		ActionContext.getContext().getSession().remove("user");
		
		return SUCCESS;
	}
	
	//修改密码
	public String pModify(){
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		
		if(!oldpwd.equals(user.getUserPassword())){
			
			msg2 = "修改失败，当前密码不正确";
			return INPUT;
		}
		
		userServiceImpl.pModify(user.getId(), newpwd);
		session.remove("user");
		return SUCCESS;

	}
	
	//首页内嵌框架显示上次登录时间
	public String index(){
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		
		lastLoginT = user.getLastLoginTime();
		//账户余额
		account = accountServiceImpl.getAccount(user.getId());
		//修改上次登录时间为当前时间
		userServiceImpl.lastLogin(user.getId());

		return SUCCESS;
	}
}
