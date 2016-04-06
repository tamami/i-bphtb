package lab.aikibo.viewmodel;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Sessions;

import lab.aikibo.entity.RefAkses;
import lab.aikibo.manager.AksesManager;
import lab.aikibo.services.UserCredential;

public class MenuVM {
	
	private RefAkses akses;
	private boolean konfigurasiMn;
	private boolean admUserMn;
	private boolean admPegawaiMn;
	private boolean admPpatMn;
	private boolean admJnsPeralihanMn;
	private boolean admNpoptkpMn;
	private boolean admStatusBerkasMn;
	private boolean pengaturanMenuMn;
	private boolean konfigLaporanMn;
	private boolean dataMn;
	private boolean entryTransaksiMn;
	private boolean laporanMn;
	private boolean skNjopMn;
	private boolean lembarDispoMn;
	
	@Init
	public void init() {
		//setAllTrue();
		
		org.zkoss.zk.ui.Session sessWeb = Sessions.getCurrent();
		UserCredential cre = (UserCredential) sessWeb.getAttribute("userCredential");
				
		AksesManager am = new AksesManager();
		akses = am.getAkses(cre.getNama());
		setupMenu();
	}
	
	private void setAllTrue() {
		setKonfigurasiMn(true);
		setAdmUserMn(true);
		setAdmPegawaiMn(true);
	}
	
	private void setupMenu() {
		setKonfigurasiMn(akses.isMnKonfigurasi());
		setAdmUserMn(akses.isMnAdmUser());
		setAdmPegawaiMn(akses.isMnAdmPegawai());
		setAdmPpatMn(akses.isMnAdmPpat());
		setAdmJnsPeralihanMn(akses.isMnAdmJnsPeralihan());
		setAdmNpoptkpMn(akses.isMnAdmNpoptkp());
		setAdmStatusBerkasMn(akses.isMnAdmStatusBerkas());
		setPengaturanMenuMn(akses.isPengaturanMn());
		setKonfigLaporanMn(akses.isMnKonfigurasiLaporan());
		
		setDataMn(akses.isMnData());
		setEntryTransaksiMn(akses.isMnEntryTransaksi());
		
		setLaporanMn(akses.isMnLaporan());
		setSkNjopMn(akses.isMnSkNjop());
		setLembarDispoMn(akses.isMnLembarDispo());		
	}
	
	// --- setter and getter
	
	public boolean isKonfigurasiMn() {
		return konfigurasiMn;
	}

	public void setKonfigurasiMn(boolean konfigurasiMn) {
		this.konfigurasiMn = konfigurasiMn;
	}

	public boolean isAdmUserMn() {
		return admUserMn;
	}

	public boolean isAdmPpatMn() {
		return admPpatMn;
	}

	public void setAdmPpatMn(boolean admPpatMn) {
		this.admPpatMn = admPpatMn;
	}

	public boolean isAdmJnsPeralihanMn() {
		return admJnsPeralihanMn;
	}

	public void setAdmJnsPeralihanMn(boolean admJnsPeralihanMn) {
		this.admJnsPeralihanMn = admJnsPeralihanMn;
	}

	public boolean isAdmNpoptkpMn() {
		return admNpoptkpMn;
	}

	public void setAdmNpoptkpMn(boolean admNpoptkpMn) {
		this.admNpoptkpMn = admNpoptkpMn;
	}

	public boolean isAdmStatusBerkasMn() {
		return admStatusBerkasMn;
	}

	public void setAdmStatusBerkasMn(boolean admStatusBerkasMn) {
		this.admStatusBerkasMn = admStatusBerkasMn;
	}

	public boolean isPengaturanMenuMn() {
		return pengaturanMenuMn;
	}

	public void setPengaturanMenuMn(boolean pengaturanMenuMn) {
		this.pengaturanMenuMn = pengaturanMenuMn;
	}

	public boolean isKonfigLaporanMn() {
		return konfigLaporanMn;
	}

	public void setKonfigLaporanMn(boolean konfigLaporanMn) {
		this.konfigLaporanMn = konfigLaporanMn;
	}

	public boolean isDataMn() {
		return dataMn;
	}

	public void setDataMn(boolean dataMn) {
		this.dataMn = dataMn;
	}

	public boolean isEntryTransaksiMn() {
		return entryTransaksiMn;
	}

	public void setEntryTransaksiMn(boolean entryTransaksiMn) {
		this.entryTransaksiMn = entryTransaksiMn;
	}

	public boolean isLaporanMn() {
		return laporanMn;
	}

	public void setLaporanMn(boolean laporanMn) {
		this.laporanMn = laporanMn;
	}

	public boolean isSkNjopMn() {
		return skNjopMn;
	}

	public void setSkNjopMn(boolean skNjopMn) {
		this.skNjopMn = skNjopMn;
	}

	public boolean isLembarDispoMn() {
		return lembarDispoMn;
	}

	public void setLembarDispoMn(boolean lembarDispoMn) {
		this.lembarDispoMn = lembarDispoMn;
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
