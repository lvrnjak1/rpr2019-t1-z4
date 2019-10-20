package ba.unsa.etf.rpr;

public class Supermarket {
    private Artikl[] artikli = new Artikl[1000];
    private int brojArtikala = 0;


    public Artikl[] getArtikli() {
        return artikli;
    }

    public Artikl izbaciArtiklSaKodom(String kod) {
        for(int i = 0; i < brojArtikala; i++){
            if(artikli[i].getKod().equals(kod)){
                Artikl izbacen = artikli[i];
                for(int j = i; j < 999; j++){
                    artikli[j] = artikli[j+1];
                }
                brojArtikala--;
                return izbacen;
            }
        }

        return null;
    }

    public boolean dodajArtikl(Artikl a) {
        if (brojArtikala < 1000) {
            artikli[brojArtikala] = a;
            brojArtikala++;
            return true;
        }

        return false;
    }

    public int getBrojArtikala() {
        return brojArtikala;
    }
}
