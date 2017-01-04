package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.PremissionDao;
import service.PremissionService;

@Service(value="premissionServiceImpl")
public class PremissionServiceImpl implements PremissionService {
	@Autowired
	@Qualifier(value="premissionDao")
	private PremissionDao premissionDao;

	@Override
	public boolean authorization(Integer roleId, String functionCode) {
		return (premissionDao.authorization(roleId, functionCode)==0)? false: true;
	}
}
