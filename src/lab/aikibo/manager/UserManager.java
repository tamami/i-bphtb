package lab.aikibo.manager;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.zkoss.zk.ui.util.Clients;

import lab.aikibo.entity.DatLogin;
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
			@SuppressWarnings("rawtypes")
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
			
			@SuppressWarnings("rawtypes")
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
	
			@SuppressWarnings("rawtypes")
			Iterator iterator = query.iterate();
			
			nip = (String) iterator.next();
			return nip;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<DatLogin> getListUser() {
		List<DatLogin> list;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		list = session.createQuery("from DatLogin").list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getListUserInString() {
		List<String> result;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "select nmLogin from DatLogin";
		Query query = session.createQuery(sql);
		result = query.list();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public DatLogin getUserByNip(String nip) {
		List<DatLogin> list;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(DatLogin.class);
		criteria.add(Restrictions.eq("nip", nip));
		list = criteria.list();
		if(list != null) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	public void saveOrUpdate(DatLogin user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(user);
		Transaction tx = session.beginTransaction();
		tx.commit();
	}

}
