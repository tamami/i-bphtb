package lab.aikibo.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

import lab.aikibo.entity.RefAkses;
import lab.aikibo.hibernate.HibernateUtil;
import lab.aikibo.services.UserCredential;

public class AksesManager {
	
	@SuppressWarnings("unchecked")
	public RefAkses getAkses(String user) {
		org.hibernate.Session sessHb = HibernateUtil.getSessionPostgres().getCurrentSession();
		sessHb.beginTransaction();
		Criteria criteria = sessHb.createCriteria(RefAkses.class);
		criteria.add(Restrictions.eq("nmLogin", user));
		List<RefAkses> dataRefAkses = (List<RefAkses>)criteria.list();
		if(dataRefAkses.size() == 1) return dataRefAkses.get(0);
		else return null;
	}

}
