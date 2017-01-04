package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.FinancialDao;
import entity.Systemconfig;
import service.FinancialService;

@Service(value="financialServiceImpl")
public class FinancialServiceImpl implements FinancialService{
	
	@Autowired
	@Qualifier(value="financialDao")
	public FinancialDao financialDao;
	
	@Override
	public List<Systemconfig> systemconfigs() {

		return financialDao.systemconfigs();
	}

}
