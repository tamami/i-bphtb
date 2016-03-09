package lab.aikibo.init;

import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;

import lab.aikibo.services.AuthenticationService;

public class AuthenticationInit implements org.zkoss.zk.ui.util.Initiator {
	
	// services
	AuthenticationService authService = new AuthenticationServiceImpl();

	@Override
	public void doInit(Page page, Map<String, Object> args) throws Exception {
		UserCredential cre = authService.getUserCredential();
		if(cre == null || cre.isAnonymous()) { 
			Executions.sendRedirect("/login.zul");
			return;
		}
	}

}
