package lab.aikibo.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.zkoss.zats.mimic.ComponentAgent;
import org.zkoss.zats.mimic.DesktopAgent;
import org.zkoss.zats.mimic.Zats;
import org.zkoss.zul.Listbox;

public class AdmUserZulTest {
	
	@BeforeClass
	public static void init() {
		Zats.init("./WebContent");
	}
	
	@AfterClass
	public static void end() {
		Zats.end();
	}
	
	@After
	public void after() {
		Zats.cleanup();
	}
	
	@Test
	public void testListUser() {
		DesktopAgent desktop = Zats.newClient().connect("/form/adm_user.zul");
		
		ComponentAgent listbox = desktop.query("listbox");
		Assert.assertEquals(1, listbox.as(Listbox.class).getItemCount());
	}

}
