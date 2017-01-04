package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Contacts;
@Repository(value="contactsDao")
public interface ContactsDao {
	//添加联系人
	public void addContacts(Contacts contacts);
	//修改联系人
	public void modifyContacts(Contacts contacts);
	//根据customId查找先关联系人
	public List<Contacts> findList(Integer id);
	//根据主键ID删除联系人
	public void deleteContact(Integer id);

}
