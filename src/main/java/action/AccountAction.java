package action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Account;
import entity.User;
import service.impl.AccountServiceImpl;


@Controller(value="accountAction")
@Scope(scopeName="prototype")
public class AccountAction  extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier(value="accountServiceImpl")
	private AccountServiceImpl accountServiceImpl;
	
	private Account account;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String showAccount(){
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		
		account = accountServiceImpl.getAccount(user.getId());
		return SUCCESS;
	}

 
}
