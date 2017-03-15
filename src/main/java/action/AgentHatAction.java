package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "agentHatAction")
@Scope(scopeName = "prototype")
public class AgentHatAction extends ActionSupport implements Preparable {
	@Autowired
	@Qualifier(value = "hatServiceImpl")
	private HatService hatServiceImpl;
	@Autowired
	@Qualifier(value = "systemconfigServiceImpl")
	private SystemconfigService systemconfigServiceImpl;
	@Autowired
	@Qualifier(value = "customsServiceImpl")
	private CustomsService customsServiceImpl;
	@Autowired
	@Qualifier(value = "contactsServiceImpl")
	private ContactsService contactsServiceImpl;
	@Autowired
	@Qualifier(value = "logsServiceImpl")
	private LogsService logsServiceImpl;
	// 省
	private List<Hat_province> provinces;
	// 用户类型集合
	private List<Systemconfig> customTypes;
	// 证件类型集合
	private List<Systemconfig> cardTypes;

	@Override
	public void prepare() throws Exception {
		provinces = hatServiceImpl.provinces();
		customTypes = systemconfigServiceImpl.type(5, 1);
		cardTypes = systemconfigServiceImpl.type(6, 1);
		// 根据as_systemconfig中configType=5或6 1为start
	}

	private Customs customs;
	private List<Contacts> contacts;
	//显示客户
	public String show_add(){
		return SUCCESS;
	}
	// 添加客户
	public String add() {
		try {
			Map<String, Object> session = ActionContext.getContext().getSession();
			User user = (User) session.get("user");
			customs.setAgentCode(user.getUserCode());
			customs.setAgentName(user.getUserName());
			customs.setAgentId(user.getId());
			customsServiceImpl.addCus(customs,contacts);
			return SUCCESS;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return INPUT;
		}
	}

	private Page cusPage;// 页
	private Integer current;// 页数
	private String name;// 客户姓名
	// 分页显示客户

	public String pageList() {
		if (current == null) {
			current = 1;
		}
		int pageSize = 10;

		if (name != null) {
			if (name.equals("")) {
				name = null;
			} else {
				if(current==1){
					// 添加日志
					String info = "用户进行客户搜索操作：搜索内容为：" + name;
					logsServiceImpl.addLogs(info);
				}
			}
		}else{
			if(current==1){
				// 添加日志
				String info = "用户进行代理商客户管理查看操作";
				logsServiceImpl.addLogs(info);
			}
		}
		cusPage = customsServiceImpl.getPage(pageSize, current, name);
		return SUCCESS;
	}

	// 客户主键
	private Integer id;
	private Hat_province province;
	private String cityName;
	private String areaName;

	// 修改客户信息，显示客户资料
	// 查看客户信息
	public String modify_show() {
		customs = customsServiceImpl.findone(id);
		contacts = contactsServiceImpl.findList(id);
		// 省的实体类
		province = hatServiceImpl.pro(customs.getProvince());

		citys = hatServiceImpl.citys(customs.getProvince());
		areas = hatServiceImpl.areas(customs.getCity());
		// 根据customs.city在citys里找相关市名
		for (Hat_city city : citys) {
			if (city.getCityID().equals(customs.getCity())) {
				cityName = city.getCity();
			}

		}
		// 根据customs.area在areas里找相关区名
		for (Hat_area area : areas) {
			if (area.getAreaID().equals(customs.getArea())) {
				areaName = area.getArea();
			}
		}
		return SUCCESS;
	}

	// 修改客户信息
	public String modify() {
		try {
			customs.setId(id);
			customsServiceImpl.modifyCus(customs);
			if(contacts!=null){
				for (Contacts c : contacts) {
					c.setCustomId(id);
					if (c.getId() != null) {
						contactsServiceImpl.modifyContacts(c);
						// 修改
					} else {
						contactsServiceImpl.addContacts(c);
						// 添加
					}
				}
			}
			// 添加日志
			String info = "用户修改客户信息操作";
			logsServiceImpl.addLogs(info);
			return SUCCESS;
		} catch (RuntimeException r) {
			r.printStackTrace();
			return INPUT;
		}
	}

	// 市
	private List<Hat_city> citys;
	// 区
	private List<Hat_area> areas;
	private String provinceId;
	private String cityID;

	// 找市
	public String findcity() {

		citys = hatServiceImpl.citys(provinceId);
		return SUCCESS;
	}

	// 找区
	public String findarea() {
		areas = hatServiceImpl.areas(cityID);
		return SUCCESS;
	}

	private Map<String, String> msg = new HashMap<>();

	// 删除一条联系人
	public String delete_contact() {
		try {
			contactsServiceImpl.deleteContact(id);
			System.out.println("success");
			msg.put("msg", "SUCCESS");
		} catch (RuntimeException r) {
			r.printStackTrace();
			msg.put("msg", "fail");
		}
		return SUCCESS;
	}

	// 开启or关闭
	private String status;

	// 状态开启关闭
	public String state() {
		try {
			customsServiceImpl.state(id, status);
			msg.put("msg", "SUCCESS");
		} catch (RuntimeException r) {
			r.printStackTrace();
			msg.put("msg", "fail");
		}
		return SUCCESS;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Map<String, String> getMsg() {
		return msg;
	}

	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Page getCusPage() {
		return cusPage;
	}

	public void setCusPage(Page cusPage) {
		this.cusPage = cusPage;
	}

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Hat_province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Hat_province> provinces) {
		this.provinces = provinces;
	}

	public List<Hat_city> getCitys() {
		return citys;
	}

	public void setCitys(List<Hat_city> citys) {
		this.citys = citys;
	}

	public List<Hat_area> getAreas() {
		return areas;
	}

	public void setAreas(List<Hat_area> areas) {
		this.areas = areas;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	public List<Systemconfig> getCustomTypes() {
		return customTypes;
	}

	public void setCustomTypes(List<Systemconfig> customTypes) {
		this.customTypes = customTypes;
	}

	public List<Systemconfig> getCardTypes() {
		return cardTypes;
	}

	public void setCardTypes(List<Systemconfig> cardTypes) {
		this.cardTypes = cardTypes;
	}

	public Customs getCustoms() {
		return customs;
	}

	public void setCustoms(Customs customs) {
		this.customs = customs;
	}

	public List<Contacts> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Hat_province getProvince() {
		return province;
	}

	public void setProvince(Hat_province province) {
		this.province = province;
	}

}
