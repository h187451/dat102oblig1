package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
	Scanner scanner = new Scanner(System.in);
	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm(){
		System.out.println("Skriv filmnr på filmen");
		int filmnr = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Skriv produsent på filmen");
		String produsent = scanner.nextLine();
		System.out.println("Skriv tittel på filmen");
		String tittel = scanner.nextLine();
		System.out.println("Skriv lanseringsår på filmen");
		int lanseringsaar = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Skriv sjanger på filmen");
		String sjangerStr = scanner.nextLine();
		Sjanger sjanger = Sjanger.finnSjanger(sjangerStr);
		System.out.println("Skriv filmselskap på filmen");
		String filmselskap = scanner.nextLine();
		Film lestFilm = new Film(filmnr, produsent, tittel, lanseringsaar, sjanger, filmselskap);
		return lestFilm;
	}
	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		System.out.println("Filmnr: " + film.getFilmnr());
		System.out.println("Produsent: " + film.getProdusent());
		System.out.println("Tittel: " + film.getTittel());
		System.out.println("Lanseringsaar: " + film.getLanseringsaar());
		System.out.println("Sjanger: " + film.getSjanger());
		System.out.println("Filmnselskap: " + film.getFilmselskap());
	}
	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		Film[] filmerMedTittel = arkiv.soekTittel(delstreng);
		for (int i=0;i<filmerMedTittel.length;i++) {
			skrivUtFilm(filmerMedTittel[i]);
		}
	}
	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		Film[] filmerMedProdusent = arkiv.soekProdusent(delstreng);
		for (int i=0;i<filmerMedProdusent.length;i++) {
			skrivUtFilm(filmerMedProdusent[i]);
		}
	}
	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		System.out.println("Antall filmer totalt: " + arkiv.antall());
		Sjanger[] sjangTab = Sjanger.values();
		for (int i=0; i<Sjanger.values().length;i++) {
			int antallAvSjanger = arkiv.antall(sjangTab[i]);
			System.out.println("Filmer av sjanger " + sjangTab[i].toString() + ": " + antallAvSjanger);
		}
	}
	// osv ... andre metoder
}

