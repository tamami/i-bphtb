package lab.aikibo.test;



import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lab.aikibo.entity.RefNpoptkp;
import lab.aikibo.hibernate.HibernateUtil;
import lab.aikibo.manager.NpoptkpManager;

public class NpoptkpManagerTest {
	
	private NpoptkpManager nm;
	
	@Before
	public void before() {
		nm = new NpoptkpManager();
		//HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
	}
	
	@Test
	public void testData() {
		List<RefNpoptkp> result = nm.getListAll();
		org.junit.Assert.assertNotNull(result);
	}
	
	
	@After
	public void finish() {
		//HibernateUtil.getSessionFactory().getCurrentSession().close();
	}

}
