package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Page;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.LogsService;

import java.util.Map;
@Controller(value = "agentLogsAction")
@Scope(scopeName = "prototype")
public class AgentLogsAction extends ActionSupport {
	@Autowired
	@Qualifier(value = "logsServiceImpl")
	private LogsService logsServiceImpl;
	
	private Page cusPage;// 页
	private Integer current;// 页数
	private Integer id;

	public String see_logs(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (current == null) {
			current = 1;
		}
		if(current == 1){
			logsServiceImpl.addLogs("用户进行操作日志查看操作");
		}
		int pageSize = 10;
		cusPage=logsServiceImpl.logs(pageSize, current);
		return SUCCESS;
	}
	
	public Page getCusPage() {
		return cusPage;
	}

	public void setCusPage(Page cusPage) {
		this.cusPage = cusPage;
	}

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
