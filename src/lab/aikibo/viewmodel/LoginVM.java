package lab.aikibo.viewmodel;

import java.io.Serializable;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;

import lab.aikibo.services.AuthenticationService;
import lab.aikibo.services.AuthenticationServiceImpl;

public class LoginVM implements Serializable {

	private static final long serialVersionUID = 7413222797844363489L;
	
	// services
	private AuthenticationService authService = new AuthenticationServiceImpl();
	
	// data for the view
	private String username;
	private String password;
	
	// status fokus
	private boolean fokusUsername;
	private boolean fokusPassword;
	
	@Init
	public void init() {
		fokusUsername = true;
	}
	
	@Command
	public void login() {
		if(Strings.isBlank(username) || Strings.isBlank(password)) {
			Clients.showNotification("Silahkan isi nama pengguna dan kata kuncinya dulu.");
			return;
		} else {
			if(authService.login(username, password)) {
			// pengecualian: digunakan saat akan inisialisasi user saja
		    //if(authService.loginDummy(username, password)) {
				Executions.sendRedirect("/index.zul");
				Clients.showNotification("Selamat datang");
				return;
			} else {
				Clients.showNotification("Nama Pengguna belum terdaftar atau password salah");
				return;
			}
		}
	}
	
	// --- setter and getter

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isFokusUsername() {
		return fokusUsername;
	}

	public void setFokusUsername(boolean fokusUsername) {
		this.fokusUsername = fokusUsername;
	}

	public boolean isFokusPassword() {
		return fokusPassword;
	}

	public void setFokusPassword(boolean fokusPassword) {
		this.fokusPassword = fokusPassword;
	}

}
