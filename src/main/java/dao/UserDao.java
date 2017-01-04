package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userDao")
public interface UserDao {

	//登录
	public User login(@Param("usercode")String usercode,@Param("password")String password);
	
	//修改密码
	public void pModify(@Param("id")int id,@Param("newpwd")String newpwd,@Param("salt")String salt);
	
	//修改上次登录时间
	public void lastLogin(@Param("id")int id);
	
	//代理商余额报表
	public List<User> balance();
	//
	User selectUserByusercode(String usercode);
	
}
