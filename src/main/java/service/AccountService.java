package service;

import org.apache.ibatis.annotations.Param;

import entity.Account;

public interface AccountService {

	// 根据用户id得到账户
	public Account getAccount(@Param("id") int id);

	// 根据用户id修改账户金额
	public void modifyAccount(int userid, Double money);
}
