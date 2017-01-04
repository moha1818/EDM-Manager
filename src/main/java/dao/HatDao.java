package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Hat_area;
import entity.Hat_city;
import entity.Hat_province;
@Repository(value="hatDao")
public interface HatDao {
	//省查询
	public List<Hat_province> provinces();
	//根据provinceId查询市
	public List<Hat_city> citys(String provinceId);
	//根据cityID查询区
	public List<Hat_area> areas(String cityID);
	//省查询根据provinceId查询省
	public Hat_province pro(String provinceId);
}
