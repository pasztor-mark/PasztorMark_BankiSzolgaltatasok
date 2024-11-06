package hu.petrik.bankiszolgaltatasok;

public class Kartya extends BankiSzolgaltatas {
    private final Szamla szamla;
    private String kartyaszam;
    public Kartya(Tulajdonos tulajdonos, Szamla szamla, String kartyaszam) {
        super(tulajdonos);
        this.szamla = szamla;
        this.kartyaszam = kartyaszam;
    }
    public boolean vasarlas(int osszeg) {
        return this.szamla.kivesz(osszeg);
    }

    public String getKartyaSzam() {
        return kartyaszam;
    }
}
