import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class KreiranjeIProvjeraToDo {

	public ToDo kreiranjeNovogToDo(String datum,String imeIPrezimeVlasnika,String brojTelefonaVlasnikaItema,String text,String tag,int redniBroj) {

		return new ToDo(datum, new VlasnikToDoItema(imeIPrezimeVlasnika, brojTelefonaVlasnikaItema), text, tag,
				redniBroj);

	}

	public void praznjenjeFajla(String username) {
		FileOutputStream writer = null;
		try {
			writer = new FileOutputStream(username.concat(".txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.write(("").getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List listaTOdOIscitanaIzFajla() {

		List listaToDo = new ArrayList<>();

		while (MainToDo.ulazPodataka.hasNextLine()) {
			
			String datum = MainToDo.ulazPodataka.nextLine();
			
			String imeIprezime = MainToDo.ulazPodataka.nextLine();
			
			String brojTelefona = MainToDo.ulazPodataka.nextLine();
			
			VlasnikToDoItema vlasnikItema = new VlasnikToDoItema(imeIprezime, brojTelefona);
			
			String tekst = MainToDo.ulazPodataka.nextLine();
			
			String tag = MainToDo.ulazPodataka.nextLine();
			
			int redniBroj = Integer.parseInt(MainToDo.ulazPodataka.nextLine());
			
			ToDo noviTDo = new ToDo(datum, vlasnikItema, tekst, tag, redniBroj);

			listaToDo.add(noviTDo);
		}

		return listaToDo;
	}

	public void editovanjeTaska(String tagZaEdit, List<Account> listaAkaunta, String noviTekst) {

		for (int i = 0; i < listaAkaunta.get(0).getListaToDo().size(); i++) {
			if (listaAkaunta.get(0).getListaToDo().get(i).getTag().equalsIgnoreCase(tagZaEdit)) {
				listaAkaunta.get(0).getListaToDo().get(i).setTekst(noviTekst);
			}
		}
	}

}
