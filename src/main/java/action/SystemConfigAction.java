package action;

import com.opensymphony.xwork2.ActionSupport;
import model.Page;
import entity.Systemconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.LogsService;
import service.SystemconfigService;

import java.util.List;

@Controller(value = "SystemConfigAction")
@Scope(scopeName = "prototype")
public class SystemConfigAction extends ActionSupport {
	@Autowired
	@Qualifier(value = "systemconfigServiceImpl")
	private SystemconfigService systemconfigServiceImpl;
	@Autowired
	@Qualifier(value = "logsServiceImpl")
	private LogsService logsServiceImpl;
	private Integer id; // 主键
	private Integer configType; // 配置类型（ 1、财务类型 2、服务类型 3、服务年限 4、 APP 地址 5、客户类型
								// 6、证件类型 7、优惠类型）
	private String configTypeName; // 具体配置类型的配置参数 name
	private Integer configTypeValue; // 具体配置类型的配置参数 id
	private String configValue; // 具体配置类型的配置参数对应的 value（服务年限、
								// APP地址、服务类型、优惠类型会用到这个字段）
	private Integer isStart; // 是否启用（ 1、启用 0、 未启用）
	private String msg = null;
	private Page syscfgcusPage;// 页
	private Integer syscfgcurrent;// 页数
	private Systemconfig systemconfig;
	private List<Systemconfig> list;
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public List<Systemconfig> getList() {
		return list;
	}
	public void setList(List<Systemconfig> list) {
		this.list = list;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getConfigType() {
		return configType;
	}
	public void setConfigType(Integer configType) {
		this.configType = configType;
	}
	public String getConfigTypeName() {
		return configTypeName;
	}
	public void setConfigTypeName(String configTypeName) {
		this.configTypeName = configTypeName;
	}
	public Integer getConfigTypeValue() {
		return configTypeValue;
	}
	public void setConfigTypeValue(Integer configTypeValue) {
		this.configTypeValue = configTypeValue;
	}
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	public Integer getIsStart() {
		return isStart;
	}
	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Page getSyscfgcusPage() {
		return syscfgcusPage;
	}
	public void setSyscfgcusPage(Page syscfgcusPage) {
		this.syscfgcusPage = syscfgcusPage;
	}
	public Integer getSyscfgcurrent() {
		return syscfgcurrent;
	}
	public void setSyscfgcurrent(Integer syscfgcurrent) {
		this.syscfgcurrent = syscfgcurrent;
	}
	public Systemconfig getSystemconfig() {
		return systemconfig;
	}
	public void setSystemconfig(Systemconfig systemconfig) {
		this.systemconfig = systemconfig;
	}
	public String addSystemConfig() {
		Systemconfig scg = new Systemconfig();
		scg.setConfigType(configType);
		scg.setConfigTypeName(configTypeName);
		scg.setConfigTypeValue(configTypeValue);
		scg.setConfigValue(configValue);
		scg.setIsStart(isStart);
		try {
			systemconfigServiceImpl.addSystemconfig(scg);
		}catch (RuntimeException r) {
			r.printStackTrace();
		
			if (configType == 1) {
				msg = "添加失败";
				String info = "用户添加财务类型失败";
				logsServiceImpl.addLogs(info);
				return "configType1";
			} else if (configType == 2) {
				msg = "添加失败";
				String info = "用户添加店铺类型失败";
				logsServiceImpl.addLogs(info);
				return "configType2";
			} else if (configType == 5) {
				msg = "添加失败";
				String info = "用户添加企业类型失败";
				logsServiceImpl.addLogs(info);
				return "configType5";
			} else if (configType == 6) {
				msg = "添加失败";
				String info = "用户添加证件类型操作失败";
				logsServiceImpl.addLogs(info);
				return "configType6";
			} else if (configType == 7) {
				msg = "添加失败";
				String info = "用户添加优惠类型失败";
				logsServiceImpl.addLogs(info);
				return "configType7";
			} else {
				msg = "添加错误";
				String info = "用户添加系统配置失败";
				logsServiceImpl.addLogs(info);
				return INPUT;
			}
		}
		if (configType == 1) {
			msg = "添加成功";
			String info = "用户成功添加财务类型操作";
			logsServiceImpl.addLogs(info);
			return "configType1";
		} else if (configType == 2) {
			msg = "添加成功";
			String info = "用户成功添加店铺类型操作";
			logsServiceImpl.addLogs(info);
			return "configType2";
		} else if (configType == 5) {
			msg = "添加成功";
			String info = "用户成功添加企业类型操作";
			logsServiceImpl.addLogs(info);
			return "configType5";
		} else if (configType == 6) {
			msg = "添加成功";
			String info = "用户成功添加证件类型操作";
			logsServiceImpl.addLogs(info);
			return "configType6";
		} else if (configType == 7) {
			msg = "添加成功";
			String info = "用户成功添加优惠类型操作";
			logsServiceImpl.addLogs(info);
			return "configType7";
		} else {
			msg = "添加错误";
			String info = "用户添加系统配置失败";
			logsServiceImpl.addLogs(info);
			return INPUT;
		}
	}
	public String show1() {
		if (syscfgcurrent == null) {
			syscfgcurrent = 1;
		}
		int pageSize = 10;
		syscfgcusPage = systemconfigServiceImpl.getPage(pageSize, syscfgcurrent, configType);
		return SUCCESS;
	}
	
	public String show2() {
		list=systemconfigServiceImpl.getConfig(configType);
		return SUCCESS;
	}

	public String deleteSystemConfig() {
		systemconfigServiceImpl.delete(id);
		if (configType == 1) {
			msg = "删除成功";
			String info = "用户删除财务类型操作";
			logsServiceImpl.addLogs(info);
			return "configType1";
		} else if (configType == 2) {
			msg = "删除成功";
			String info = "用户删除店铺类型操作";
			logsServiceImpl.addLogs(info);
			return "configType2";
		} else if (configType == 5) {
			msg = "删除成功";
			String info = "用户删除证件类型操作";
			logsServiceImpl.addLogs(info);
			return "configType5";
		} else if (configType == 6) {
			msg = "删除成功";
			String info = "用户删除企业类型操作";
			logsServiceImpl.addLogs(info);
			return "configType6";
		} else if (configType == 7) {
			msg = "删除成功";
			String info = "用户删除优惠类型操作";
			logsServiceImpl.addLogs(info);
			return "configType7";
		} else {
			return "";
		}
	}

	public String showSTOrAA() {
		List<?> list = systemconfigServiceImpl.getConfig(configType);
		systemconfig = (Systemconfig) list.get(0);
		configType = systemconfig.getConfigType();
		configTypeName = systemconfig.getConfigTypeName();
		configTypeValue = systemconfig.getConfigTypeValue();
		configValue = systemconfig.getConfigValue();
		id = systemconfig.getId();
		isStart = systemconfig.getIsStart();
		return SUCCESS;
	}
	
	// 展示某个系统配置根据Id
	public String showSystemConfig() {
		systemconfig= systemconfigServiceImpl.findByID(id);
		configType = systemconfig.getConfigType();
		if (configType == 1) {
			String info = "用户浏览财务类型配置";
			logsServiceImpl.addLogs(info);
		} else if (configType == 2) {
			String info = "用户浏览店铺类型配置";
			logsServiceImpl.addLogs(info);
		} else if (configType == 5) {
			String info = "用户浏览企业类型配置";
			logsServiceImpl.addLogs(info);
		} else if (configType == 6) {
			String info = "用户浏览证件类型配置";
			logsServiceImpl.addLogs(info);
		} else if (configType == 7) {
			String info = "用户浏览优惠类型配置";
			logsServiceImpl.addLogs(info);
		} else {
			return INPUT;
		}
		return SUCCESS;
	}

	// 更新配置
	public String updateSystemconfig() {
		Systemconfig s = new Systemconfig();
		s.setConfigType(configType);
		s.setConfigTypeName(configTypeName);
		s.setConfigTypeValue(configTypeValue);
		s.setConfigValue(configValue);
		s.setId(id);
		s.setIsStart(isStart);
		try {
			systemconfigServiceImpl.update(s);
		} catch (RuntimeException r) {
			r.printStackTrace();
			if (configType == 3) {
				String info = "用户更新租赁年限失败";
				logsServiceImpl.addLogs(info);
				msg = "更新失败";
				return "configType3";
			} else if (configType == 4) {
				String info = "用户更新app地址失败";
				logsServiceImpl.addLogs(info);
				msg = "更新失败";
				return "configType4";
			} else if (configType == 1) {
				String info = "用户更新财务类型失败";
				logsServiceImpl.addLogs(info);
				msg = "更新失败";
				return "configType1";
			} else if (configType == 2) {
				String info = "用户更新企业类型失败";
				logsServiceImpl.addLogs(info);
				msg = "更新失败";
				return "configType2";
			} else if (configType == 5) {
				String info = "用户更新企业类型失败";
				logsServiceImpl.addLogs(info);
				msg = "更新失败";
				return "configType5";
			} else if (configType == 6) {
				String info = "用户更新证件类型失败";
				logsServiceImpl.addLogs(info);
				msg = "更新失败";
				return "configType6";
			} else if (configType == 7) {
				String info = "用户更新优惠类型失败";
				logsServiceImpl.addLogs(info);
				msg = "更新失败";
				return "configType7";
			} else {
				msg = "更新失败";
				String info = "用户更新系统配置失败";
				logsServiceImpl.addLogs(info);
				return ERROR;
			}
			}
		if (configType == 3) {
			String info = "用户更新企业租赁年限成功";
			logsServiceImpl.addLogs(info);
			msg = "更新成功";
			return "configType3";
		} else if (configType == 4) {
			String info = "用户更新app地址成功";
			logsServiceImpl.addLogs(info);
			msg = "更新成功";
			return "configType4";
		} else if (configType == 1) {
			String info = "用户更新财务类型成功";
			logsServiceImpl.addLogs(info);
			msg = "更新成功";
			return "configType1";
		} else if (configType == 2) {
			String info = "用户更新企业类型成功";
			logsServiceImpl.addLogs(info);
			msg = "更新成功";
			return "configType2";
		} else if (configType == 5) {
			String info = "用户更新企业类型成功";
			logsServiceImpl.addLogs(info);
			msg = "更新成功";
			return "configType5";
		} else if (configType == 6) {
			String info = "用户更新证件类型成功";
			logsServiceImpl.addLogs(info);
			msg = "更新成功";
			return "configType6";
		} else if (configType == 7) {
			String info = "用户更新优惠类型成功";
			logsServiceImpl.addLogs(info);
			msg = "更新成功";
			return "configType7";
		} else {
			msg = "更新失败";
			String info = "用户更新系统配置失败";
			logsServiceImpl.addLogs(info);
			return ERROR; 
		}
	}
}
