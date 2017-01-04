package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "usermaDao")
public interface UsermaDao {
	// 分页查询所有用户
	public List<User> userlist(@Param("lineNum") Integer lineNum, @Param("pageSize") Integer pageSize,
			@Param("userName") String userName, @Param("roleid") Integer roleid, @Param("isStart") Integer isStart);

	// 模糊查询用户数量
	public int num(@Param("userName") String userName, @Param("roleid") Integer roleid,
			@Param("isStart") Integer isStart);

	// 增加用户
	public void addUser(User user);
	
	//修改用户
	public void modifyUser(User user);

	// 删除用户
	public void delUser(Integer id);

	// 根据用户姓名 用户身份 用户是否启用，模糊查询
	public List<User> findUsers(@Param("userName") String userName, @Param("roleid") Integer roleid,
			@Param("isStart") Integer isStart);
	// 查询用户
	public User user(@Param("id") int id);
}
