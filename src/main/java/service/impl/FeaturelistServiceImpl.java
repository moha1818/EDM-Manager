package service.impl;

import dao.FeaturelistDao;
import entity.Function;
import entity.Role_premission;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.FeaturelistService;

import java.util.Date;
import java.util.List;

@Service(value="featurelistServiceImpl")
public class FeaturelistServiceImpl implements FeaturelistService{
	@Autowired
	@Qualifier(value="featurelistDao")
	public FeaturelistDao featurelistDao;

	@Override
	public List<Function> list() {
		System.out.println("service被执行");
		List<Function> list=featurelistDao.list();		
		return list;
	}

	@Override
	public void addPremission(Role_premission role_premission) {
		featurelistDao.addPremission(role_premission);
		
	}

	@Override
	public void delPremission(Integer roleId) {
		featurelistDao.delPremission(roleId);
		
	}

	@Override
	public List<Integer> role_premissions(Integer roleId) {
		
		return featurelistDao.role_premissions(roleId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updatePremission(Integer roleid, List<Integer> permission, User user) {
		Role_premission role_premission =new Role_premission();
		this.delPremission(roleid);
		for(Integer tmp:permission){
			role_premission.setRoleId(roleid);
			role_premission.setFunctionId(tmp);
			role_premission.setCreationTime(new Date());
			role_premission.setCreatedBy(user.getUserCode());
			role_premission.setLastUpdateTime(new Date());
			role_premission.setIsStart(1);
			this.addPremission(role_premission);
		}
	}
}
