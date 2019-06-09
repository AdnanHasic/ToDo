import java.util.List;

import javax.swing.JOptionPane;

public class KreiranjeIProvjeraAccounta {

	public boolean pitanjeDaLiVecImateKreiranRacun(String odgovor) {
		
		if (odgovor.equalsIgnoreCase("DA")) {
			
			return true;
			
		} else {
			
			return false;	
		}
	}
	
 public boolean logIn(String username, String password,String iscitaniUsername,String iscitaniPassword) {

				if ((username).equals(iscitaniUsername)
						&& (password).equals(iscitaniPassword)) {
					
					return true;
				}
		return false;
	}
 
 public String ispisListeIscitanihTaskova(String username, List<Account> listaAkaunta) {
		String output = "";
		
		for (int i = 0; i < listaAkaunta.get(0).getListaToDo().size(); i++) {

			String pozicija0 = Integer.toString(listaAkaunta.get(0).getListaToDo().get(i).getRedniBroj());
			String  pozicija1 = listaAkaunta.get(0).getListaToDo().get(i).getDatum();
			String  pozicija2 = listaAkaunta.get(0).getListaToDo().get(i).getVlasnik().getImeIPrezime();
			String  pozicija3 = listaAkaunta.get(0).getListaToDo().get(i).getVlasnik().getBrojTelefona();
			String  pozicija4 = listaAkaunta.get(0).getListaToDo().get(i).getTekst();
			String  pozicija5 = listaAkaunta.get(0).getListaToDo().get(i).getTag();

			output += " " + "\n" + "\nRedni broj=".concat(pozicija0) + "\n" + "Datum kreiranja=".concat( pozicija1) + "\n"
					+ "Ime i prezime vlasnika=".concat( pozicija2) + "\n" + "Broj telefona=".concat( pozicija3) + "\n"
					+ "Tekst=".concat(pozicija4) + "\n" + "Tag=".concat( pozicija5);
		}
		return output;

	}
	

}
