package lab.aikibo.viewmodel;

import org.zkoss.bind.annotation.Init;

public class MenuVM {
	
	private boolean konfigurasiMn;
	private boolean admUserMn;
	private boolean admPegawaiMn;
	
	@Init
	public void init() {
		setAllTrue();
	}
	
	// --- setter and getter
	
	private void setAllTrue() {
		setKonfigurasiMn(true);
		setAdmUserMn(true);
		setAdmPegawaiMn(true);
	}

	public boolean isKonfigurasiMn() {
		return konfigurasiMn;
	}

	public void setKonfigurasiMn(boolean konfigurasiMn) {
		this.konfigurasiMn = konfigurasiMn;
	}

	public boolean isAdmUserMn() {
		return admUserMn;
	}

	public void setAdmUserMn(boolean admUserMn) {
		this.admUserMn = admUserMn;
	}
	
	public boolean isAdmPegawaiMn() {
		return admPegawaiMn;
	}
	
	public void setAdmPegawaiMn(boolean admPegawaiMn) {
		this.admPegawaiMn = admPegawaiMn;
	}

}
