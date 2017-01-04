package interceptot;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import entity.User;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation paramActionInvocation) throws Exception {
		Map session=paramActionInvocation.getInvocationContext().getSession();
		User user=(User) session.get("user");
		if(user!=null){
			return paramActionInvocation.invoke();
		} else {
			System.out.println(paramActionInvocation.getAction());
			System.out.println("拦截器，未登陆，返回登陆界面");
			return Action.LOGIN;
		}
	}


}
