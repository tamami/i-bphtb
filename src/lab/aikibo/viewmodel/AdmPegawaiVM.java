package lab.aikibo.viewmodel;

import java.util.List;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.util.Clients;

import lab.aikibo.entity.Pegawai;
import lab.aikibo.manager.PegawaiManager;

public class AdmPegawaiVM {
	
	private Pegawai currentPegawai;
	private List<Pegawai> daftarPegawai;
	private PegawaiManager pm;
	
	@Init
	public void init() {
		pm = new PegawaiManager();
		daftarPegawai = pm.getListPegawai();
	}

	// --- setter and getter
	
	public Pegawai getCurrentPegawai() {
		return currentPegawai;
	}

	public void setCurrentPegawai(Pegawai currentPegawai) {
		this.currentPegawai = currentPegawai;
		if(pm.isAnyNip(currentPegawai.getNip())) {
			Clients.showNotification("Data NIP : " + currentPegawai.getNip() + " sudah ada, ingin di ubah?");
		}
			
	}

	public List<Pegawai> getDaftarPegawai() {
		return daftarPegawai;
	}

	public void setDaftarPegawai(List<Pegawai> daftarPegawai) {
		this.daftarPegawai = daftarPegawai;
	}

	public PegawaiManager getPm() {
		return pm;
	}

	public void setPm(PegawaiManager pm) {
		this.pm = pm;
	}

}
