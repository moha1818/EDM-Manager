package interceptot;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import entity.User;
import service.PremissionService;

public class AuthorizationInterceptor extends MethodFilterInterceptor {
	@Autowired
	@Qualifier(value = "premissionServiceImpl")
	private PremissionService premissionServiceImpl;
	
	@Override
	protected String doIntercept(ActionInvocation paramActionInvocation) throws Exception {
		Map session=paramActionInvocation.getInvocationContext().getSession();
		User user=(User) session.get("user");
		if(user!=null){
			System.out.println("author拦截器*******");
			System.out.println("action"+paramActionInvocation.getProxy().getActionName());
			if(premissionServiceImpl.authorization(user.getRoleId(), paramActionInvocation.getProxy().getActionName())){
				System.out.println("有权利访问该页面");
				return paramActionInvocation.invoke();
			}else{
				return Action.ERROR;
			}
		} else {
			System.out.println("拦截器，未登陆，返回登陆界面");
			return Action.LOGIN;
		}
	}


}
