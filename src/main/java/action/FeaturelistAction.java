package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Function;
import entity.Role_premission;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.FeaturelistService;

import java.util.List;
import java.util.Map;

@Controller(value = "featurelistAction")
@Scope(scopeName = "prototype")
public class FeaturelistAction extends ActionSupport{
	@Autowired
	@Qualifier(value = "featurelistServiceImpl")
	public FeaturelistService featurelistService;
	
	public void setFeaturelistService(FeaturelistService featurelistService) {
		this.featurelistService = featurelistService;
	}
	
	public List<Function> featurelist;
	public List<Integer> permission;
	public Role_premission role_premission =new Role_premission();
	public Integer roleid;
	public List<Integer> role_premissions;

	public List<Integer> getRole_premissions() {
		return role_premissions;
	}

	public void setRole_premissions(List<Integer> role_premissions) {
		this.role_premissions = role_premissions;
	}

	public Role_premission getRole_premission() {
		return role_premission;
	}

	public void setRole_premission(Role_premission role_premission) {
		this.role_premission = role_premission;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public List<Integer> getPermission() {
		return permission;
	}

	public void setPermission(List<Integer> permission) {
		this.permission = permission;
	}

	public List<Function> getFeaturelist() {
		return featurelist;
	}

	public void setFeaturelist(List<Function> featurelist) {
		this.featurelist = featurelist;
	}
	public String featurelist(){
		System.out.println("featurelist  roleid:"+roleid);
		this.role_premissions =featurelistService.role_premissions(roleid);
		
		
		System.out.println(role_premissions.size());
		this.featurelist=featurelistService.list();
		return SUCCESS;
	}
	public String permission(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		featurelistService.updatePremission(roleid,permission,user);
		return SUCCESS;
	}
}
