package service.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.LogsDao;
import entity.Logs;
import entity.Page;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.LogsService;

import java.util.Map;
@Service(value="logsServiceImpl")
public class LogsServiceImpl implements LogsService {
	@Autowired
	@Qualifier(value="logsDao")
	private LogsDao  logsDao;
	@Override
	public void addLogs(String info) throws RuntimeException {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		Logs log=new Logs();
		log.setUserId(user.getId());
		log.setUserName(user.getUserName());
		log.setOperateInfo(info);
		logsDao.addlogs(log);
	}
	@Override
	public Page logs(int pageSize, int pageIndex,int userId) {
		Page p=new Page();
		p.setPageIndex(pageIndex);
		p.setPageSize(pageSize);
		p.setTotalCount(logsDao.logsline(userId));
		p.setList(logsDao.logs(p.getLineNum(), pageSize,userId));
		return p;
	}

}
