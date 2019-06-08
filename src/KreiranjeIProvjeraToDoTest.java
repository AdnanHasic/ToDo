import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class KreiranjeIProvjeraToDoTest {

	String datum;
	VlasnikToDoItema vlasnik;
	String tekst;
	int redniBroj;
	List<ToDo> listaToDo;
	String tag;
	KreiranjeIProvjeraToDo kreiranjeIprovjeraToDo;

	@Before
	public void setUp() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		datum = df.format(new Date());
		vlasnik = new VlasnikToDoItema("Net Beans", "0611/11 11 11");
		tekst = "Do subote moramo uraditi zadacu ! ";
		redniBroj=0;
		listaToDo = new ArrayList<ToDo>();
		tag = "A";
		kreiranjeIprovjeraToDo = new KreiranjeIProvjeraToDo();
	}

	@Test
	public void kreiranjeNovogToDoTest_ShouldReturnToDo_IfGivenDatumVlasnikTekstRedniBroj() {

		ToDo result = kreiranjeIprovjeraToDo.kreiranjeNovogToDo(datum,"Net Beans","0611/11 11 11","Do subote moramo uraditi zadacu ! ", "A", redniBroj);
		result.setRedniBroj(1);
		
		ToDo expected = new ToDo(datum, vlasnik, tekst, tag,redniBroj);
		expected.setRedniBroj(1);

		assertEquals(expected.toString(), result.toString());

	}
	
}
