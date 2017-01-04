package action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import service.impl.KeywordsServiceImpl;

@Controller(value = "keywordsCheckAction")
@Scope(scopeName = "prototype")
public class KeywordsCheckAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier(value="keywordsServiceImpl")
	private KeywordsServiceImpl keywordsServiceImpl;
	
	private String value;
	private String keyname;
	private Map<String, String> msg = new HashMap<>();
	
	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	public Map<String, String> getMsg() {
		return msg;
	}

	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}
	
	//弹出提示
	public String msgOut(){
		if(value.equals("6")){
			msg.put("msg1", "您确定要修改【"+keyname+"】的使用状态为不使用吗");
			return SUCCESS;
		}
		if(value.equals("1")){
			keywordsServiceImpl.updateUse(1, keyname);
			msg.put("msg1", "您确定要修改【"+keyname+"】的使用状态为已使用吗");
			return SUCCESS;
		}
		if(value.equals("2")){
			keywordsServiceImpl.updateStatus(1, keyname);
			msg.put("msg1", "您确定要修改【"+keyname+"】的审核状态为审核中吗");
			return SUCCESS;
		}
		if(value.equals("3")){
			keywordsServiceImpl.updateStatus(2, keyname);
			msg.put("msg1", "您确定要修改【"+keyname+"】的审核状态为审核通过吗");
			return SUCCESS;
		}
		if(value.equals("4")){
			keywordsServiceImpl.updateStatus(3, keyname);
			msg.put("msg1", "您确定要修改【"+keyname+"】的审核状态为不通过吗");
			return SUCCESS;
		}

		return INPUT;
	}
	
	//关键词审核操作
	public String check(){
		
		if(value.equals("6")){
			keywordsServiceImpl.updateUse(0, keyname);
			msg.put("msg2", "恭喜您，【"+keyname+"】状态修改为不使用，操作成功");
			return SUCCESS;
		}
		if(value.equals("1")){
			keywordsServiceImpl.updateUse(1, keyname);
			msg.put("msg2", "恭喜您，【"+keyname+"】状态修改为已使用，操作成功");
			return SUCCESS;
		}
		if(value.equals("2")){
			keywordsServiceImpl.updateStatus(1, keyname);
			msg.put("msg2", "恭喜您，【"+keyname+"】状态修改为审核中，操作成功");
			return SUCCESS;
		}
		if(value.equals("3")){
			keywordsServiceImpl.updateStatus(2, keyname);
			msg.put("msg2", "恭喜您，【"+keyname+"】状态修改为审核通过，操作成功");
			return SUCCESS;
		}
		if(value.equals("4")){
			keywordsServiceImpl.updateStatus(3, keyname);
			msg.put("msg2", "恭喜您，【"+keyname+"】状态修改为不通过，操作成功");
			return SUCCESS;
		}

		return INPUT;
	}
}
