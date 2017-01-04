package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.User;

public interface UsermaService {
	// 分页查询所有用户
	public List<User> userlist(Integer pageIndex, Integer pageSize, String userName, Integer roleid, Integer isStart);

	// 模糊查询用户数量
	public int num(String userName, Integer roleid, Integer isStart);

	// 增加用户
	// 增加用户as_account
	public void addUser(User user, Double money);

	//修改用户
	public void modifyUser(User user);
	
	// 删除用户
	public void delUser(Integer id);

	// 根据用户姓名模糊查询 用户身份=2 用户是否启用=1，
	public List<User> findUsers(String name);

	// 查询用户
	public User user(int id);
}
