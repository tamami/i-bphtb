package lab.aikibo.manager;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.zkoss.zk.ui.util.Clients;

import lab.aikibo.hibernate.HibernateUtil;

public class UserManager {
	
	public UserManager() {
		init();
	}
	
	public void init() {
		//Koneksi.init();
	}
	
	public boolean isAnyUser(String username) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "select nmLogin from DatLogin where nmLogin = :username";
		try {
			Query query = session.createQuery(sql);
			query.setString("username", username);
			Iterator iterator = query.iterate();
			while(iterator.hasNext()) {
				String user = (String) iterator.next();
				if(user.equalsIgnoreCase(username)) {
					return true;
				}
			}
			return false;
		} catch(Exception e) {
			Clients.showNotification("Ada kesalahan sistem, hubungi Admin.");
			e.printStackTrace();
			return false;
		}
	}
	
	public String getPassword(String username) {
		String password;
		if(isAnyUser(username)) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String sql = "select password from DatLogin where nmLogin = :username";
			Query query = session.createQuery(sql);
			query.setString("username", username);
			Iterator iterator = query.iterate();
			password = (String) iterator.next();
			return password;
		} else {
			return null;
		}
	}
	
	public String getNip(String username) {
		String nip;
		if(isAnyUser(username)) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String sql = "select nip from DatLogin where nmLogin = :username";
			Query query = session.createQuery(sql);
			query.setString("username", username);
			Iterator iterator = query.iterate();
			nip = (String) iterator.next();
			return nip;
		} else {
			return null;
		}
	}
	
	public List<DatLogin> getListUser() {
		
	}

}
