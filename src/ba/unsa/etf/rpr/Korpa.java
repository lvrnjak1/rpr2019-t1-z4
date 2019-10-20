package ba.unsa.etf.rpr;

public class Korpa {
    private Artikl[] artikli = new Artikl[50];
    private int brojArtikala = 0;

    public Artikl[] getArtikli() {
        return artikli;
    }

    public boolean dodajArtikl(Artikl a) {
        if(brojArtikala == 50){
            return false;
        }

        artikli[brojArtikala] = a;
        brojArtikala++;
        return true;
    }

    public Artikl izbaciArtiklSaKodom(String kod) {
        for(int i = 0; i < brojArtikala; i++){
            if(artikli[i].getKod().equals(kod)){
                Artikl izbacen = artikli[i];
                for(int j = i; j < 49; j++){
                    artikli[j] = artikli[j+1];
                }
                brojArtikala--;
                return izbacen;
            }
        }

        return null;
    }

    public int dajUkupnuCijenuArtikala() {
        int ukupnaCijena = 0;
        for(int i = 0; i < brojArtikala; i++){
            ukupnaCijena += artikli[i].getCijena();
        }

        return ukupnaCijena;
    }
}
