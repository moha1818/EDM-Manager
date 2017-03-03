package dao;

import entity.Logs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository(value = "logsDao")
public interface LogsDao {
	//添加日志操作
	public void addlogs(Logs logs);
	//返回日志集合
	public List<Logs> logs(@Param("lineNum")Integer lineNum,@Param("pageSize")Integer pageSize);
	//返回数据行数
	public int logsline();

	List<Logs> allLogs();
}
