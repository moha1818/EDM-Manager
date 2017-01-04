package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.AccountDao;
import entity.Account;
import service.AccountService;

@Service(value="accountServiceImpl")
public class AccountServiceImpl implements AccountService{

	@Autowired
	@Qualifier(value="accountDao")
	private AccountDao accountDao;
	
	@Override
	public Account getAccount(int id) {
		Account account = accountDao.getAccount(id);
		return account;
	}

	@Override
	public void modifyAccount(int userid, Double money) throws RuntimeException {
		accountDao.modifyAccount(userid, money);
		
	}

}
