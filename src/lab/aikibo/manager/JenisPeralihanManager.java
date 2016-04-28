package lab.aikibo.manager;

import java.util.LinkedList;
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
	
	public List<String> getAllDataFormatted() {
		List<RefJenisPeralihan> rawData = getAllData();
		List<String> result = new LinkedList<String>();
		
		for(int i=0; i<rawData.size(); i++) {
			result.add(rawData.get(i).getKdJnsPeralihan() + ". " + rawData.get(i).getJnsPeralihan());
		}
		return result;
	}

}
