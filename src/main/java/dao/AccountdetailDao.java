package dao;

import entity.Accountdetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository(value = "accountdetailDao")
public interface AccountdetailDao {

	//根据用户id得到账户详细表并分页
	public List<Accountdetail> showDetail(@Param("id")int id,
									@Param("lineNum")int lineNum,
									@Param("pageSize")int pageSize,
									@Param("detailType")int detailType,
									@Param("start")Date starttime,
									@Param("end")Date endtime);
	//得到总记录数
	public int detailCount(@Param("id")int id,
						@Param("detailType")int detailType,
						@Param("start")Date starttime,
						@Param("end")Date endtime);
	
	//预付款流水报表
	public List<Accountdetail> preRunning(@Param("start")Date starttime,
										@Param("end")Date endtime);
	
	//代理商流水报表
	public List<Accountdetail> agentRunning(@Param("start")Date starttime,
										@Param("end")Date end); 
	
	//添加详细账单
	public void addDetail(Accountdetail accountdetail);
}
