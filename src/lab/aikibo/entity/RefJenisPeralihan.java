package lab.aikibo.entity;

import java.io.Serializable;
import java.util.Set;

public class RefJenisPeralihan implements Serializable {

	private static final long serialVersionUID = -6137125546918923952L;
	private int kdJnsPeralihan;
	private String jnsPeralihan;
	private Set<RefNpoptkp> daftarNpoptkp;
	
	public int getKdJnsPeralihan() {
		return kdJnsPeralihan;
	}
	
	public void setKdJnsPeralihan(int kdJnsPeralihan) {
		this.kdJnsPeralihan = kdJnsPeralihan;
	}
	
	public String getJnsPeralihan() {
		return jnsPeralihan;
	}
	
	public void setJnsPeralihan(String jnsPeralihan) {
		this.jnsPeralihan = jnsPeralihan;
	}
	
	public Set<RefNpoptkp> getDaftarNpoptkp() {
		return daftarNpoptkp;
	}
	
	public void setDaftarNpoptkp(Set<RefNpoptkp> daftarNpoptkp) {
		this.daftarNpoptkp = daftarNpoptkp;
	}

}
