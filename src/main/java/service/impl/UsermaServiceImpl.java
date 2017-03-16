package service.impl;

import dao.AccountDao;
import dao.UsermaDao;
import model.Page;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.UsermaService;
import utils.Hashsalt;

import java.util.List;

@Service(value="usermaServiceImpl")
public class UsermaServiceImpl implements UsermaService{
	
	@Autowired
	@Qualifier(value="usermaDao")
	public UsermaDao usermadao;
	@Autowired
	@Qualifier(value="accountDao")
	public AccountDao accountDao;
	
	@Override
	public List<User> userlist(Integer pageIndex,Integer pageSize,String userName,Integer roleid,Integer isStart) {
		if(userName==null){
			userName=null;
		}else{
			userName="%"+userName+"%";
		}
		Page p=new Page();
		p.setPageIndex(pageIndex);
		p.setPageSize(pageSize);
		return usermadao.userlist(p.getLineNum(),pageSize,userName,roleid,isStart);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addUser(User user,Double money) throws RuntimeException {
		Hashsalt hashsalt=new Hashsalt();
		User password_salt=new User();
		password_salt=hashsalt.saveTo(user.getUserPassword());
		user.setSalt(password_salt.getSalt());
		user.setUserPassword(password_salt.getUserPassword());
		usermadao.addUser(user);
		accountDao.addAccount(user.getId(), money);
	}

	
	@Override
	public int num(String userName, Integer roleid, Integer isStart) {
		if(userName==null){
			userName=null;
		}else{
			userName="%"+userName+"%";
		}
		return usermadao.num(userName, roleid, isStart);
	}

	@Override
	public void delUser(Integer id) {
		usermadao.delUser(id);
		
	}

	@Override
	public List<User> findUsers(String name) {
		String cusName;
		if(name!=null){
			cusName="%"+name+"%";
		}else{
			cusName=name;
		}
		return usermadao.findUsers(cusName, 2, 1);
	}

	@Override
	public User user(int id) {
		
		return usermadao.user(id);
	}

	@Override
	public void modifyUser(User user) {
		Hashsalt hashsalt=new Hashsalt();
		User password_salt=new User();
		password_salt=hashsalt.saveTo(user.getUserPassword());
		user.setSalt(password_salt.getSalt());
		user.setUserPassword(password_salt.getUserPassword());
		usermadao.modifyUser(user);
	}
	
}
