package action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import entity.Systemconfig;
import entity.User;
import service.AccountService;
import service.AccountdetailService;
import service.FinancialService;
import service.UsermaService;

@Controller(value = "financialAction")
@Scope(scopeName = "prototype")
public class FinancialAction extends ActionSupport implements Preparable{
	@Autowired
	@Qualifier(value = "financialServiceImpl")
	public FinancialService financialService;
	@Autowired
	@Qualifier(value = "usermaServiceImpl")
	public UsermaService usermaServiceImpl;
	@Autowired
	@Qualifier(value = "accountServiceImpl")
	private AccountService accountServiceImpl;
	@Autowired
	@Qualifier(value = "accountdetailServiceImpl")
	private AccountdetailService accountdetailServiceImpl;
	public List<Systemconfig> systemconfigs;
	
	

	@Override
	public void prepare() throws Exception {
		systemconfigs = financialService.systemconfigs();
	}
	public Integer id;
	public Integer detailType;
	public String detailTypeName;
	public String money;
	public String memo;
	
	public String msg;
	
	public String addfinancial(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		try{
			int n=accountdetailServiceImpl.financial(money, user.getId(), id, detailType, detailTypeName,memo);
			if(n==0){
				msg="成功";
				System.out.println(msg);
				return SUCCESS;
			}else if(n==1){
				msg="失败：您的余额不足";
				System.out.println(msg);
				return INPUT;
			}else if(n==2){
				msg="失败：该用户余额不足";
				System.out.println(msg);
				return INPUT;
			}else{
				return INPUT;
			}
		}catch(RuntimeException r){
			r.printStackTrace();
			msg="失败：请输入完整";
			return INPUT;
		}
	}

	private String name;
	private List<User> users;
	//用户模糊查询
	public String findUsers(){
		users=usermaServiceImpl.findUsers(name);
		return SUCCESS;
	}
	
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}



	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetailTypeName() {
		return detailTypeName;
	}

	public void setDetailTypeName(String detailTypeName) {
		this.detailTypeName = detailTypeName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Integer getDetailType() {
		return detailType;
	}

	public void setDetailType(Integer detailType) {
		this.detailType = detailType;
	}


	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List<Systemconfig> getSystemconfigs() {
		return systemconfigs;
	}

	public void setSystemconfigs(List<Systemconfig> systemconfigs) {
		this.systemconfigs = systemconfigs;
	}




	
}
