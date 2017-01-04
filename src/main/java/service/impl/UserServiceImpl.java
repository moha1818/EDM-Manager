package service.impl;


import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.UserService;
import utils.Hashsalt;

import java.util.List;

@Service(value="userServiceImpl")
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier(value="userDao")
	private UserDao userDao;
	
	@Override
	public User login(String usercode, String password) {
		User user =userDao.selectUserByusercode(usercode);
		Hashsalt hashsalt=new Hashsalt();
		if(hashsalt.equals(password,user))
			return user;
		else
			return null;
	}

	@Override
	public void pModify(int id,String newpwd) {
		Hashsalt hashsalt=new Hashsalt();
		User user=hashsalt.saveTo(newpwd);
		userDao.pModify(id, user.getUserPassword(),user.getSalt());
	}

	@Override
	public void lastLogin( int id) {
		
		userDao.lastLogin(id);
	}

	@Override
	public List<User> balance() {
		
		List<User> list = userDao.balance();
		return list;
	}

	
}
