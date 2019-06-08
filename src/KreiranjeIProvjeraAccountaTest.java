import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class KreiranjeIProvjeraAccountaTest {

	String datum;
	String odgovor;
	String odgovor2;
	KreiranjeIProvjeraAccounta metode1;
	String imeIPrezime;
	String brojTelefona;
	String username;
	String password;
	String iscitaniUsername;
	String iscitaniPassword;
	VlasnikToDoItema noviVlasnikItema;
	String tekst;
	String tag;
	int redniBroj;
	ToDo noviToDo;
	List<Account> listaAkaunta = new ArrayList<>();
	List<ToDo> listaToDo = new ArrayList<>();
	Account noviAkaunt;

	@Before
	public void setUp() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		datum = df.format(new Date()).toString();
		odgovor = "DA";
		odgovor2 = "NE";
		metode1 = new KreiranjeIProvjeraAccounta();
		username = "homer";
		password = "0000";
		iscitaniUsername = "bart";
		iscitaniPassword = "1234";
		imeIPrezime = "Niko Nikic";
		brojTelefona = "062/00 11 22 33";
		tekst = "Neki tekst";
		tag = "A";
		redniBroj = 1;
		noviVlasnikItema = new VlasnikToDoItema(imeIPrezime, brojTelefona);
		noviToDo = new ToDo(datum, noviVlasnikItema, tekst, tag, redniBroj);
		listaToDo.add(noviToDo);
		noviAkaunt = new Account(username, password, listaToDo);
		listaAkaunta.add(noviAkaunt);

	}

	@Test
	public void pitanjeDaLiVecImateKreiranRacunTest_ShouldReturnTrue_IfGivenCorrectAnswer() {

		boolean result = metode1.pitanjeDaLiVecImateKreiranRacun(odgovor);

		assertTrue(result);

	}

	@Test
	public void pitanjeDaLiVecImateKreiranRacunTest_ShouldReturnFalse_IfGivenWrongAnswer() {

		boolean result = metode1.pitanjeDaLiVecImateKreiranRacun(odgovor2);

		assertFalse(result);

	}

	@Test
	public void logInTest_ShouldReturnFalse_IfUsernameIsNotCorrect() {

		boolean result = metode1.logIn(username, password, iscitaniUsername, iscitaniPassword);

		assertFalse(result);

	}

	@Test
	public void logInTest_ShouldReturnFalse_IfPasswordIsNotCorrect() {

		boolean result = metode1.logIn(username, password, iscitaniUsername, iscitaniPassword);

		assertFalse(result);

	}

	@Test
	public void logInTest_ShouldReturnFalse_IfUsernameAndPasswordAreNotCorrect() {

		boolean result = metode1.logIn(username, password, iscitaniUsername, iscitaniPassword);

		assertFalse(result);

	}

	@Test
	public void logInTest_ShouldReturnTrue_IfUsernameAndPasswordAreCorrect() {

		iscitaniUsername = "homer";
		iscitaniPassword = "0000";
		boolean result = metode1.logIn(username, password, iscitaniUsername, iscitaniPassword);

		assertTrue(result);

	}

	@Test
	public void ispisListeIscitanihTaskovaTest_SholudReturnListOfTasks_IfGivenListOfTasks() {

		String output = "";

		for (int i = 0; i < listaAkaunta.get(0).getListaToDo().size(); i++) {

			String pozicija0 = Integer.toString(listaAkaunta.get(0).getListaToDo().get(i).getRedniBroj());
			String pozicija1 = listaAkaunta.get(0).getListaToDo().get(i).getDatum();
			String pozicija2 = listaAkaunta.get(0).getListaToDo().get(i).getVlasnik().getImeIPrezime();
			String pozicija3 = listaAkaunta.get(0).getListaToDo().get(i).getVlasnik().getBrojTelefona();
			String pozicija4 = listaAkaunta.get(0).getListaToDo().get(i).getTekst();
			String pozicija5 = listaAkaunta.get(0).getListaToDo().get(i).getTag();

			output += " " + "\n" + "\nRedni broj=".concat(pozicija0) + "\n" + "Datum kreiranja=".concat(pozicija1)
					+ "\n" + "Ime i prezime vlasnika=".concat(pozicija2) + "\n" + "Broj telefona=".concat(pozicija3)
					+ "\n" + "Tekst=".concat(pozicija4) + "\n" + "Tag=".concat(pozicija5);
		}

		String expected = output;

		String result = metode1.ispisListeIscitanihTaskova(username, listaAkaunta);

		assertEquals(expected, result);
	}

	@Test
	public void ispisListeIscitanihTaskovaTest_SholudReturnFalse_IfListOfTasksIsNotEmpty() {

		boolean result = (listaAkaunta.isEmpty());

		assertFalse(result);
	}

	@Test
	public void ispisListeIscitanihTaskovaTest_SholudReturnTrue_IfListOfTasksIsEmpty() {

		boolean result = (!listaAkaunta.isEmpty());

		assertTrue(result);
	}

}
