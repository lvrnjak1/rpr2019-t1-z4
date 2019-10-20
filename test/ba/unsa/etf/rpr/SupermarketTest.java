package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SupermarketTest {

    private Supermarket supermarket;
    private Artikl artikl;

    @BeforeEach
    void setUp() {
        supermarket = new Supermarket();
        artikl = new Artikl("laptop", 2500, "lap123");
    }

    @Test
    void dodavanjeTest1() {
        supermarket.dodajArtikl(artikl);
        assertEquals(1, supermarket.getBrojArtikala());
    }

    @Test
    void dodavanjeTest2() {
        for(int i = 0; i < 1000; i++){
            supermarket.dodajArtikl(new Artikl("proizvod", 500, String.valueOf(i)));
        }

        assertFalse(supermarket.dodajArtikl(artikl));
    }
}