package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.ProductCount;

@Repository(value = "productCountDao")
public interface ProductCountDao {

	//产品分类数量/金额汇总
	public List<ProductCount> getCount();
}
