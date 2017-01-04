package service;

import java.util.List;

import entity.Contacts;

public interface ContactsService {
	// 添加联系人
	public void addContacts(Contacts contacts);

	// 修改客户 ：查相关联系人
	public List<Contacts> findList(Integer id);

	// 修改联系人
	public void modifyContacts(Contacts contacts);

	// 根据主键ID删除联系人
	public void deleteContact(Integer id);
}
