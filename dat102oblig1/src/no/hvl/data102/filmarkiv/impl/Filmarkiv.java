package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	
	public Film[] filmTabell;
	public int nesteledig = 0;
	
	public Filmarkiv(int lengde) {
		filmTabell = new Film[lengde];
	}
	
	private boolean ledigPlass() {
		if (nesteledig >= filmTabell.length) {
			return false;
		}
		return true;
	}
	
	private Film[] trimTab(Film[] tab, int n) {
		Film[] nytab = new Film[n];
		int i = 0;
		while (i < n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}

	
	private void utvid() {
		Film[] nytabell = new Film[filmTabell.length * 2];
		for (int i=0;i<nesteledig;i++) {
			nytabell[i] = filmTabell[i];
		}
		filmTabell = nytabell;
	}

	@Override
	public Film finnFilm(int nr) {
		for (int i=0;i<nesteledig;i++) {
			if (filmTabell[i].getFilmnr() == nr) {
				return filmTabell[i];
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (!ledigPlass()) {
			utvid();
		}
		filmTabell[nesteledig] = nyFilm;
		nesteledig++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		for (int i=0;i<nesteledig;i++) {
			if (filmTabell[i].getFilmnr() == filmnr) {
				nesteledig--;
				filmTabell[i] = filmTabell[nesteledig];
				filmTabell[nesteledig] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		int antallFunnet = 0;
		Film[] filmMedTittel = new Film[nesteledig];
		for (int i=0;i<nesteledig;i++) {
			if (filmTabell[i].getTittel().contains(delstreng)) {
				filmMedTittel[antallFunnet] = filmTabell[i];
				antallFunnet++;
			}
		}
		return trimTab(filmMedTittel, antallFunnet);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		int antallFunnet = 0;
		Film[] filmMedProdusent = new Film[nesteledig];
		for (int i=0;i<nesteledig;i++) {
			if (filmTabell[i].getProdusent().contains(delstreng)) {
				filmMedProdusent[antallFunnet] = filmTabell[i];
				antallFunnet++;
			}
		}
		return trimTab(filmMedProdusent, antallFunnet);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antallMedSjanger = 0;
		for (int i=0;i<nesteledig;i++) {
			if (filmTabell[i].getSjanger() == sjanger) {
				antallMedSjanger++;
			}
		}
		return antallMedSjanger;
	}

	@Override
	public int antall() {
		int antallFilmer = 0;
		for (int i=0;i<nesteledig;i++) {
			antallFilmer++;
		}
		return antallFilmer;
	}

}
