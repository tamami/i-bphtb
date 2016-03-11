package lab.aikibo.entity;

import java.io.Serializable;

public class Ppat implements Serializable {

	private static final long serialVersionUID = 8138026589058585312L;
	private int kdPpat;
	private String namaPpat;
	
	// --- setters and getters
	
	public int getKdPpat() {
		return kdPpat;
	}
	public void setKdPpat(int kdPpat) {
		this.kdPpat = kdPpat;
	}
	public String getNamaPpat() {
		return namaPpat;
	}
	public void setNamaPpat(String namaPpat) {
		this.namaPpat = namaPpat;
	}

}
