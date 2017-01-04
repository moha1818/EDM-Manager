package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import entity.Logs;
@Repository(value = "logsDao")
public interface LogsDao {
	//添加日志操作
	public void addlogs(Logs logs);
	//返回日志集合
	public List<Logs> logs(@Param("lineNum")Integer lineNum,@Param("pageSize")Integer pageSize,@Param("userId")Integer userId);
	//返回数据行数
	public int logsline(@Param("userId")Integer userId);
}
