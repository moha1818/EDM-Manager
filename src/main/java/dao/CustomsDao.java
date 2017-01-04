package dao;

import entity.Customs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository(value="customsDao")
public interface CustomsDao {
	//模糊分页查询客户
	public List<Customs> likefind(@Param("lineNum")Integer lineNum,@Param("pageSize")Integer pageSize,@Param("name")String name);
	//模糊查询数据行数
	public int count(@Param("name")String name);
	//根据姓名模糊查询客户
	public List<Customs> likeCus(@Param("name")String name);
	//客户添加
	public void addCus(Customs customs);
	
	//客户修改
	public void modifyCus(Customs customs);
	
	//根据客户主键ID显示查客户信息
	public Customs findone(Integer id);
	
	//根据客户主键ID开启或关闭客户状态
	public void state(@Param("id")Integer id,@Param("customStatus")Integer customStatus);
}
