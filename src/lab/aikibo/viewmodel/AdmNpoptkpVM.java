package lab.aikibo.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Init;

import lab.aikibo.entity.RefJenisPeralihan;
import lab.aikibo.entity.RefNpoptkp;
import lab.aikibo.manager.JenisPeralihanManager;

public class AdmNpoptkpVM {
	
	private RefNpoptkp currentNpoptkp;
	private JenisPeralihanManager jpm;
	private List<String> daftarJnsPeralihan;
	private int indexJnsPeralihan;
	
	@Init
	public void init() {
		jpm = new JenisPeralihanManager();
		
		setDaftarJnsPeralihan(jpm.getAllDataFormatted());
	}
	
	
	// --- setters and getters

	public RefNpoptkp getCurrentNpoptkp() {
		return currentNpoptkp;
	}

	public JenisPeralihanManager getJpm() {
		return jpm;
	}


	public void setJpm(JenisPeralihanManager jpm) {
		this.jpm = jpm;
	}


	public void setCurrentNpoptkp(RefNpoptkp currentNpoptkp) {
		this.currentNpoptkp = currentNpoptkp;
	}

	public List<String> getDaftarJnsPeralihan() {
		return daftarJnsPeralihan;
	}

	public void setDaftarJnsPeralihan(List<String> daftarJnsPeralihan) {
		this.daftarJnsPeralihan = daftarJnsPeralihan;
	}


	public int getIndexJnsPeralihan() {
		indexJnsPeralihan = currentNpoptkp.getJnsPeralihan().getKdJnsPeralihan() - 1;
		return indexJnsPeralihan;
	}


	public void setIndexJnsPeralihan(int indexJnsPeralihan) {
		this.indexJnsPeralihan = indexJnsPeralihan;
		RefJenisPeralihan jnsPeralihan = currentNpoptkp.getJnsPeralihan();
		jnsPeralihan.setKdJnsPeralihan(indexJnsPeralihan + 1);
		currentNpoptkp.setJnsPeralihan(jnsPeralihan);
	}

}
