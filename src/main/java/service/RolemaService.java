package service;

import java.util.List;

import entity.Role;

public interface RolemaService {
	// 查询角色
	public List<Role> list();

	// 增加角色
	public void addRole(Role role);

	// 修改角色
	public void modifyRole(Role role);

	// 删除角色
	public void delRole(Integer id);
	
	//查询单个角色
	public Role selectRole(Integer id);
}
