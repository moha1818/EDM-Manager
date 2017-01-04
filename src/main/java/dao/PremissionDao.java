package dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository(value = "premissionDao")
public interface PremissionDao {
	//查找该角色的function
	public int authorization(@Param("roleId")Integer roleId,@Param("functionCode")String functionCode);
}
