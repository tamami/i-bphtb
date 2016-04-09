package lab.aikibo.manager;

import java.util.List;

import org.hibernate.Session;

import lab.aikibo.entity.Ppat;
import lab.aikibo.hibernate.HibernateUtil;

public class PpatManager {
	
	public List<Ppat> getList() {
		Session session = HibernateUtil.getSessionPostgres().getCurrentSession();
		session.beginTransaction();
		List result = (List<Ppat>) session.createQuery("from Ppat").list();
		return result;
	}

}
