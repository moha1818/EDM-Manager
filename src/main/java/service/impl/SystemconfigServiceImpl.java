package service.impl;

import dao.SystemconfigDao;
import model.Page;
import entity.Systemconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.SystemconfigService;

import java.util.List;
@Service(value="systemconfigServiceImpl")
public class SystemconfigServiceImpl implements SystemconfigService{
	@Autowired
	@Qualifier(value="systemconfigDao")
	private SystemconfigDao systemconfigDao;
	
	@Override
	public List<Systemconfig> type(Integer configType, Integer isStart) {
		return systemconfigDao.type(configType, isStart);
	}
	@Override
	public void addSystemconfig(Systemconfig systemconfig) {
		 systemconfigDao.addSystemconfig(systemconfig);
	}

	/*@Override
	public int findConfigTypeValue(Integer configType) {
		return systemconfigDao.findConfigTypeValue(configType);
	}*/
	@Override
	public Page getPage(int pageSize, int pageIndex,int configType) {
		Page p=new Page();
		p.setPageIndex(pageIndex);
		p.setPageSize(pageSize);
		p.setTotalCount(systemconfigDao.count(1));
		List<Systemconfig> list=systemconfigDao.pagefind(p.getLineNum(), pageSize, configType);
		p.setList(list);
		return p;
	}
	@Override
	public void delete(Integer id) {
		systemconfigDao.delete(id);
	}
	@Override
	public List<Systemconfig> getConfig(int configType) {
		List<Systemconfig> list = systemconfigDao.getConfig(configType);
		return list;
	}
	@Override
	public Systemconfig findsys(Systemconfig systemconfig) {
		return systemconfigDao.findsys(systemconfig);
	}
	@Override
	public  void update(Systemconfig systemconfig) {
		systemconfigDao.update(systemconfig);
		
	}
	@Override
	public Systemconfig findByID(Integer id) {
		return systemconfigDao.findByID(id);
	}
}
