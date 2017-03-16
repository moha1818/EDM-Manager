package dao;

import entity.Keywords;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "keywordsDao")
public interface KeywordsDao {

	//门户管理模糊查询分页显示
	public List<Keywords> getportal(@Param("id")int id,
								@Param("lineNum")int lineNum,
								@Param("pageSize")int pageSize,
								@Param("keywordName")String keywordName,
								@Param("customName")String customName);
	//查询总记录数
	public int getCount(@Param("id")int id,
					@Param("keywordName")String keywordName,
					@Param("customName")String customName);
	
	//查看门户
	public Keywords portalView(@Param("id")int id);
	
	//修改门户
	public void portalUpdate(@Param("appUserName")String appUserName,
							@Param("appPassword")String appPassword,
							@Param("iosDownloadUrl")String iosDownloadUrl,
							@Param("codeIosUrl")String codeIosUrl,
							@Param("androidDownloadUrl")String androidDownloadUrl,
							@Param("codeAndroidUrl")String codeAndroidUrl,
							@Param("kid")int kid);
	//查询是否存在关键词
	public int keyCount(String keywords);
	//添加关键词
	public void addKeyWord(@Param("keywords")Keywords keywords);
	
	//获取关键词表分页
	public List<Keywords> getKeywords(@Param("lineNum")int lineNum,
									@Param("pageSize")int pageSize,
									@Param("keywordName")String keywordName);
	//总记录数
	public int keywordsCount(@Param("keywordName")String keywordName);
	
	//根据keyname获取关键词信息
	public Keywords showKey(@Param("keyname")String keyname);
	
	//开通app
	public void openApp(@Param("appPassword")String appPassword,
						@Param("appUserName")String appUserName,
						@Param("kid")int kid);
	//关键词续费
	public void renew(@Param("years")int years,
					  @Param("kid")int kid);
	
	//修改审核状态
	public void updateStatus(@Param("status")int status,
			  				 @Param("keyname")String keyname);
	//修改使用状态
	public void updateUse(@Param("isUse")int isUse,
			  				 @Param("keyname")String keyname);
	List<Keywords> allkeys();
}
