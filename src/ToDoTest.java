import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ToDoTest {

	String datum;
	VlasnikToDoItema nekiVlasnik;
	String nekiTekst;
	String nekiTag;
	int redBr;
	ToDo nekiToDo;
	
	@Before
	public void setUp() {
		
	
		datum = new Date().toString();
	
		nekiTekst = "zadatak za godisnji odmor";
		nekiTag="";
		redBr=1;
		nekiToDo = new ToDo(datum, nekiVlasnik, nekiTekst,nekiTag,redBr);
		
	}
	
	@Test
	public void getDatumTest_ShouldReturnDatum_IfGivenDatum() {
		
		String result = nekiToDo.getDatum();
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		
		String expected = df.format(new Date());
		
		assertEquals(expected, result);	
		
	}
	
	@Test
	public void getVlasnikTest_ShouldReturnVlasnik_IfGivenVlasnik() {
		
		VlasnikToDoItema result = nekiToDo.getVlasnik();
		
		VlasnikToDoItema expected = nekiVlasnik;
		
		assertEquals(expected, result);
		
	}
	
	@Test
	public void getTekstTest_ShouldReturnVlasnik_IfGivenTekst() {
		
		String result = nekiToDo.getTekst();
		
		String expected = "zadatak za godisnji odmor";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void toStringTest_ShouldReturnString_IfGivenString() {
		
		String result = nekiToDo.toString();
		
		String expected = "ToDo{" +
                "datum=" + nekiToDo.getDatum() +
                ", vlasnik=" + nekiVlasnik +
                ", tekst='" + "zadatak za godisnji odmor" + '\'' +
                ", redniBroj=" +  redBr +
                '}';
	}
	
	

}
