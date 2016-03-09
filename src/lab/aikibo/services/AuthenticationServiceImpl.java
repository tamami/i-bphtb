package lab.aikibo.services;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Clients;

public class AuthenticationServiceImpl implements AuthenticationService, Serializable {

	private static final long serialVersionUID = -1845014252906733747L;
	private UserManager userManager;
	
	public AuthenticationServiceImpl() {
		init();
	}
	
	public void init() {
		userManager = new UserManager();
	}

	@Override
	public boolean loginDummy(String nmLogin, String password) {
		Session session = Sessions.getCurrent();
		UserCredential cre = new UserCredential(nmLogin, "060000000");
		session.setAttribute("userCredential", cre);
		return true;
	}

	@Override
	public boolean login(String nmLogin, String password) {
		String pwd;
		
		if(userManager.isAnyUser(nmLogin)) {
			pwd = userManager.getPassword(nmLogin);
			try {
				if(pwd == null) {
					Clients.showNotification("Password belum terpasang, hubungi Administrator");
					return false;
				} else {
					try {
						if(pwd.equals(Encrypt.getEncrypted2(password))) {
							Session session = Sessions.getCurrent();
							UserCredential cre = new UserCredential(nmLogin, userManager.getNip(nmLogin));
							session.setAttribute("userCredential", cre);
							Clients.showNotification("Selamat datang " + cre.getNama());
							return true;
						} else {
							// gagal login karna salah password
							return false;
						}
					} catch(InvalidKeyException e) {
						Clients.showNotification("Maaf, ada kesalahan Key enkripsi, \n" +
					      "anda tidak dapat masuk ke sistem, hubungi Developer!");
						return false;
					} catch (UnsupportedEncodingException e) {
						Clients.showNotification("Maaf, sistem peng-kode-an tidak didukung, \n" + 
								"anda tidak dapat masuk ke sistem, hubungi developer!");
						return false;
					} catch (NoSuchPaddingException e) {
						Clients.showNotification("Maaf, padding tidak ditemukan, \n" + 
								"anda tidak dapat masuk ke sistem, hubungi developer!");
						return false;
					} catch (InvalidAlgorithmParameterException e) {
						Clients.showNotification("Maaf, parameter algoritma enkripsi salah, \n" + 
								"anda tidak dapat masuk ke sistem, hubungi developer!");
						return false;
					} catch (IllegalBlockSizeException e) {
						Clients.showNotification("Maaf, ukuran blok enkripsi salah, \n" + 
								"anda tidak dapat masuk ke sistem, hubungi developer!");
						return false;
					} catch (BadPaddingException e) {
						Clients.showNotification("Maaf, ada kesalahan padding, \n" + 
								"anda tidak dapat masuk ke sistem, hubungi developer!");
						return false;
					}  
				}
			} catch(java.security.NoSuchAlgorithmException e) {
				Clients.showNotification("Algoritma Enkripsi salah, hubungi developer.");
				return false;
			}
		}
		
		Clients.showNotification("Nama anda belum terdaftar dalam sistem, hubungi Administrator DPPK");
		return false;
	}

	@Override
	public void logout() {
		Session session = Sessions.getCurrent();
		session.removeAttribute("userCredential");
	}

	@Override
	public UserCredential getUserCredential() {
		Session session = Sessions.getCurrent();
		UserCredential cre = (UserCredential) session.getAttribute("userCredential");
		if(cre == null) {
			cre = new UserCredential();
			session.setAttribute("userCredential", cre);
		}
		return cre;
	}
	
	

}
