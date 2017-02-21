package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Account;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.impl.AccountServiceImpl;
import utils.sendemail.EmailService;

import java.util.HashMap;
import java.util.Map;


@Controller(value="accountAction")
@Scope(scopeName="prototype")
public class AccountAction  extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier(value="accountServiceImpl")
	private AccountServiceImpl accountServiceImpl;

	@Autowired
	private EmailService emailService;

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

	public String sendEmail(){
		Map map=new HashMap();
		map.put("emailcode",110);
		try{
			emailService.sendEmail(map,"verifyEmail.vm","mohaxs@foxmail.com","test");
		}catch (Exception e){
			return INPUT;
		}
		return SUCCESS;
	}
 
}
