package lab.aikibo.entity;

import java.io.Serializable;

public class Pegawai implements Serializable {

	private static final long serialVersionUID = 1843671975159257478L;
	
	private String nip;
	private String nmPegawai;
	
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getNmPegawai() {
		return nmPegawai;
	}
	public void setNmPegawai(String nmPegawai) {
		this.nmPegawai = nmPegawai;
	}

}
