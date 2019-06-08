import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDo {
    
	private static int brojac;
	private int redniBroj;
	private String datum;
	private VlasnikToDoItema vlasnik;
	private String tekst;
	private String tag;
	ToDo nekiToDo;

	public ToDo() {

	}

	public ToDo(String datum, VlasnikToDoItema vlasnik, String tekst, String tag,int redniBroj) {
        brojac++;
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		datum = df.format(new Date()).toString();
		this.datum = datum;
		this.vlasnik = vlasnik;
		this.tekst = tekst;
		this.tag = tag;
		this.redniBroj = brojac;

	}


	public static int getBrojac() {
		return brojac;
	}

	public static void setBrojac(int brojac) {
		ToDo.brojac = brojac;
	}

	public int getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}

	public String getDatum() {
		return datum;
	}

	public VlasnikToDoItema getVlasnik() {
		return vlasnik;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return String.format(datum + "\n" + vlasnik + "\n" + tekst + "\n" + tag + "\n" + redniBroj);
	}

}
