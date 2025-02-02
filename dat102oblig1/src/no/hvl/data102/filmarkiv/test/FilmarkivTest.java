package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class FilmarkivTest {
	
	public Film film1 = new Film(1, "produsent1", "film1", 2001, Sjanger.ACTION, "selskap1");
	public Film film2 = new Film(2, "produsent2", "film2", 2002, Sjanger.HISTORY, "selskap2");
	
	public Filmarkiv testFilmarkiv1 = new Filmarkiv(2);
	public Filmarkiv2 testFilmarkiv2 = new Filmarkiv2();
	
	@Test
	void testLeggTilFilm1() {
		
		assertEquals(0, testFilmarkiv1.antall());
		
		testFilmarkiv1.leggTilFilm(film1);
		
		assertEquals(1, testFilmarkiv1.antall());
	}
	
	@Test
	void testLeggTilFilm2() {
		
		assertEquals(0, testFilmarkiv2.antall());
		
		testFilmarkiv2.leggTilFilm(film1);
		
		assertEquals(1, testFilmarkiv2.antall());
	}
	
	@Test
	void testFinnFilm1() {
		
		testFilmarkiv1.leggTilFilm(film1);
		testFilmarkiv1.leggTilFilm(film2);
		
		assertEquals(film2, testFilmarkiv1.finnFilm(2));
	}
	
	@Test
	void testFinnFilm2() {
		
		testFilmarkiv2.leggTilFilm(film1);
		testFilmarkiv2.leggTilFilm(film2);
		
		assertEquals(film2, testFilmarkiv2.finnFilm(2));
	}
	
	@Test
	void testSlettFilm1() {
		testFilmarkiv1.leggTilFilm(film1);
		testFilmarkiv1.leggTilFilm(film2);
		
		testFilmarkiv1.slettFilm(2);
		assertEquals(null, testFilmarkiv1.finnFilm(2));
	}
	
	@Test
	void testSlettFilm2() {
		testFilmarkiv2.leggTilFilm(film1);
		testFilmarkiv2.leggTilFilm(film2);
		
		testFilmarkiv2.slettFilm(2);
		assertEquals(null, testFilmarkiv2.finnFilm(2));
	}
	
	@Test
	void testAntall1() {
		testFilmarkiv1.leggTilFilm(film1);
		
		assertEquals(1, testFilmarkiv1.antall());
		
		testFilmarkiv1.leggTilFilm(film2);
		
		assertEquals(2, testFilmarkiv1.antall());
	}
	
	@Test
	void testAntall2() {
		testFilmarkiv2.leggTilFilm(film1);
		
		assertEquals(1, testFilmarkiv2.antall());
		
		testFilmarkiv2.leggTilFilm(film2);
		
		assertEquals(2, testFilmarkiv2.antall());
	}
	
	@Test
	void testSoekTittel1() {
		testFilmarkiv1.leggTilFilm(film1);
		testFilmarkiv1.leggTilFilm(film2);
		
		Film[] testTabTittel = testFilmarkiv1.soekTittel("m2");
		assertEquals(film2, testTabTittel[0]);
	}
	
	@Test
	void testSoekTittel2() {
		testFilmarkiv2.leggTilFilm(film1);
		testFilmarkiv2.leggTilFilm(film2);
		
		Film[] testTabTittel = testFilmarkiv2.soekTittel("m2");
		assertEquals(film2, testTabTittel[0]);
	}
	
	@Test
	void testSoekProdusent1() {
		testFilmarkiv1.leggTilFilm(film1);
		testFilmarkiv1.leggTilFilm(film2);
		
		Film[] testTabProd = testFilmarkiv1.soekProdusent("nt2");
		assertEquals(film2, testTabProd[0]);
	}
	
	@Test
	void testSoekProdusent2() {
		testFilmarkiv2.leggTilFilm(film1);
		testFilmarkiv2.leggTilFilm(film2);
		
		Film[] testTabProd = testFilmarkiv2.soekProdusent("nt2");
		assertEquals(film2, testTabProd[0]);
	}
	
	@Test
	void testAntallSjanger1() {
		testFilmarkiv1.leggTilFilm(film1);
		testFilmarkiv1.leggTilFilm(film2);
		
		int testAntallSjang = testFilmarkiv1.antall(Sjanger.ACTION);
		assertEquals(1, testAntallSjang);
	}
	
	@Test
	void testAntallSjanger2() {
		testFilmarkiv2.leggTilFilm(film1);
		testFilmarkiv2.leggTilFilm(film2);
		
		int testAntallSjang = testFilmarkiv2.antall(Sjanger.ACTION);
		assertEquals(1, testAntallSjang);
	}
	
}
