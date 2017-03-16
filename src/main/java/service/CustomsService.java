package service;

import entity.Contacts;
import entity.Customs;
import model.Page;

import java.util.List;

public interface CustomsService {
	// 客户添加
	public void addCus(Customs customs, List<Contacts> contacts);

	// 客户分页显示
	public Page getPage(int pageSize, int pageIndex, String name);

	// 客户添加显示
	public Customs findone(Integer id);

	// 客户修改
	public void modifyCus(Customs customs);
	
	//根据客户主键ID开启或关闭客户状态
	public void state(Integer id,String status);
	
	//客户模糊查询
	public List<Customs> likeCus(String name);
}
