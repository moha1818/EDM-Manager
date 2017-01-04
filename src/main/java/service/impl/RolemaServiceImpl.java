package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.RolemaDao;
import entity.Role;
import service.RolemaService;

@Service(value="rolemaServiceImpl")
public class RolemaServiceImpl implements RolemaService{
	
	@Autowired
	@Qualifier(value="rolemaDao")
	public RolemaDao rolemaDao; 
	
	//查询所有角色
	@Override
	public List<Role> list() {
		List<Role> list=rolemaDao.list();
		System.out.println("service被执行");
		return list;
	}

	//增加角色
	@Override
	public void addRole(Role role) {
		rolemaDao.addRole(role);
		
	}

	//修改角色
	@Override
	public void modifyRole(Role role) {
		rolemaDao.modifyRole(role);
		
	}

	//删除角色
	@Override
	public void delRole(Integer id) {
		rolemaDao.delRole(id);
		
	}
	//单个角色
	@Override
	public Role selectRole(Integer id) {
		
		return rolemaDao.selectRole(id);
	}

}
