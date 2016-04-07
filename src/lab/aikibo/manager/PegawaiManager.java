package lab.aikibo.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import lab.aikibo.entity.Pegawai;
import lab.aikibo.hibernate.HibernateUtil;

public class PegawaiManager {
	
	public String getNamaByNipLama(String nip) {
		// pada saat pemanggilan session, maka perlu dituju apakah sessionOracle atau sessionPostgres
		//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Session session = HibernateUtil.getSessionPostgres().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Pegawai.class);
		criteria.add(Restrictions.eq("nip", nip));
		@SuppressWarnings("unchecked")
		List<Pegawai> data = criteria.list();
		if(data.size() == 1) return data.get(0).getNmPegawai();
		else return "";
	}
	
	public List<Pegawai> getListPegawai() {
		Session session = HibernateUtil.getSessionPostgres().getCurrentSession();
		session.beginTransaction();
		List<Pegawai> result = (List<Pegawai>) session.createQuery("from Pegawai").list();
		return result;
	}

}
