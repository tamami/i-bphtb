package lab.aikibo.entity;

import java.io.Serializable;

public class RefStatusBerkas implements Serializable {

	private static final long serialVersionUID = 4901228404093830362L;
	private int kdStatus;
	private String statusBerkas;
	
	public int getKdStatus() {
		return kdStatus;
	}
	public void setKdStatus(int kdStatus) {
		this.kdStatus = kdStatus;
	}
	public String getStatusBerkas() {
		return statusBerkas;
	}
	public void setStatusBerkas(String statusBerkas) {
		this.statusBerkas = statusBerkas;
	}

}
