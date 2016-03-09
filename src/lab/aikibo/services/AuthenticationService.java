package lab.aikibo.services;

public interface AuthenticationService {
	
	/** login with any account -- just for init app */
	public boolean loginDummy(String nmLogin, String password);
	
	/** login with account and password */
	public boolean login(String nmLogin, String password);
	
	/** logout current user */
	public void logout();
	
	/** get current user credential */
	public UserCredential getUserCredential();

}
