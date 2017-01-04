package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.ProductCountDao;
import entity.ProductCount;
import service.ProductCountService;

@Service(value="productCountServiceImpl")
public class ProductCountServiceImpl implements ProductCountService{
	
	@Autowired
	@Qualifier(value="productCountDao")
	private ProductCountDao  productCountDao;
	
	@Override
	public List<ProductCount> getCount() {
		
		List<ProductCount> list = productCountDao.getCount();
		return list;
	}

}
