package lab.aikibo.viewmodel;

import java.io.Serializable;

import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Include;

public class GlobalController extends SelectorComposer<Component> 
		implements Serializable {

	private static final long serialVersionUID = 8754435502342583134L;
	
	@Init
	public void init() {}
	
	@GlobalCommand
	public void close() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("");
	}
	
	@GlobalCommand
	public void updateView() {
		Clients.showNotification("Nama page-nya : " + getPage().getRequestPath());
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/timeout.zul");
		Clients.showNotification("login.zul sudah dipanggil");
	}
	
	@GlobalCommand
	public void callAdmUser() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/adm_user.zul");
	}
	
	@GlobalCommand
	public void callAdmPegawai() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/adm_pegawai.zul");
	}
	
	@GlobalCommand
	public void callAdmPpat() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/adm_ppat.zul");
	}
	
	@GlobalCommand
	public void callAdmJnsPeralihan() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/adm_jns_peralihan.zul");
	}
	
	@GlobalCommand
	public void callAdmNpoptkp() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/adm_npoptkp.zul");
	}
	
	@GlobalCommand
	public void callAdmStatusBerkas() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/adm_status_berkas.zul");
	}
	
	@GlobalCommand
	public void callPengaturanMenu() {
		Include include = (Include) Selectors.iterable(getPage(),  "#mainInclude").iterator().next();
		include.setSrc("/form/adm_atur_menu.zul");
	}

}
