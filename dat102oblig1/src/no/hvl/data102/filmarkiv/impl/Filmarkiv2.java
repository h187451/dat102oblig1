package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	
	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2() {
		antall = 0;
		start = null;
	}
	
	private boolean erTom() {
		return antall == 0;
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
	
	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> p = start;
		while (p != null) {
			if (p.getData().getFilmnr() == nr) {
				return p.getData();
			}
			p = p.getNeste();
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (start == null) {
			start = new LinearNode<>(nyFilm);
		} else {
			LinearNode<Film> ny = new LinearNode<>(nyFilm);
			ny.setNeste(start);
			start = ny;
		}
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		if (!erTom()) {
			if (start.getData().getFilmnr() == filmnr) {
		        start = start.getNeste();
		        antall--;
		        
		        return true;
		    }
			
			 LinearNode<Film> forrige = start;
			 LinearNode<Film> current = start.getNeste();

			 while (current != null) {
				 if (current.getData().getFilmnr() == filmnr) {
			            forrige.setNeste(current.getNeste());
			            antall--;
			            
			            return true;
			     }
			     forrige = current;
			     current = current.getNeste();
			 }
		}
		
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		int antallFunnet = 0;
		Film[] filmMedTittel = new Film[antall];
		if (!erTom()) {
			if (start.getData().getTittel().contains(delstreng)) {
				filmMedTittel[antallFunnet] = start.getData();
				antallFunnet++;
		    }
			
			 LinearNode<Film> current = start.getNeste();

			 while (current != null) {
				 if (current.getData().getTittel().contains(delstreng)) {
					 filmMedTittel[antallFunnet] = start.getData();
						antallFunnet++;
			     }
			     current = current.getNeste();
			 }
		}
		return trimTab(filmMedTittel, antallFunnet);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		int antallFunnet = 0;
		Film[] filmMedProd = new Film[antall];
		if (!erTom()) {
			if (start.getData().getProdusent().contains(delstreng)) {
				filmMedProd[antallFunnet] = start.getData();
				antallFunnet++;
		    }
			
			 LinearNode<Film> current = start.getNeste();

			 while (current != null) {
				 if (current.getData().getProdusent().contains(delstreng)) {
					 filmMedProd[antallFunnet] = start.getData();
						antallFunnet++;
			     }
			     current = current.getNeste();
			 }
		}
		return trimTab(filmMedProd, antallFunnet);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antallMedSjanger = 0;
		if (start.getData().getSjanger() == sjanger) {
			antallMedSjanger++;
	    }
		
		 LinearNode<Film> current = start.getNeste();

		 while (current != null) {
			 if (current.getData().getSjanger() == sjanger) {
					antallMedSjanger++;
			    }
		     current = current.getNeste();
		 }
		return antallMedSjanger;
	}

	@Override
	public int antall() {
		return antall;
	}
}
