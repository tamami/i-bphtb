package lab.aikibo.viewmodel;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import lab.aikibo.constant.StatusEntry;
import lab.aikibo.entity.DatLogin;
import lab.aikibo.manager.PegawaiManager;
import lab.aikibo.manager.UserManager;
import lab.aikibo.services.UserCredential;
import lab.aikibo.util.Encrypt;

import org.zkoss.bind.Property;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Clients;

public class AdmUserVM {
	
	private int status; // lihat lab.aikibo.constant.StatusEntry
	private UserManager um;
	private PegawaiManager pm;
	private boolean roTbNip;
	private boolean roTbNamaPegawai;
	private boolean roTbNamaUser;
	private boolean roTbPassPengubah;
	private boolean roTbPassBaru;
	private boolean roTbPassBaruConfirm;
	private boolean enBtnUbah;
	private boolean enBtnHapus;
	private boolean enBtnBaru;
	private boolean enBtnSimpan;
	private boolean enBtnBatal;
	private List<String> daftarLogin;
	private String currentLogin;
	private String currentNip;
	private String currentPegawai;
	private String currentPengguna;
	private String currentPassPengubah;
	private String currentPassBaru;
	private String currentPassBaruConfirm;
	
	
	@Init
	@NotifyChange({"daftarLogin","currentLogin"})
	public void init() {
		um = new UserManager();
		pm = new PegawaiManager();
		
		clear();
	}
	
	private void clear() {
		// seharusnya ada filter, kalo admin baru semuanya muncul, kalo ga hanya user
		// bersangkutan yang muncul.
		if(isAdmin()) {
		  setDaftarLogin(um.getListUserInString());
		  getAdminButton();
		} else {
	        List<String> data = new LinkedList<String>();
			data.add(( (UserCredential) Sessions.getCurrent().getAttribute("userCredential")).getNama());
			setDaftarLogin(data);
			getDefaultButton();
		}
		roTbNip = true;
		roTbNamaPegawai = true;
		roTbNamaUser = true;
		roTbPassPengubah = true;
		roTbPassBaru = true;
		roTbPassBaruConfirm = true;		
		currentLogin = new String();
		currentNip = new String();
		currentPegawai = new String();
		currentPengguna = new String();
		currentPassPengubah = new String();
		currentPassBaru = new String();
		currentPassBaruConfirm = new String();
	}
	
	// cek otoritas user
	private boolean isAdmin() {
		UserCredential cre = (UserCredential) Sessions.getCurrent().getAttribute("userCredential");
		if(cre.getNama() == "ADMIN") return true;
		else return false;
	}
	
	private void getDefaultButton() {
		enBtnUbah = true;
		enBtnHapus = true;
		enBtnBaru = false;
		enBtnSimpan = false;
		enBtnBatal = false;
		
		// pengecualian : dibutuhkan saat init aplikasi di awal saja
		// setelah user admin terbentuk, harap dijadikan comment;
		//getEditingButton();
	}
	
	private void getAdminButton() {
		enBtnUbah = true;
		enBtnHapus = true;
		enBtnBaru = true;
		enBtnSimpan = false;
		enBtnBatal = false;
	}
	
	// berlaku setelah form editing aktif
	private void getEditingButton() {
		enBtnUbah = false;
		enBtnHapus = false;
		enBtnBaru = false;
		enBtnSimpan = true;
		enBtnBatal = true;
		
	}
	
	private void getConfirmButton() {
		enBtnUbah = true;
		enBtnHapus = true;
		enBtnBaru = true;
		enBtnSimpan = false;
		enBtnBatal = false;
	}

	public List<String> getDaftarLogin() {
		return daftarLogin;
	}

	public void setDaftarLogin(List<String> daftarLogin) {
		this.daftarLogin = daftarLogin;
	}

	public String getCurrentLogin() {
		return currentLogin;
	}

	@NotifyChange({"currentNip", "currentPegawai","enBtnUbah","enBtnHapus","enBtnBaru",
		"enBtnSimpan","enBtnBatal"})
	public void setCurrentLogin(String currentLogin) {
		this.currentLogin = currentLogin;
		currentNip = um.getNip(currentLogin);
		currentPegawai = pm.getNamaByNip(currentNip);
		Session session = Sessions.getCurrent();
		currentPengguna = ((UserCredential) session.getAttribute("userCredential")).getNama();
		getEditingButton();
	}
	
	@Command
	@NotifyChange({"roTbNip","roTbNamaUser","roTbPassPengubah","roTbPassBaru",
		"roTbPassBaruConfirm","enBtnUbah","enBtnHapus","enBtnBaru","enBtnSimpan","enBtnBatal",
		"currentLogin","currentNip","currentPassBaru","currentPassBaruConfirm",
		"currentPassPengubah","currentPegawai","currentPengguna"})
	public void baruClick() {
		roTbNip = false;
		roTbNamaUser = false;
		roTbPassPengubah = false;
		roTbPassBaru = false;
		roTbPassBaruConfirm = false;
		currentLogin = new String();
		currentNip = new String();
		currentPassBaru = new String();
		currentPassBaruConfirm = new String();
		currentPassPengubah = new String();
		currentPegawai = new String();
		currentPengguna = new String();
		getConfirmButton();
		
		status = StatusEntry.DATA_BARU;
	}
	
	@Command
	@NotifyChange({"roTbNip","roTbNamaUser","roTbPassPengubah","roTbPassBaru",
		"roTbPassBaruConfirm","enBtnUbah","enBtnHapus","enBtnBaru","enBtnSimpan","enBtnBatal",
		"currentPengguna"})
	public void ubahClick() {
		roTbNip = true;
		roTbNamaUser = true;
		roTbPassPengubah = false;
		roTbPassBaru = false;
		roTbPassBaruConfirm = false;
		getConfirmButton();
		
		status = StatusEntry.UBAH_DATA;
	}
	
	@Command
	@NotifyChange({"roTbNip","roTbNamaUser","roTbPassPengubah","roTbPassBaru",
		"roTbPassBaruConfirm","enBtnUbah","enBtnHapus","enBtnBaru","enBtnSimpan","enBtnBatal"})
	public void hapusClick() {
		roTbNip = true;
		roTbNamaUser = true;
		roTbPassPengubah = false;
		roTbPassBaru = true;
		roTbPassBaruConfirm = true;
		getConfirmButton();
		
		status = StatusEntry.HAPUS_DATA;
	}
	
	@Command
	@NotifyChange({"roTbNip","roTbNamaUser","roTbPassPengubah","roTbPassBaru",
		"roTbPassBaruConfirm","daftarLogin","currentLogin","currentNip",
		"currentPegawai","currentPengguna","currentPassPengubah",
		"currentPassBaru","currentPassBaruConfirm","enBtnUbah",
		"enBtnHapus","enBtnBaru","enBtnSimpan","enBtnBatal"})
	public void batalClick() {
		clear();
		getDefaultButton();
	}
	
	@Command
	@NotifyChange({"roTbNip","roTbNamaUser","roTbPassPengubah","roTbPassBaru",
			"roTbPassBaruConfirm","daftarLogin","currentLogin","currentNip",
			"currentPegawai","currentPengguna","currentPassPengubah",
			"currentPassBaru","currentPassBaruConfirm","enBtnUbah",
			"enBtnHapus","enBtnBaru","enBtnSimpan","enBtnBatal"})
	public void simpanClick() {
		if(verifikasiData()) {
		// pengecualian: ini dipake saat init user pertama kali saja
		//if(false) {
			DatLogin data = um.getUserByNip(currentNip);
			try {
				data.setPassword(Encrypt.getEncrypted(currentPassBaru));
			} catch (InvalidKeyException e) {
				getMessageForInvalidKeyError();
				e.printStackTrace();
				return;
			} catch (NoSuchAlgorithmException e) {
				getMessageForNoSuchAlgorithmError();
				e.printStackTrace();
				return;
			} catch (UnsupportedEncodingException e) {
				getMessageForUnsupportedEncodingError();
				e.printStackTrace();
				return;
			} catch (IllegalBlockSizeException e) {
				getMessageForIllegalBlockSizeError();
				e.printStackTrace();
				return;
			} catch (BadPaddingException e) {
				getMessageForBadPaddingError();
				e.printStackTrace();
				return;
			} catch (NoSuchPaddingException e) {
				getMessageForNoSuchPaddingError();
				e.printStackTrace();
				return;
			} catch (InvalidAlgorithmParameterException e) {
				getMessageForInvalidAlgorithmParameterError();
				e.printStackTrace();
				return;
			}
			um.saveOrUpdate(data);
			Clients.showNotification("Data telah disimpan");
			clear();
			getDefaultButton();
		} else {
			Clients.showNotification("Data tidak ada dalam basis data");
			
			// pengecualian: ini digunakan untuk inisialisasi user db saja
			// jadi komentar setelah membuat user baru
			/*
			DatLogin newData = new DatLogin();
			newData.setNip(currentNip);
			newData.setNmLogin(currentPengguna);
			try {
				newData.setPassword(Encrypt.getEncrypted(currentPassBaru));
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			} catch (InvalidAlgorithmParameterException e) {
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
			um.saveOrUpdate(newData);
			Clients.showNotification("Data telah disimpan.");
			clear();
			getDefaultButton();
			*/
		}
	}
	
	private boolean verifikasiData() {
		if(currentNip.equals("") || currentNip == null) {
			Clients.showNotification("NIP wajib diisi");
			return false;
		}	
		try {
			if(status == StatusEntry.UBAH_DATA &&
				!Encrypt.getEncrypted(currentPassPengubah).equals(um.getPassword(currentPengguna))
						&& currentPassPengubah != null) {
				  Clients.showNotification("Password Pengubah salah");
				  return false;
			}
		} catch (InvalidKeyException e) {
			getMessageForInvalidKeyError();
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			getMessageForNoSuchAlgorithmError();
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			getMessageForUnsupportedEncodingError();
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			getMessageForIllegalBlockSizeError();
			e.printStackTrace();
		} catch (BadPaddingException e) {
			getMessageForBadPaddingError();
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			getMessageForNoSuchPaddingError();
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			getMessageForInvalidAlgorithmParameterError();
			e.printStackTrace();
		}
		if(!currentPassBaru.equals(currentPassBaruConfirm)) {
			Clients.showNotification("Password Konfirmasi tidak sama");
			return false;
		}
		String nmLogin = getNamaLoginByNip();
		if(status == StatusEntry.DATA_BARU && (!nmLogin.isEmpty() || nmLogin != null)) {
			Clients.showNotification("Pengguna untuk NIP : " + currentNip + " sudah terdaftar " +
					"dengan nama " + nmLogin);
			return false;
		}
			
		return true;
	}
	
	private String getNamaLoginByNip() {
		DatLogin data = um.getUserByNip(currentNip);
		if(data.getNmLogin().isEmpty()) return null; // data ga ada 
		else return data.getNmLogin();
	}
	
	@SuppressWarnings("unused")
	private String getNipFromNmLogin() {
		String data = um.getNip(currentPengguna);
		if(data.isEmpty() || data == null) return null;
		else return data;
	}
	
	private void getMessageForInvalidKeyError() {
		Clients.showNotification("Kesalahan kunci enkripsi, hubungi developer");
	}
	
	private void getMessageForNoSuchAlgorithmError() {
		Clients.showNotification("Kesalahan algoritma enkripsi, hubungi developer");
	}
	
	private void getMessageForUnsupportedEncodingError() {
		Clients.showNotification("Penkodean enkripsi tidak didukung, hubungi developer");
	}
	
	private void getMessageForIllegalBlockSizeError() {
		Clients.showNotification("Ukuran Blok Enkripsi salah, hubungi developer");
	}
	
	private void getMessageForBadPaddingError() {
		Clients.showNotification("Padding enkripsi rusak, hubungi developer");
	}
	
	private void getMessageForNoSuchPaddingError() {
		Clients.showNotification("Padding enkripsi tidak ada, hubungi developer");
	}
	
	private void getMessageForInvalidAlgorithmParameterError() {
		Clients.showNotification("Kesalahan parameter algoritma enkripsi, hubungi developer");
	}
	
		
	// -- setter and getter

	public String getCurrentNip() {
		return currentNip;
	}

	public void setCurrentNip(String currentNip) {
		this.currentNip = currentNip;
	}

	public String getCurrentPegawai() {
		return currentPegawai;
	}

	public void setCurrentPegawai(String currentPegawai) {
		this.currentPegawai = currentPegawai;
	}

	public boolean isRoTbNip() {
		return roTbNip;
	}

	public void setRoTbNip(boolean roTbNip) {
		this.roTbNip = roTbNip;
	}

	public boolean isRoTbNamaPegawai() {
		return roTbNamaPegawai;
	}

	public void setRoTbNamaPegawai(boolean roTbNamaPegawai) {
		this.roTbNamaPegawai = roTbNamaPegawai;
	}

	public boolean isRoTbPassPengubah() {
		return roTbPassPengubah;
	}

	public void setRoTbPassPengubah(boolean roTbPassPengubah) {
		this.roTbPassPengubah = roTbPassPengubah;
	}

	public boolean isRoTbPassBaru() {
		return roTbPassBaru;
	}

	public void setRoTbPassBaru(boolean roTbPassBaru) {
		this.roTbPassBaru = roTbPassBaru;
	}

	public boolean isRoTbPassBaruConfirm() {
		return roTbPassBaruConfirm;
	}

	public void setRoTbPassBaruConfirm(boolean roTbPassBaruConfirm) {
		this.roTbPassBaruConfirm = roTbPassBaruConfirm;
	}

	public String getCurrentPengguna() {
		return currentPengguna;
	}

	public void setCurrentPengguna(String currentPengguna) {
		this.currentPengguna = currentPengguna;
	}

	public boolean isRoTbNamaUser() {
		return roTbNamaUser;
	}

	public void setRoTbNamaUser(boolean roTbNamaUser) {
		this.roTbNamaUser = roTbNamaUser;
	}

	public String getCurrentPassPengubah() {
		return currentPassPengubah;
	}

	public void setCurrentPassPengubah(String currentPassPengubah) {
		this.currentPassPengubah = currentPassPengubah;
	}

	public String getCurrentPassBaru() {
		return currentPassBaru;
	}

	public void setCurrentPassBaru(String currentPassBaru) {
		this.currentPassBaru = currentPassBaru;
	}

	public String getCurrentPassBaruConfirm() {
		return currentPassBaruConfirm;
	}

	public void setCurrentPassBaruConfirm(String currentPassBaruConfirm) {
		if(currentPassBaruConfirm.equals(currentPassBaru))
		  this.currentPassBaruConfirm = currentPassBaruConfirm;
		else {
			Clients.showNotification("Konfirmasi password baru tidak sama");
			return;
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isEnBtnUbah() {
		return enBtnUbah;
	}

	public void setEnBtnUbah(boolean enBtnUbah) {
		this.enBtnUbah = enBtnUbah;
	}
	
	public boolean isEnBtnHapus() {
		return enBtnHapus;
	}
	
	public void setEnBtnHapus(boolean enBtnHapus) {
		this.enBtnHapus = enBtnHapus;
	}
	
	public boolean isEnBtnBaru() {
		return enBtnBaru;
	}
	
	public void setEnBtnBaru(boolean enBtnBaru) {
		this.enBtnBaru = enBtnBaru;
	}
	
	public boolean isEnBtnSimpan() {
		return enBtnSimpan;
	}
	
	public void setEnBtnSimpan(boolean enBtnSimpan) {
		this.enBtnSimpan = enBtnSimpan;
	}
	
	public boolean isEnBtnBatal() {
		return enBtnBatal;
	}
	
	public void setEnBtnBatal(boolean enBtnBatal) {
		this.enBtnBatal = enBtnBatal;
	}

}