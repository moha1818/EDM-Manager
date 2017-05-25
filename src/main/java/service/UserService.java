package service;

import View.BalanceView;
import entity.User;

import java.util.List;

public interface UserService {

	//登录
	public User login(String usercode,String password);
	
	//修改密码
	public void pModify(int id,String newpwd);
	
	//修改上次登录时间
	public void lastLogin(int id);
	
	//代理商余额报表
	public List<BalanceView> balance();
}
