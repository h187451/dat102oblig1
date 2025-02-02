package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
	
	private int filmnr;
	private String produsent;
	private String tittel;
	private int lanseringsaar;
	private Sjanger sjanger;
	private String filmselskap;
	
	public Film() {
		
	}
	
	public Film(int filmnr, String produsent, String tittel, int lanseringsaar, Sjanger sjanger, String filmselskap) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lanseringsaar = lanseringsaar;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}
	
	public int getFilmnr() {
		return this.filmnr;
	}
	
	public String getProdusent() {
		return this.produsent;
	}
	
	public String getTittel() {
		return this.tittel;
	}
	
	public int getLanseringsaar() {
		return this.lanseringsaar;
	}
	
	public Sjanger getSjanger() {
		return this.sjanger;
	}
	
	public String getFilmselskap() {
		return this.filmselskap;
	}
	
	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}
	
	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}
	
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	
	public void setLanseringsaar(int lanseringsaar) {
		this.lanseringsaar = lanseringsaar;
	}
	
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	
	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmnr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmnr == other.filmnr;
	}


}
