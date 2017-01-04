package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Systemconfig;

@Repository(value="financialDao")
public interface FinancialDao {
	//查询财务类型
	public List<Systemconfig> systemconfigs();
}
