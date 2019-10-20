package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


}