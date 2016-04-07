package lab.aikibo.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab.aikibo.entity.RefAkses;
import lab.aikibo.hibernate.HibernateUtil;
import lab.aikibo.manager.AksesManager;

public class AksesManagerTest {
	
	private AksesManager am;
	private RefAkses result;
	
	@Before
	public void init() {
		am = new AksesManager();
		HibernateUtil.getSessionPostgres().getCurrentSession().beginTransaction();
		result = am.getAkses("ADMIN");
	}
	
	@Test
	public void resultNotNull() {
		assertNotNull(result);
	}
	
	@Test
	public void testNm() {
		System.out.println(result.getNmLogin());
		assertEquals("ADMIN", result.getNmLogin());
	}
	
	@Test
	public void testMnTrue() {
		System.out.println(result.isMnAdmJnsPeralihan());
		assertEquals(true, result.isMnAdmJnsPeralihan());
	}

}
