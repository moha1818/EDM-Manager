package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import entity.Accountdetail;
import entity.Systemconfig;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.SystemconfigService;
import service.impl.AccountdetailServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller(value="accountdetailAction")
@Scope(scopeName="prototype")
public class AccountdetailAction extends ActionSupport implements Preparable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier(value="accountdetailServiceImpl")
	private AccountdetailServiceImpl detailServiceImpl;
	
	@Autowired
	@Qualifier(value = "systemconfigServiceImpl")
	private SystemconfigService configServiceImpl;

	private List<Accountdetail> detail;
	private int detailType;
	private Date starttime;
	private Date endtime;
	private List<Systemconfig> config;
	private int pageIndex = 1;
	private int pageSize = 10;
	private int totalPage;
	private int x;
	private int y;
	private int id;
	

	@Override
	public void prepare() throws Exception {
		
		List<Systemconfig> list = new ArrayList<Systemconfig>();
		Systemconfig sc1 = new Systemconfig();
		Systemconfig sc2 = new Systemconfig();
		Systemconfig sc3 = new Systemconfig();
		Systemconfig sc4 = new Systemconfig();
		sc1.setConfigTypeValue(9999);
		sc1.setConfigTypeName("系统自动—店铺申请扣款");
		sc2.setConfigTypeValue(9998);
		sc2.setConfigTypeName("系统自动—返回预店铺申请冻结资金");
		sc3.setConfigTypeValue(9997);
		sc3.setConfigTypeName("系统自动—扣除店铺申请的所有资金");
		sc4.setConfigTypeValue(9996);
		sc4.setConfigTypeName("系统自动—扣除店铺续费资金");
		list.add(sc1);
		list.add(sc2);
		list.add(sc3);
		list.add(sc4);
		config = list;
	}
	
		//查看账户明细
		public String showDetail(){
			
			Map<String,Object> session = ActionContext.getContext().getSession();
			User user = (User) session.get("user");		
				detail = detailServiceImpl.showDetail(user.getId(), pageIndex, pageSize, detailType, starttime, endtime);
				int total = detailServiceImpl.detailCount(user.getId(), detailType, starttime, endtime);
				totalPage = total%pageSize==0?(total/pageSize):(total/pageSize+1);
				
			return SUCCESS;
		}
	
	//代理商预付款
	public String prepay(){
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		System.out.println(id);
		if(id==0){
		User user = (User) session.get("user");		
			detail = detailServiceImpl.showDetail(user.getId(), pageIndex, pageSize, detailType, starttime, endtime);
			int total = detailServiceImpl.detailCount(user.getId(), detailType, starttime, endtime);
			totalPage = total%pageSize==0?(total/pageSize):(total/pageSize+1);
		}else{
			detail = detailServiceImpl.showDetail(id, pageIndex, pageSize, detailType, starttime, endtime);
			int total = detailServiceImpl.detailCount(id, detailType, starttime, endtime);
			totalPage = total%pageSize==0?(total/pageSize):(total/pageSize+1);
		}
		
		
		config.addAll(configServiceImpl.getConfig(1));
		
		return SUCCESS;
	}
	

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

	public List<Systemconfig> getConfig() {
		return config;
	}

	public void setConfig(List<Systemconfig> config) {
		this.config = config;
	}

	public int getDetailType() {
		return detailType;
	}

	public void setDetailType(int detailType) {
		this.detailType = detailType;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Accountdetail> getDetail() {
		return detail;
	}
	public void setDetail(List<Accountdetail> detail) {
		this.detail = detail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	


}
