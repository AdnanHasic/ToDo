import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainToDo {

	public static Scanner ulazPodataka = new Scanner(System.in);

	public static void main(String[] args) {
		String broj = null;

		List<Account> listaAkaunta = new ArrayList<>();
		List<ToDo> listaTaskova = new ArrayList<>();
		KreiranjeIProvjeraAccounta kreiranjeIProvjeraAccounta = new KreiranjeIProvjeraAccounta();
		KreiranjeIProvjeraToDo kreiranjeIProvjeraToDo = new KreiranjeIProvjeraToDo();
		Account noviAkaunt = new Account();
		int izborMenija = 0;

		try {
			String odgovor = JOptionPane.showInputDialog(null, "Da li vec imate kreiran racun : DA ili NE ", "ToDo",
					JOptionPane.QUESTION_MESSAGE);
			
			if (!kreiranjeIProvjeraAccounta.pitanjeDaLiVecImateKreiranRacun(odgovor)) {

				JOptionPane.showMessageDialog(null, "Morate kreirati account!", "ToDo",
						JOptionPane.INFORMATION_MESSAGE);

				String username = JOptionPane.showInputDialog(null, "Unesite username :", "To-Do",
						JOptionPane.QUESTION_MESSAGE);

				File myFile = new File(username.concat(".txt"));

				if (myFile.exists()) {
					JOptionPane.showMessageDialog(null, "Postoji vec taj username, morate pokusati ponovo !", "ToDo",
							JOptionPane.INFORMATION_MESSAGE);
				}

				String password = JOptionPane.showInputDialog(null, "Unesite password :", "To-Do",
						JOptionPane.QUESTION_MESSAGE);

				noviAkaunt = new Account(username, password, new ArrayList<>());

				PrintWriter pw;
				try {
					pw = new PrintWriter(Files.newBufferedWriter(Paths.get(username.concat(".txt")),
							StandardOpenOption.APPEND, StandardOpenOption.CREATE));

					pw.println(username);
					pw.println(password);

					pw.flush();
					pw.close();

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			String username = JOptionPane.showInputDialog(null,
					"Da kreirate task,morate se logovati, upisite username :", "To-Do", JOptionPane.QUESTION_MESSAGE)
					.trim();

			String password = JOptionPane
					.showInputDialog(null, "Unesite password :", "To-Do", JOptionPane.QUESTION_MESSAGE).trim();

			String iscitaniUsername = "";
			String iscitaniPassword = "";

			try {
				Path putanja = Paths.get(username.concat(".txt"));

				for (int i = 0; i < 2; i++) {

					MainToDo.ulazPodataka = new Scanner(putanja);

					iscitaniUsername = MainToDo.ulazPodataka.nextLine();
					iscitaniPassword = MainToDo.ulazPodataka.nextLine();
				}

				if (kreiranjeIProvjeraAccounta.logIn(username, password, iscitaniUsername, iscitaniPassword)) {
					JOptionPane.showMessageDialog(null, "Uspjesno ste se logovoali !", "ToDo",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Pokusajte ponovo !", "ToDo", JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (IOException e) {

				JOptionPane.showMessageDialog(null, "Greska prilikom logovanja, morate krenuti od pocetka !", "ToDo",
						JOptionPane.INFORMATION_MESSAGE);
			}

			listaAkaunta.add(new Account(iscitaniUsername, iscitaniPassword, listaTaskova));
			listaAkaunta.get(0).setListaToDo(kreiranjeIProvjeraToDo.listaTOdOIscitanaIzFajla());


			do {

				try {
					String meni[] = { "1.Za dodavanje taska", "2.Za brisanje taska an osnovu rednog broja",
							"3.Za ispisivanje taskova", "4.Za ispis filtriranih taskova na osnovu taga",
							"5.Za editovanje taska", "6.Za izlazak iz programa" };

					String listingMenija = "";

					for (int l = 0; l < meni.length; l++) {

						String stavkaUMeniju = meni[l];

						listingMenija += stavkaUMeniju + " " + "\n";

					}

					izborMenija = Integer
							.parseInt(JOptionPane.showInputDialog(null, listingMenija, "izaberite broj :"));

					switch (izborMenija) {

					case 1:
						int brojac = 0;
						DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
						String datum = df.format(new Date());

						String imeIPrezimeVlasnika = JOptionPane.showInputDialog(null,
								"Unesite ime i prezime vlasnika item-a :", "To-Do", JOptionPane.QUESTION_MESSAGE);

						String brojTelefonaVlasnikaItema = JOptionPane.showInputDialog(null,
								"Unesite broj telefona vlasnika item-a :", "To-Do", JOptionPane.QUESTION_MESSAGE);

						String text = JOptionPane.showInputDialog(null, "Unesite tekst :", "To-Do",
								JOptionPane.QUESTION_MESSAGE);

						String tag = JOptionPane.showInputDialog(null, "Unesite tag :", "To-Do",
								JOptionPane.QUESTION_MESSAGE);

						brojac++;

						int redniBroj = brojac;

						listaAkaunta.get(0).getListaToDo().add(kreiranjeIProvjeraToDo.kreiranjeNovogToDo(datum,
								imeIPrezimeVlasnika, brojTelefonaVlasnikaItema, text, tag, redniBroj));

						kreiranjeIProvjeraToDo.praznjenjeFajla(username);

						punjenjeFajla(iscitaniUsername, listaAkaunta);
						break;
					case 2:
						int izborTaskaZaBrisanje = Integer.parseInt(JOptionPane
								.showInputDialog(null, "Da izbrisete task na osnovu rednog broja, upisite redni broj :",
										"To-Do", JOptionPane.QUESTION_MESSAGE)
								.trim());
						
						for (int i = 0; i < listaAkaunta.get(0).getListaToDo().size(); i++) {
							if (listaAkaunta.get(0).getListaToDo().get(i).getRedniBroj() == izborTaskaZaBrisanje) {
								listaAkaunta.get(0).getListaToDo().remove(i);
							}
						}
						
						kreiranjeIProvjeraToDo.praznjenjeFajla(username);

						punjenjeFajla(iscitaniUsername, listaAkaunta);

						break;

					case 3:

						String ispis = kreiranjeIProvjeraAccounta.ispisListeIscitanihTaskova(iscitaniUsername,
								listaAkaunta);

						JOptionPane.showMessageDialog(null, ispis);

						break;

					case 4:
						
						String output = "";
						
						String izborTaga = JOptionPane
								.showInputDialog(null, "Da filtrirate ispis na osnovu taga upisite tag :", "To-Do",
										JOptionPane.QUESTION_MESSAGE)
								.trim();
				
						for (int i = 0; i < listaAkaunta.get(0).getListaToDo().size(); i++) {		
							if (listaAkaunta.get(0).getListaToDo().get(i).getTag().equalsIgnoreCase(izborTaga)) {
								output += " " + "\n" + listaAkaunta.get(0).getListaToDo().get(i);
							} 
						}
						JOptionPane.showMessageDialog(null, output);
						break;

					case 5:
						String izborTagaZaEditTaska = JOptionPane.showInputDialog(null,
								"Da editujete task osnovu taga upisite tag :", "To-Do", JOptionPane.QUESTION_MESSAGE)
								.trim();

						String noviTekstTaska = JOptionPane
								.showInputDialog(null, "Unesite novi tekst :", "To-Do", JOptionPane.QUESTION_MESSAGE)
								.trim();

						kreiranjeIProvjeraToDo.editovanjeTaska(izborTagaZaEditTaska, listaAkaunta, noviTekstTaska);

						kreiranjeIProvjeraToDo.praznjenjeFajla(username);

						punjenjeFajla(iscitaniUsername, listaAkaunta);

						listaAkaunta.get(0).setListaToDo(listaTaskova);

					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Unesite ispravan broj !", "ToDo",
							JOptionPane.INFORMATION_MESSAGE);
					break;
					
				}

			} while (izborMenija != 6);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Izasli ste iz programa !", "ToDo", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void punjenjeFajla(String username, List<Account> listaAkaunta) {

		try {
			PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get(username.concat(".txt")),
					StandardOpenOption.APPEND, StandardOpenOption.DSYNC));
			
			for (int i = 0; i < listaAkaunta.size(); i++) {
				pw.println(listaAkaunta.get(i).getUsername());
				pw.println(listaAkaunta.get(i).getPassword());
			}
			
			for (int j = 0; j < listaAkaunta.get(0).getListaToDo().size(); j++) {
				listaAkaunta.get(0).getListaToDo().get(j).setRedniBroj(j + 1);
				pw.println(listaAkaunta.get(0).getListaToDo().get(j));
			}

			pw.flush();
			pw.close();

		} catch (IOException e) {
			System.out.println("Greska !");
		}
	}
}
