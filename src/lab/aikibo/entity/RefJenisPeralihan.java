package lab.aikibo.entity;

import java.io.Serializable;

public class RefJenisPeralihan implements Serializable {

	private static final long serialVersionUID = -6137125546918923952L;
	private int kdJnsPeralihan;
	private String jnsPeralihan;
	
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
	

}
