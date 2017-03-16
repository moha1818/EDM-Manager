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
import java.util.List;
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

	private List<String> emails;
	private List<String> ids;
	private String targetEmail;
	private String eidGroup;
	private String subject;
	private String content;
	private String email;

	public String showAccount(){
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		
		account = accountServiceImpl.getAccount(user.getId());
		return SUCCESS;
	}
	private Map<String, Object> msg = new HashMap<>();
	public String sendEmail(){
	/*	Map map=new HashMap();
		map.put("emailcode",110);
		try{
			emailService.sendEmail(map,"verifyEmail.vm","mohaxs@foxmail.com","test");
		}catch (Exception e){
			return INPUT;
		}*/
		if(eidGroup!=null && targetEmail!=null) {
			String[] eids = eidGroup.split(",");//企业ID
			String[] emails = targetEmail.split(",");//企业邮箱

			for (String email : emails) {
				emailService.sendEmail(content, email, subject);
			}
			msg.put("msg",1);
		}else{
			msg.put("msg",0);
		}

		return SUCCESS;
	}
	public String successSendE(){
		Map map=new HashMap();
		map.put("name","");
		map.put("targetVM","supplierAuthPass.vm");
		emailService.sendEmail(map,"cnEmail.vm",email,"eGTCP审核通过");
		return SUCCESS;
	}

	public String openEmail() {
		return SUCCESS;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public String getTargetEmail() {
		return targetEmail;
	}

	public void setTargetEmail(String targetEmail) {
		this.targetEmail = targetEmail;
	}

	public String getEidGroup() {
		return eidGroup;
	}

	public void setEidGroup(String eidGroup) {
		this.eidGroup = eidGroup;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Map<String, Object> getMsg() {
		return msg;
	}

	public void setMsg(Map<String, Object> msg) {
		this.msg = msg;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
}
