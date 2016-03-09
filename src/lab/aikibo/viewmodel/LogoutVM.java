package lab.aikibo.viewmodel;

import java.io.Serializable;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;

import lab.aikibo.services.AuthenticationService;
import lab.aikibo.services.AuthenticationServiceImpl;

public class LogoutVM implements Serializable {

	private static final long serialVersionUID = 1237229630780315389L;
	
	AuthenticationService authService = new AuthenticationServiceImpl();
	
	@Command
	public void logout() {
		authService.logout();
		Executions.sendRedirect("/");
	}

}
