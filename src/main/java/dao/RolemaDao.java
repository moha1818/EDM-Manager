package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Role;

@Repository(value="rolemaDao")
public interface RolemaDao {
	//查询角色
	public List<Role> list();
	
	//增加角色
	public void addRole(Role role);
	
	//修改角色
	public void modifyRole(Role role);
	
	//删除角色
	public void delRole(Integer id);
	
	//查询单个角色
	public Role selectRole(Integer id);
	
}
