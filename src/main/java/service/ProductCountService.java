package service;

import java.util.List;

import entity.ProductCount;

public interface ProductCountService {
	//产品分类数量/金额汇总
	public List<ProductCount> getCount();
}
