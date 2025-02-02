package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	
	public Meny(FilmarkivADT filmarkiv){
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}
	
	public void start(){
		Scanner scanner = new Scanner(System.in);
		Film film1 = new Film(1, "produsent1", "film1", 2001, Sjanger.ACTION, "selskap1");
		this.filmarkiv.leggTilFilm(film1);
		Film film2 = new Film(2, "produsent2", "film2", 2002, Sjanger.DRAMA, "selskap2");
		this.filmarkiv.leggTilFilm(film2);
		Film film3 = new Film(3, "produsent3", "film3", 2003, Sjanger.ACTION, "selskap3");
		this.filmarkiv.leggTilFilm(film3);
		Film film4 = new Film(4, "produsent4", "film4", 2004, Sjanger.SCIFI, "selskap4");
		this.filmarkiv.leggTilFilm(film4);
		boolean stopp = false;
		while (!stopp) {
			System.out.print("Hva ønsker du å gjøre? ((A)legg til film, (B)skriv ut om film, (C)filmstatistikk), (X)stopp ");
			String svar = scanner.nextLine();
			switch (svar) {
				case "A":
					filmarkiv.leggTilFilm(tekstgr.lesFilm());
					break;
				case "B":
					System.out.println("Finne film via 'tittel' eller 'produsent'? ");
					String svarTittelElProd = scanner.nextLine();
					if (svarTittelElProd.equals("tittel")) {
						System.out.println("Søk etter tittel: ");
						String soekeTittel = scanner.nextLine();
						tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, soekeTittel);
					} else if (svarTittelElProd.equals("produsent")) {
						System.out.println("Søk etter produsent: ");
						String soekeProdusent = scanner.nextLine();
						tekstgr.skrivUtFilmProdusent(filmarkiv, soekeProdusent);
					}
					break;
				case "C":
					tekstgr.skrivUtStatistikk(filmarkiv);
					break;
				case "X":
					stopp = true;
					break;
			}
		}
		scanner.close();
	}
}