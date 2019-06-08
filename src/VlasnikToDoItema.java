
public class VlasnikToDoItema {

	private String imeIPrezime;
	private String brojTelefona;

	public VlasnikToDoItema() {

	}

	public VlasnikToDoItema(String imeIPrezime, String brojTelefona) {
		this.imeIPrezime = imeIPrezime;
		this.brojTelefona = brojTelefona;
	}

	public String getImeIPrezime() {
		return imeIPrezime;

	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;

	}

	@Override
	public String toString() {
		return String.format(imeIPrezime + "\n" + brojTelefona);
	}

}
