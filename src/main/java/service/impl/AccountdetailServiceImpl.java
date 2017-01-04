package service.impl;

import dao.AccountdetailDao;
import entity.Accountdetail;
import entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.AccountdetailService;

import java.util.Date;
import java.util.List;

@Service(value = "accountdetailServiceImpl")
public class AccountdetailServiceImpl implements AccountdetailService {

	@Autowired
	@Qualifier(value = "accountdetailDao")
	private AccountdetailDao accountdetailDao;
	@Autowired
	@Qualifier(value = "accountServiceImpl")
	private AccountServiceImpl accountServiceImpl;

	@Override
	public List<Accountdetail> showDetail(int id, int pageIndex, int pageSize, int detailType, Date starttime,
			Date endtime) {
		Page p=new Page();
		p.setPageIndex(pageIndex);
		p.setPageSize(pageSize);
		List<Accountdetail> list = accountdetailDao.showDetail(id, p.getLineNum(), pageSize, detailType, starttime, endtime);
		return list;
	}

	@Override
	public int detailCount(int id, int detailType, Date starttime, Date endtime) {
		int total = accountdetailDao.detailCount(id, detailType, starttime, endtime);
		return total;
	}

	@Override
	public List<Accountdetail> preRunning(Date starttime, Date endtime) {

		List<Accountdetail> list = accountdetailDao.preRunning(starttime, endtime);
		return list;
	}

	@Override
	public List<Accountdetail> agentRunning(Date starttime, Date endtime) {

		List<Accountdetail> list = accountdetailDao.agentRunning(starttime, endtime);
		return list;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void freezeMoney(Accountdetail accountdetail) throws RuntimeException {
		accountdetailDao.addDetail(accountdetail);
		accountServiceImpl.modifyAccount(accountdetail.getUserId(), accountdetail.getAccountMoney());
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public int financial(String money, Integer userId, Integer id, Integer detailType, String detailTypeName,String memo) throws RuntimeException {
		String n1=money.trim().substring(0, 1);
		String n_last=money.trim().substring(1, money.length());
		Double tempMoney1=accountServiceImpl.getAccount(userId).getMoney();
		Double tempMoney2=accountServiceImpl.getAccount(id).getMoney();
		if(n1.equals("-")){
			if(tempMoney1>Double.parseDouble(n_last)){
			//userId
			tempMoney1=tempMoney1-Double.parseDouble(n_last);
			accountServiceImpl.modifyAccount(userId, tempMoney1);
			//id
			tempMoney2=tempMoney2+Double.parseDouble(n_last);
			accountServiceImpl.modifyAccount(id, tempMoney2);
			
			Accountdetail accountdetail=new Accountdetail();
			accountdetail.setAccountMoney(tempMoney1);
			accountdetail.setDetailType(detailType);
			accountdetail.setDetailTypeName(detailTypeName);
			accountdetail.setUserId(userId);
			accountdetail.setMoney(Double.parseDouble(n_last));
			accountdetail.setMemo(memo);
			accountdetailDao.addDetail(accountdetail);
			return 0;
			}else{
				return 1;
			}
		}else{
			if(tempMoney2>Double.parseDouble(money)){
			//userId
			tempMoney1=tempMoney1+Double.parseDouble(n_last);
			accountServiceImpl.modifyAccount(userId, tempMoney1);
			//id
			tempMoney2=tempMoney2-Double.parseDouble(n_last);
			accountServiceImpl.modifyAccount(id, tempMoney2);
			
			Accountdetail accountdetail=new Accountdetail();
			accountdetail.setAccountMoney(tempMoney1);
			accountdetail.setDetailType(detailType);
			accountdetail.setDetailTypeName(detailTypeName);
			accountdetail.setUserId(userId);
			accountdetail.setMoney(Double.parseDouble(n_last));
			accountdetail.setMemo(memo);
			accountdetailDao.addDetail(accountdetail);
			return 0;
			}else{
				return 2;
			}
		}
	}
}
