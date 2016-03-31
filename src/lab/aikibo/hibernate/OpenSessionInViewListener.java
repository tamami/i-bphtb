package lab.aikibo.hibernate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.util.ExecutionCleanup;
import org.zkoss.zk.ui.util.ExecutionInit;

public class OpenSessionInViewListener implements ExecutionInit, ExecutionCleanup {
	
	private static final Logger log = LoggerFactory.getLogger(OpenSessionInViewListener.class);

	@Override
	public void cleanup(Execution exec, Execution parent, List<Throwable> errs) throws Exception {
		if(parent == null) {
			if(errs == null || errs.isEmpty()) {
				log.debug("Committing the database transaction: " + exec);
				//ini juga perlu disesuaikan untuk koneksi ke 2 db sekaligus
				HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
				HibernateUtil.getSessionOracle().getCurrentSession().getTransaction().commit();
				HibernateUtil.getSessionPostgres().getCurrentSession().getTransaction().commit();
			} else {
				final Throwable ex = (Throwable) errs.get(0);
				rollback(exec, ex);
			}
		}
	}

	@Override
	public void init(Execution exec, Execution parent) throws Exception {
		if(parent == null) {
			log.debug("Starting a database transaction: " + exec);
			//baris ini perlu disesuaikan untuk koneksi ke 2 db sekaligus
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			HibernateUtil.getSessionOracle().getCurrentSession().beginTransaction();
			HibernateUtil.getSessionPostgres().getCurrentSession().beginTransaction();
		}
	}
	
	// isinya perlu disesuaikan untuk koneksi ke 2 db sekaligus
	private void rollback(Execution exec, Throwable ex) {
		try {
			if(HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().isActive()) {
				log.debug("Trying to rollback database transaction after exception: " + ex);
				HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
				HibernateUtil.getSessionOracle().getCurrentSession().getTransaction().rollback();
				HibernateUtil.getSessionPostgres().getCurrentSession().getTransaction().rollback();
			}
		} catch(Throwable rbEx) {
			log.error("Could not rollback transaction after exception! Original Exception:\n" + ex, rbEx);
		}
	}

}
