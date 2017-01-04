package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.ContactsDao;
import entity.Contacts;
import service.ContactsService;
@Service(value="contactsServiceImpl")
public class ContactsServiceImpl implements ContactsService {
	@Autowired
	@Qualifier(value="contactsDao")
	private ContactsDao contactsDaoImpl;
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addContacts(Contacts contacts) throws RuntimeException{
		contactsDaoImpl.addContacts(contacts);
	}

	@Override
	public List<Contacts> findList(Integer id) {
		return contactsDaoImpl.findList(id);
	}

	@Override
	public void deleteContact(Integer id) throws RuntimeException {
		contactsDaoImpl.deleteContact(id);
	}

	@Override
	public void modifyContacts(Contacts contacts) throws RuntimeException {
		contactsDaoImpl.modifyContacts(contacts);
		
	}

}
