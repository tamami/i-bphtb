package lab.aikibo.manager;

import java.util.List;

import org.hibernate.Session;

import lab.aikibo.entity.RefNpoptkp;
import lab.aikibo.hibernate.HibernateUtil;

public class NpoptkpManager {
	
	public List<RefNpoptkp> getListAll() {
		Session session = HibernateUtil.getSessionPostgres().getCurrentSession();
		session.beginTransaction();
		return null;
	}

}
