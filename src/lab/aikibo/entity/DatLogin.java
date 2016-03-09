package lab.aikibo.entity;

import java.io.Serializable;

public class DatLogin implements Serializable {

	private static final long serialVersionUID = -5502041416923256850L;
	private String nmLogin;
	private String password;
	private String nip;
	
	public DatLogin() {}
	
	public DatLogin(String nmLogin, String nip, String password) {
		this.nmLogin = nmLogin;
		this.password = password;
		this.nip = nip;
	}
	
	// --- setter and getter
	
	public String getNmLogin() {
		return nmLogin;
	}
	public void setNmLogin(String nmLogin) {
		this.nmLogin = nmLogin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}

}
