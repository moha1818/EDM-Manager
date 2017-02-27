package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "agentKeyAction")
@Scope(scopeName = "prototype")
public class AgentKeyAction extends ActionSupport implements Preparable {
	@Autowired
	@Qualifier(value = "customsServiceImpl")
	private CustomsService customsServiceImpl;
	@Autowired
	@Qualifier(value = "accountServiceImpl")
	private AccountService accountServiceImpl;
	@Autowired
	@Qualifier(value = "accountdetailServiceImpl")
	private AccountdetailService accountdetailServiceImpl;
	@Autowired
	@Qualifier(value = "keywordsServiceImpl")
	private KeywordsService keywordsServiceImpl;
	@Autowired
	@Qualifier(value = "systemconfigServiceImpl")
	private SystemconfigService systemconfigServiceImpl;
	@Autowired
	@Qualifier(value = "logsServiceImpl")
	private LogsService logsServiceImpl;
	private String name;
	private List<Customs> customs;
	private Map<String, Object> msg = new HashMap<>();
	// 余额
	private String balance;

	private int sys_years;
	private List<Systemconfig> sys_type;
	private List<Systemconfig> sys_discount;

	@Override
	public void prepare() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		Account account = accountServiceImpl.getAccount(user.getId());
		if (account != null) {
			DecimalFormat fnum = new DecimalFormat("##0.00");
			balance = fnum.format(account.getMoney());
		} else {
			balance = "无法查询余额";
		}
		// 服务年限
		sys_years = Integer.parseInt(systemconfigServiceImpl.type(3, 1).get(0).getConfigValue());
		// 服务类型
		sys_type = systemconfigServiceImpl.type(2, 1);
		// 优惠类型
		sys_discount = systemconfigServiceImpl.type(7, 1);
	}

	private Keywords keywords;
	private int x;
	private int y;
	// 关键词申请提交
	public String key_add() {
		try {
			Map<String, Object> session = ActionContext.getContext().getSession();
			User user = (User) session.get("user");
			keywords.setAgentId(user.getId());
			keywords.setAgentName(user.getUserName());
			Double premoney;
			if (keywords.getServiceYears() == 4) {
				premoney = keywords.getPrice() / 2;
			} else {
				premoney = keywords.getPrice() / keywords.getServiceYears();
			}
			System.out.println("SUCCESS");
			keywords.setPreRegFrozenMoney(premoney);
			keywordsServiceImpl.addKeyWord(keywords);
			// 关键词资金冻结操作
			Account account = accountServiceImpl.getAccount(user.getId());
			Accountdetail accountdetail = new Accountdetail();
			accountdetail.setUserId(user.getId());
			accountdetail.setDetailType(9999);
			accountdetail.setDetailTypeName("预注册冻结资金");
			accountdetail.setMoney(premoney);
			accountdetail.setAccountMoney(account.getMoney() - premoney);
			String memo = user.getUserName() + "对" + keywords.getCustomName() + "进行关键词申请预注册操作，冻结资金：" + premoney + "元";
			accountdetail.setMemo(memo);
			accountdetailServiceImpl.freezeMoney(accountdetail);
			// 添加日志
			String info = "用户进行关键词申请操作";
			logsServiceImpl.addLogs(info);

			return SUCCESS;
		} catch (RuntimeException r) {
			r.printStackTrace();
			System.out.println("error");
			return INPUT;
		}

	}

	// 模糊查询
	public String findCus() {
		customs = customsServiceImpl.likeCus(name);
		return SUCCESS;
	}

	// 查询关键词
	public String findKey() {

		if (keywordsServiceImpl.keyCount(name) == 0) {
			msg.put("msg", "success");
		} else {
			msg.put("msg", "fail");
		}
		return SUCCESS;
	}

	private Systemconfig systemconfig;

	// 查询syso
	public String find_sys() {
		systemconfig = systemconfigServiceImpl.findsys(systemconfig);
		msg.put("sys", systemconfig);
		return SUCCESS;
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

	public Systemconfig getSystemconfig() {
		return systemconfig;
	}

	public void setSystemconfig(Systemconfig systemconfig) {
		this.systemconfig = systemconfig;
	}

	public List<Systemconfig> getSys_discount() {
		return sys_discount;
	}

	public void setSys_discount(List<Systemconfig> sys_discount) {
		this.sys_discount = sys_discount;
	}

	public Keywords getKeywords() {
		return keywords;
	}

	public void setKeywords(Keywords keywords) {
		this.keywords = keywords;
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

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public Map<String, Object> getMsg() {
		return msg;
	}

	public void setMsg(Map<String, Object> msg) {
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Customs> getCustoms() {
		return customs;
	}

	public void setCustoms(List<Customs> customs) {
		this.customs = customs;
	}

}
