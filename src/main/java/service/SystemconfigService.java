package service;

import model.Page;
import entity.Systemconfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemconfigService {
	//类型查找
	public List<Systemconfig> type(Integer configType,Integer isStart);

	// 增加系统配置
	public void addSystemconfig(Systemconfig systemconfig);

	/*// 寻找configTypeValue
	public int findConfigTypeValue(Integer configType);*/
	
	//分页显示系统配置
	public Page getPage(int pageSize, int pageIndex,int configType);
	
	//删除系统配置
	public void delete(Integer id);
	
	//根据 configType查询类集合
	public List<Systemconfig> getConfig(@Param("configType") int configType);
	
	//动态查询
	public Systemconfig findsys(Systemconfig systemconfig);
	
	//更新配置
	public void update(Systemconfig systemconfig);

	// 根据ID查询配置
	public Systemconfig findByID(Integer id);
}
