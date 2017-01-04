package service;

import entity.Page;

public interface LogsService {
	//添加日志操作
	public void addLogs(String info);
	//分页显示日志
	public Page logs(int pageSize, int pageIndex ,int userId);
}
