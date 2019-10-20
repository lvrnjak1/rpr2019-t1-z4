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
                for(int j = i; j < brojArtikala - 1; j++){
                    artikli[j] = artikli[j-1];
                }
                brojArtikala--;
                return izbacen;
            }
        }

        return null;
    }

    public void dodajArtikl(Artikl a) {
        artikli[brojArtikala] = a;
        brojArtikala++;
    }
}
