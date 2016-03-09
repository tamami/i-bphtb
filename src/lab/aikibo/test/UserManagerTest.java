package lab.aikibo.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import lab.aikibo.entity.DatLogin;
import lab.aikibo.manager.UserManager;

public class UserManagerTest {
	
	private UserManager um;
	private List<String> data;
	private List<DatLogin> dataLogin;
	
	@Before
	public void init() {
		um = new UserManager();
		
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

}
