package lab.aikibo.entity;

import java.io.Serializable;

public class RefNpoptkp implements Serializable {

	private static final long serialVersionUID = 8798805834761190697L;
	private long kdNpoptkp;
	private String thnPeralihan;
	private int kdJnsPeralihan;
	private long npoptkp;
	
	// --- setters and getters
	
	public long getKdNpoptkp() {
		return kdNpoptkp;
	}
	
	public void setKdNpoptkp(long kdNpoptkp) {
		this.kdNpoptkp = kdNpoptkp;
	}
	
	public int getKdJnsPeralihan() {
		return kdJnsPeralihan;
	}
	
	public void setKdJnsPeralihan(int kdJnsPeralihan) {
		this.kdJnsPeralihan = kdJnsPeralihan;
	}
	
	public long getNpoptkp() {
		return npoptkp;
	}
	
	public void setNpoptkp(long npoptkp) {
		this.npoptkp = npoptkp;
	}

	public String getThnPeralihan() {
		return thnPeralihan;
	}

	public void setThnPeralihan(String thnPeralihan) {
		this.thnPeralihan = thnPeralihan;
	}

}
