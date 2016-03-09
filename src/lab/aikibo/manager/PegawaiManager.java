package lab.aikibo.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import lab.aikibo.entity.Pegawai;
import lab.aikibo.hibernate.HibernateUtil;

public class PegawaiManager {
	
	public String getNamaByNipLama(String nip) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Pegawai.class);
		criteria.add(Restrictions.eq("nip", nip));
		List<Pegawai> data = criteria.list();
		if(data.size() == 1) return data.get(0).getNmPegawai();
		else return "";
	}

}
