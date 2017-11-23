package service.impl;


import dao.CustomsDao;
import entity.Contacts;
import entity.Customs;
import model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.ContactsService;
import service.CustomsService;
import service.LogsService;

import java.util.List;
@Service(value="customsServiceImpl")
public class CustomsServiceImpl implements CustomsService {
	@Autowired
	private CustomsDao customsDao;
	@Autowired
	private LogsService logsService;
	@Autowired
	private ContactsService contactsServiceImpl;
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addCus(Customs customs,List<Contacts> contacts) throws RuntimeException {
		customsDao.addCus(customs);
		if(contacts!=null) {
			for (Contacts con : contacts) {
				con.setCustomId(customs.getId());// 最近的customId
				contactsServiceImpl.addContacts(con);
			}
			// 添加日志
			String info = "用户添加客户信息操作";
			logsService.addLogs(info);
		}
	}

	@Override
	public Page getPage(int pageSize, int pageIndex, String name) {
		Page p=new Page();
		p.setPageIndex(pageIndex);
		p.setPageSize(pageSize);
		String cusName;
		if(name!=null){
			cusName="%"+name+"%";
		}else{
			cusName=name;
		}
		p.setTotalCount(customsDao.count(cusName));
		p.setTotal(customsDao.count(cusName));
		p.setList(customsDao.likefind(p.getLineNum(), pageSize, cusName));
		return p;
	}

	@Override
	public Customs findone(Integer id) {
		return customsDao.findone(id);
	}

	@Override
	public void modifyCus(Customs customs) throws RuntimeException {
		customsDao.modifyCus(customs);
	}

	@Override
	public void state(Integer id, String status) throws RuntimeException {
		int customStatus;
		if(status.trim().equals("启用")){
			customStatus=1;
		}else{
			customStatus=0;
		}
		customsDao.state(id, customStatus);
	}

	@Override
	public List<Customs> likeCus(String name)  {
		String cusName;
		if(name!=null){
			cusName="%"+name+"%";
		}else{
			cusName=name;
		}
		return customsDao.likeCus(cusName);
	}


}
