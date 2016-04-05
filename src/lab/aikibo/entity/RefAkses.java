package lab.aikibo.entity;

import java.io.Serializable;

public class RefAkses implements Serializable {

	private static final long serialVersionUID = -5968998102560340653L;
	private String nmLogin;
	private boolean mnAdmUser;
	private boolean mnAdmPegawai;
	private boolean mnAdmPpat;
	private boolean mnAdmJnsPeralihan;
	private boolean mnAdmNpoptkp;
	private boolean mnAdmStatusBerkas;
	private boolean pengaturanMn;
	private boolean mnData;
	private boolean mnKonfigurasi;
	private boolean mnEntryTransaksi;
	private boolean mnLaporan;
	private boolean mnSkNjop;
	private boolean mnLembarDispo;
	private boolean mnKonfigurasiLaporan;
	
	public String getNmLogin() {
		return nmLogin;
	}
	
	public void setNmLogin(String nmLogin) {
		this.nmLogin = nmLogin;
	}
	
	public boolean isMnAdmUser() {
		return mnAdmUser;
	}
	
	public void setMnAdmUser(boolean mnAdmUser) {
		this.mnAdmUser = mnAdmUser;
	}
	
	public boolean isMnAdmPegawai() {
		return mnAdmPegawai;
	}
	
	public void setMnAdmPegawai(boolean mnAdmPegawai) {
		this.mnAdmPegawai = mnAdmPegawai;
	}
	
	public boolean isMnAdmPpat() {
		return mnAdmPpat;
	}
	
	public void setMnAdmPpat(boolean mnAdmPpat) {
		this.mnAdmPpat = mnAdmPpat;
	}
	
	public boolean isMnAdmJnsPeralihan() {
		return mnAdmJnsPeralihan;
	}
	
	public void setMnAdmJnsPeralihan(boolean mnAdmJnsPeralihan) {
		this.mnAdmJnsPeralihan = mnAdmJnsPeralihan;
	}
	
	public boolean isMnAdmNpoptkp() {
		return mnAdmNpoptkp;
	}
	
	public void setMnAdmNpoptkp(boolean mnAdmNpoptkp) {
		this.mnAdmNpoptkp = mnAdmNpoptkp;
	}
	
	public boolean isMnAdmStatusBerkas() {
		return mnAdmStatusBerkas;
	}
	
	public void setMnAdmStatusBerkas(boolean mnAdmStatusBerkas) {
		this.mnAdmStatusBerkas = mnAdmStatusBerkas;
	}
	
	public boolean isPengaturanMn() {
		return pengaturanMn;
	}
	
	public void setPengaturanMn(boolean pengaturanMn) {
		this.pengaturanMn = pengaturanMn;
	}
	
	public boolean isMnData() {
		return mnData;
	}
	
	public void setMnData(boolean mnData) {
		this.mnData = mnData;
	}
	
	public boolean isMnKonfigurasi() {
		return mnKonfigurasi;
	}
	
	public void setMnKonfigurasi(boolean mnKonfigurasi) {
		this.mnKonfigurasi = mnKonfigurasi;
	}
	
	public boolean isMnEntryTransaksi() {
		return mnEntryTransaksi;
	}
	
	public void setMnEntryTransaksi(boolean mnEntryTransaksi) {
		this.mnEntryTransaksi = mnEntryTransaksi;
	}
	
	public boolean isMnLaporan() {
		return mnLaporan;
	}
	
	public void setMnLaporan(boolean mnLaporan) {
		this.mnLaporan = mnLaporan;
	}
	
	public boolean isMnSkNjop() {
		return mnSkNjop;
	}
	
	public void setMnSkNjop(boolean mnSkNjop) {
		this.mnSkNjop = mnSkNjop;
	}
	
	public boolean isMnLembarDispo() {
		return mnLembarDispo;
	}
	
	public void setMnLembarDispo(boolean mnLembarDispo) {
		this.mnLembarDispo = mnLembarDispo;
	}
	
	public boolean isMnKonfigurasiLaporan() {
		return mnKonfigurasiLaporan;
	}
	
	public void setMnKonfigurasiLaporan(boolean mnKonfigurasiLaporan) {
		this.mnKonfigurasiLaporan = mnKonfigurasiLaporan;
	}
	
}
