package lab.aikibo.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Init;

import lab.aikibo.entity.RefJenisPeralihan;
import lab.aikibo.manager.JenisPeralihanManager;

public class AdmJnsPeralihanVM {
	
	private RefJenisPeralihan currentJnsPeralihan;
	private List<RefJenisPeralihan> daftarJnsPeralihan;
	private JenisPeralihanManager jpm;
	
	@Init
	public void init() {
		jpm = new JenisPeralihanManager();
		daftarJnsPeralihan = jpm.getAllData();
	}
	
	// --- setters and getters
	
	public RefJenisPeralihan getCurrentJnsPeralihan() {
		return currentJnsPeralihan;
	}
	
	public void setCurrentJnsPeralihan(RefJenisPeralihan currentJnsPeralihan) {
		this.currentJnsPeralihan = currentJnsPeralihan;
	}
	
	public List<RefJenisPeralihan> getDaftarJnsPeralihan() {
		return daftarJnsPeralihan;
	}
	
	public void setDaftarJnsPeralihan(List<RefJenisPeralihan> daftarJnsPeralihan) {
		this.daftarJnsPeralihan = daftarJnsPeralihan;
	}

}
