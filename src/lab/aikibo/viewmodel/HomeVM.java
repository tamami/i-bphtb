package lab.aikibo.viewmodel;

import java.io.Serializable;

import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.zk.ui.Executions;

public class HomeVM implements Serializable {

	private static final long serialVersionUID = -7142599015378166649L;
	
	@GlobalCommand
	public void redirectToNewForm() {
		Executions.sendRedirect("/login.zul");
	}

}
