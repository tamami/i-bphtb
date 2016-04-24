package lab.aikibo.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/* Jika berhubungan dengan 2 database maka perlu 2 sessionFactory */
public class HibernateUtil {
	
	private static SessionFactory sessionFactory; // hanya dipake untuk uji coba
	private static SessionFactory sessionOracle;
	private static SessionFactory sessionPostgres;
	
	static {
		try {
			//sessionFactory = new Configuration().configure().buildSessionFactory();
			sessionOracle = new Configuration().configure("oracleconfig.cfg.xml").buildSessionFactory();
			sessionPostgres = new Configuration().configure("postgresconfig.cfg.xml").buildSessionFactory();
		} catch(Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	
	// hanya digunakan untuk uji coba
	//public static SessionFactory getSessionFactory() {
	//	return sessionFactory;
	//}
	
	
	public static SessionFactory getSessionOracle() {
	  return sessionOracle;
	}
	
	public static SessionFactory getSessionPostgres() {
	  return sessionPostgres;
	}
	
}
