package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import entity.Customs;
import entity.Systemconfig;
@Repository(value = "systemconfigDao")
public interface SystemconfigDao {
	//类型
	public List<Systemconfig> type(@Param("configType")Integer configType,@Param("isStart")Integer isStart);

	// 增加系统配置
	public void addSystemconfig(Systemconfig systemconfig);

	/*// 寻找configTypeValue
	public int findConfigTypeValue(@Param("configType") Integer configType);*/

	//分页查询
	public List<Systemconfig> pagefind(@Param("lineNum")Integer lineNum,@Param("pageSize")Integer pageSize,@Param("configType") Integer configType);
	
	//模糊查询系统配置数据行数
	public int count(@Param("configType") Integer configType);
	 
	//删除系统配置
	public void delete(@Param("id") Integer id);
	
	//根据 configType查询类集合
	public List<Systemconfig> getConfig(@Param("configType") int configType);
	
	//动态查询
	public Systemconfig findsys(Systemconfig systemconfig);
	
	//更新配置
	public  void update(Systemconfig systemconfig);
	
	//根据ID查询配置
	public Systemconfig findByID(@Param("id") Integer id);
}
