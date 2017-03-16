package service.impl;

import dao.KeywordsDao;
import entity.Keywords;
import entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.KeywordsService;

import java.util.List;

@Service(value="keywordsServiceImpl")
public class KeywordsServiceImpl implements KeywordsService{

	@Autowired
	@Qualifier(value="keywordsDao")
	private KeywordsDao  keywordsDao;
	
	@Override
	public List<Keywords> getportal(int id, int pageIndex, int pageSize, String keywordName, String customName) {
		Page p=new Page();
		p.setPageIndex(pageIndex);
		p.setPageSize(pageSize);
		if(keywordName==null||keywordName.equals("")){
			keywordName = null;
		}else{
			keywordName = "%"+keywordName+"%";
		}
		if(customName==null||customName.equals("")){
			customName = null;
		}else{
			customName = "%"+customName+"%";
		}
		List<Keywords> list = keywordsDao.getportal(id, p.getLineNum(), pageSize, keywordName, customName);
		return list;
	}

	@Override
	public int getCount(int id, String keywordName, String customName) {
		
		if(keywordName==null||keywordName.equals("")){
			keywordName = null;
		}else{
			keywordName = "%"+keywordName+"%";
		}
		if(customName==null||customName.equals("")){
			customName = null;
		}else{
			customName = "%"+customName+"%";
		}
		int total = keywordsDao.getCount(id, keywordName, customName);
		return total;
	}

	@Override
	public Keywords portalView(int id) {

		Keywords keywords = keywordsDao.portalView(id);
		return keywords;
	}

	@Override
	public void portalUpdate(String appUserName, String appPassword, String iosDownloadUrl, String codeIosUrl,
			String androidDownloadUrl, String codeAndroidUrl, int kid) {
		
		keywordsDao.portalUpdate(appUserName, appPassword, iosDownloadUrl, codeIosUrl, androidDownloadUrl, codeAndroidUrl, kid);
		
	}

	@Override
	public int keyCount(String keywords) {
		return keywordsDao.keyCount(keywords);
	}

	@Override
	public void addKeyWord(Keywords keywords) throws RuntimeException{
		keywordsDao.addKeyWord(keywords);		
	}

	@Override
	public List<Keywords> getKeywords(int pageIndex, int pageSize, String keywordName) {
		if(keywordName==null||keywordName.equals("")){
			keywordName = null;
		}else{
			keywordName = "%"+keywordName+"%";
		}
		Page p=new Page();
		p.setPageIndex(pageIndex);
		p.setPageSize(pageSize);
		List<Keywords> list = keywordsDao.getKeywords(p.getLineNum(), pageSize, keywordName);
		return list;
	}

	@Override
	public int keywordsCount(String keywordName) {
		if(keywordName==null||keywordName.equals("")){
			keywordName = null;
		}else{
			keywordName = "%"+keywordName+"%";
		}
		int total = keywordsDao.keywordsCount(keywordName);
		return total;
	}

	@Override
	public Keywords showKey(String keyname) {
		Keywords key = keywordsDao.showKey(keyname);
		return key;
	}

	@Override
	public void openApp(String appPassword, String appUserName,int kid) {
		keywordsDao.openApp(appPassword, appUserName,kid);
		
	}

	@Override
	public void renew(int kid, int years) {
		keywordsDao.renew(years, kid);
	}

	@Override
	public void updateStatus(int status, String keyname) {
		keywordsDao.updateStatus(status, keyname);
		
	}

	@Override
	public void updateUse(int isUse, String keyname) {
		keywordsDao.updateUse(isUse, keyname);
		
	}

	@Override
	public List<Keywords> allkeywords() {
		return keywordsDao.allkeys();
	}


}
