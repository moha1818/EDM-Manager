package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Role;
import entity.User;
import model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.RolemaService;
import service.UsermaService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "usermaAction")
@Scope(scopeName = "prototype")
public class UsermaAction extends ActionSupport{
	@Autowired
	@Qualifier(value = "rolemaServiceImpl")
	public RolemaService rolemaService;
	
	@Autowired
	@Qualifier(value = "usermaServiceImpl")
	public UsermaService usermaService;
	
	public void setUsermaService(UsermaService usermaService) {
		this.usermaService = usermaService;
	}
	
	public void setRolemaService(RolemaService rolemaService) {
		this.rolemaService = rolemaService;
	}
	
	public List<Role> rolemalist;
	public List<User> userlist;
	public User users=new User();
	public Role role=new Role();
	public Page page = new Page();
	public String userCode;
	public String userName;
	public String userPassword;
	public Integer isStart;
	public Integer roleid;
	public Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getIsStart() {
		return isStart;
	}

	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public List<Role> getRolemalist() {
		return rolemalist;
	}

	public void setRolemalist(List<Role> rolemalist) {
		this.rolemalist = rolemalist;
	}
	private Map<String, Object> msg = new HashMap<>();
	
	
	public Map<String, Object> getMsg() {
		return msg;
	}

	public void setMsg(Map<String, Object> msg) {
		this.msg = msg;
	}

	public String userma(){
		int pageIndex;
		if(userName==null||userName.equals("")){
			userName=null;
		}
		System.out.println(userName);
		if(roleid==null){
			roleid=0;
		}
		if(isStart==null ||isStart==2 ){
			isStart=2;
		}
		if (page.getPageIndex()==0) {
			page.setPageIndex(1);
		}
		pageIndex = page.getPageIndex();
		page.setPageSize(10);
		this.userlist=usermaService.userlist(page.getPageIndex(),page.getPageSize(),userName,roleid,isStart);
		page.setList(userlist);
		page.setTotalCount(usermaService.num(userName, roleid, isStart));
		this.rolemalist=rolemaService.list();
		return SUCCESS;
	}
	public String addUser(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		try {
			users.setUserCode(userCode);
			users.setUserName(userName);
			users.setUserPassword(userPassword);
			users.setCreationTime(new Date());
			users.setLastLoginTime(new Date());
			users.setLastUpdateTime(new Date());
			role.setId(roleid);
			users.setRole(role);
			users.setIsStart(isStart);
			users.setCreatedBy(user.getUserCode());
			//账户默认启示资金
			Double money=(double) 10000;
			usermaService.addUser(users,money);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}
	public String updateUser(){
		try {
			users.setId(id);
			users.setUserCode(userCode);
			users.setUserName(userName);
			users.setUserPassword(userPassword);
			users.setLastUpdateTime(new Date());
			role.setId(roleid);
			users.setRole(role);
			users.setIsStart(isStart);
			usermaService.modifyUser(users);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}
	public String selectUser(){
		try {
			User user=usermaService.user(id);
			msg.put("user", user);
		} catch (Exception e) {
			msg.put("info","error");
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String delUser(){
		
		usermaService.delUser(id);
		return SUCCESS;
	}


/*	public String usera(){
		users.setId(1);
		users.setUserCode("admin");
		users.setUserName("管理员");
		users.setUserPassword("123456");
		users.setLastUpdateTime(new Date());
		role.setId(1);
		users.setRole(role);
		users.setIsStart(1);
		usermaService.modifyUser(users);
		return SUCCESS;
	}*/
}
