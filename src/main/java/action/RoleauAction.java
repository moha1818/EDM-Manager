package action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import entity.Role;
import service.RolemaService;

@Controller(value = "roleauAction")
@Scope(scopeName = "prototype")
public class RoleauAction extends ActionSupport{
	@Autowired
	@Qualifier(value = "rolemaServiceImpl")
	public RolemaService rolemaService;

	public void setRolemaService(RolemaService rolemaService) {
		this.rolemaService = rolemaService;
	}
	
	public List<Role> rolemalist;

	public List<Role> getRolemalist() {
		return rolemalist;
	}

	public void setRolemalist(List<Role> rolemalist) {
		this.rolemalist = rolemalist;
	}
	public String roleau(){
		this.rolemalist=rolemaService.list();
		return SUCCESS;
	}
}
