package service;

import java.util.List;

import entity.Systemconfig;

public interface FinancialService {
	// 查询财务类型
	public List<Systemconfig> systemconfigs();
}
