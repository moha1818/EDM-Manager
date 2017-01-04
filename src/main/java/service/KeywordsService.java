package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Keywords;

public interface KeywordsService {

	//门户管理模糊查询分页显示
	public List<Keywords> getportal(int id,int pageIndex,int pageSize,String keywordName,String customName);
	//查询总记录数
	public int getCount(int id,String keywords,String customName);
	
	//查看门户
	public Keywords portalView(int id);
	
	//修改门户
	public void portalUpdate(String appUserName,String appPassword,String iosDownloadUrl,
							String codeIosUrl,String androidDownloadUrl,String codeAndroidUrl,int kid);
	
	//查询是否存在关键词
	public int keyCount(String keywords);
	//添加关键词
	public void addKeyWord(Keywords keywords);
	
	//获取关键词表
	public List<Keywords> getKeywords(int pageIndex,int pageSize,String keywordName);
	//总记录数
	public int keywordsCount(String keywordName);
	
	//根据keyname获取关键词信息
	public Keywords showKey(String keyname);
	
	//开通app
	public void openApp(String appPassword,String appUserName,int kid);
	
	//关键词续费
	public void renew(int kid,int years);
	
	//修改审核状态
	public void updateStatus(int status,String keyname);
	
	//修改使用状态
	public void updateUse(int isUse,String keyname);
}
