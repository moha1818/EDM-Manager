package action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Role;
import entity.User;
import service.RolemaService;

@Controller(value = "rolemaAction")
@Scope(scopeName = "prototype")
public class RolemaAction extends ActionSupport{

	@Autowired
	@Qualifier(value = "rolemaServiceImpl")
	public RolemaService rolemaService;

	public void setRolemaService(RolemaService rolemaService) {
		this.rolemaService = rolemaService;
	}

	public List<Role> rolemalist;
	public Role role = new Role();

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRolemalist() {
		return rolemalist;
	}

	public void setRolemalist(List<Role> rolemalist) {
		this.rolemalist = rolemalist;
	}

	private String roleName;
	private Integer isStart;
	private Integer id;
	private Map<String, Object> msg = new HashMap<>();
	
	
	public Map<String, Object> getMsg() {
		return msg;
	}

	public void setMsg(Map<String, Object> msg) {
		this.msg = msg;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getIsStart() {
		return isStart;
	}

	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}
	
	//查询所有角色
	public String rolema() {

		this.rolemalist = rolemaService.list();
		return "success";

	}
	//增加角色
	public String addRole() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		try {
			role.setCreatedBy(user.getUserCode());
			role.setCreationTime(new Date());
			role.setLastUpdateTime(new Date());
			role.setIsStart(isStart);
			role.setRoleName(roleName);
			rolemaService.addRole(role);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}	
	}
	//修改角色
	public String modifyRole(){
		role.setIsStart(isStart);
		role.setRoleName(roleName);
		role.setId(id);
		rolemaService.modifyRole(role);
		return SUCCESS;
	}
	
	//删除角色
	public String delRole(){
		role.setId(id);
		rolemaService.delRole(role.getId());
		return SUCCESS;
	}
	
	//单个角色
	public String selectRole(){
		try {
			Role role=rolemaService.selectRole(id);
			msg.put("role", role);
		} catch (Exception e) {
			msg.put("info","error");
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
}
