package dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import entity.Account;

@Repository(value = "accountDao")
public interface AccountDao {

	//根据用户id得到账户
	public Account getAccount(@Param("id")int id);
	//根据用户id修改账户金额
	public void modifyAccount(@Param("userid")int userid,@Param("money")Double money);
	//根据用户id添加账户
	public void addAccount(@Param("userid")int userid,@Param("money")Double money);
}
