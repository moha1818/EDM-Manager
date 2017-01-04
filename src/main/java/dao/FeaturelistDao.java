package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Function;
import entity.Role_premission;

@Repository(value="featurelistDao")
public interface FeaturelistDao {
	//查询所有功能
	public List<Function> list();
	
	//增加权限
	public void addPremission(Role_premission role_premission);
	
	//删除权限
	public void delPremission(Integer roleId);
	
	//查询单个角色的权限功能ID集合
	public List<Integer> role_premissions(Integer roleId);
}
