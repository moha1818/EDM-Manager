package service;

public interface PremissionService {
	//查找该角色的function
	public boolean authorization(Integer roleId,String functionCode);
}
