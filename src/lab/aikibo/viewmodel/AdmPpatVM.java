package lab.aikibo.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Init;

import lab.aikibo.entity.Ppat;
import lab.aikibo.manager.PpatManager;

public class AdmPpatVM {
	
	private Ppat currentPpat;
	private List<Ppat> daftarPpat;
	private PpatManager pm;
	
	@Init
	public void init() {
		pm = new PpatManager();
		
		daftarPpat = pm.getList();
	}
	
	
	// --- setters and getters
	
	public Ppat getCurrentPpat() {
		return currentPpat;
	}
	
	public void setCurrentPpat(Ppat currentPpat) {
		this.currentPpat = currentPpat;
	}
	
	public List<Ppat> getDaftarPpat() {
		return daftarPpat;
	}
	
	public void setDaftarPpat(List<Ppat> daftarPpat) {
		this.daftarPpat = daftarPpat;
	}

}
