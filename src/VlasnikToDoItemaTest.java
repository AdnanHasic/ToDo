import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VlasnikToDoItemaTest {

	String imeIPrezime;
	String brojTelefona;
	VlasnikToDoItema vlasnik1;
	
	
	@Before
	public void setUp() {
	imeIPrezime = "Niko Nikic";
	brojTelefona = "062/00 11 22 33";
	vlasnik1 = new VlasnikToDoItema(imeIPrezime,brojTelefona);
	
	}
	
	@Test
	public void getImeIPrezimeTest_ShouldReturnImeIPrezime_IfGivenImeIPrezime() {
		
		String result = vlasnik1.getImeIPrezime();
		
		String expected = "Niko Nikic";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void getBrojTelefonaTest_ShouldReturnBrojTelefona_IfGivenBrojTelefona() {
		
		String result = vlasnik1.getBrojTelefona();
		
		String expected = "062/00 11 22 33";
		
		assertEquals(expected, result);
	}
}
