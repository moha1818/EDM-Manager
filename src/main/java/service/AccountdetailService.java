package service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Accountdetail;

public interface AccountdetailService {

	// 根据用户id得到账户详细表并分页
	public List<Accountdetail> showDetail(int id, int pageIndex, int pageSize, int detailType, Date starttime,
			Date endtime);

	// 得到总记录数
	public int detailCount(@Param("id") int id, int detailType, Date starttime, Date endtime);

	// 预付款流水报表
	public List<Accountdetail> preRunning(Date starttime, Date endtime);

	// 代理商流水报表
	public List<Accountdetail> agentRunning(Date starttime, Date endtime);

	//事务:冻结 ，扣款，返款等账务操作
	//account表金额修改
	public void freezeMoney(Accountdetail accountdetail);
	
	//事务：转账
	//account表金额修改
	//accountdetail表增加
	public int financial(String money,Integer userId,Integer id,Integer detailType,String detailTypeName,String memo);
}
