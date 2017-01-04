package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.HatDao;
import entity.Hat_area;
import entity.Hat_city;
import entity.Hat_province;
import service.HatService;
@Service(value="hatServiceImpl")
public class HatServiceImpl implements HatService {
	@Autowired
	@Qualifier(value="hatDao")
	private HatDao hatDao;

	@Override
	public List<Hat_province> provinces() {
		return hatDao.provinces();
	}

	@Override
	public List<Hat_city> citys(String provinceId) {
		return hatDao.citys(provinceId);
	}

	@Override
	public List<Hat_area> areas(String cityID) {
		return hatDao.areas(cityID);
	}

	@Override
	public Hat_province pro(String provinceId) {
		return hatDao.pro(provinceId);
	}

}
