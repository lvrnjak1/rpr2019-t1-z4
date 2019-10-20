package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorpaTest {

    private Korpa korpa;
    private Artikl artikl;

    @BeforeEach
    void setUp() {
         korpa = new Korpa();
         artikl = new Artikl("laptop", 2500, "1234");
    }

    @Test
    void dodavanjeTest1() {
        boolean mozeSeDodati = korpa.dodajArtikl(artikl);
        assertTrue(mozeSeDodati);
    }

    @Test
    void dodavanjeTest2() {
        korpa.dodajArtikl(artikl);
        assertEquals(1, korpa.getBrojArtikala());
    }

    @Test
    void dodavanjeTest3() {
        for(int i = 0; i < 50; i++){
            Artikl artikl = new Artikl("laptop", 2500, "1234");
            korpa.dodajArtikl(artikl);
        }
        boolean mozeSeDodati = korpa.dodajArtikl(new Artikl("telefon", 1000, "5678"));
        assertAll("korpa puna",
                () -> assertFalse(mozeSeDodati),
                () -> assertEquals(50, korpa.getBrojArtikala())
        );
    }

    @Test
    void izbacivanjeTest1() {
        korpa.dodajArtikl(artikl);
        Artikl izbacen = korpa.izbaciArtiklSaKodom("1234");
        assertAll("izbacivanje",
                () -> assertEquals(artikl.getNaziv(), izbacen.getNaziv()),
                () -> assertEquals(artikl.getKod(), izbacen.getKod()),
                () -> assertEquals(artikl.getCijena(), izbacen.getCijena()),
                () -> assertEquals(0, korpa.getBrojArtikala())
        );
    }

    @Test
    void izbacivanjeTest2() {
        korpa.dodajArtikl(artikl);
        Artikl izbacen = korpa.izbaciArtiklSaKodom("nepostojeciKod");
        assertNull(izbacen);
    }

    @Test
    void ukupnaCijenaTest1() {
        korpa.dodajArtikl(artikl);
        korpa.dodajArtikl(new Artikl("telefon", 1000, "4567"));
        korpa.dodajArtikl(new Artikl("slušalice", 55, "s12"));
        assertEquals(2500 + 1000 + 55, korpa.dajUkupnuCijenuArtikala());
    }

    @Test
    void ukupnaCijenaTest2() {
        assertEquals(0, korpa.dajUkupnuCijenuArtikala());
    }
}