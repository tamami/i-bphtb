package lab.aikibo.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import lab.aikibo.entity.DatLogin;
import lab.aikibo.hibernate.HibernateUtil;
import lab.aikibo.hibernate.OpenSessionInViewListener;
import lab.aikibo.manager.UserManager;

public class UserManagerTest {
	
	private UserManager um;
	private List<String> data;
	private List<DatLogin> dataLogin;
	
	@Before
	public void init() {
		um = new UserManager();
		HibernateUtil.getSessionPostgres().getCurrentSession().beginTransaction();
	}
	
	@Test
	public void testJumlahListUser() {
		dataLogin = um.getListUser();
		assertEquals(1, dataLogin.size());
	}
	
	@Test
	public void testJumlahListUserString() {
		data = um.getListUserInString();
		assertEquals(1, data.size());
	}
	
	@After
	public void finish() {
		HibernateUtil.getSessionPostgres().getCurrentSession().close();
	}

}
