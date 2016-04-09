package lab.aikibo.manager;

import java.util.List;

import org.hibernate.Session;

import lab.aikibo.entity.RefJenisPeralihan;
import lab.aikibo.hibernate.HibernateUtil;

public class JenisPeralihanManager {
	
	@SuppressWarnings("unchecked")
	public List<RefJenisPeralihan> getAllData() {
		Session session = HibernateUtil.getSessionPostgres().getCurrentSession();
		return (List<RefJenisPeralihan>) session.createQuery("from RefJenisPeralihan").list();
	}

}
