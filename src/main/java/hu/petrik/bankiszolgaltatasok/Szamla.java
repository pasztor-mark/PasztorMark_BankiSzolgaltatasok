package hu.petrik.bankiszolgaltatasok;

public class Szamla extends BankiSzolgaltatas {
    public double aktualisEgyenleg = 0;
    public Szamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
    }

    public double getAktualisEgyenleg() {
        return aktualisEgyenleg;
    }

    public void setEgyenleg(double egyenleg) {
        this.aktualisEgyenleg = egyenleg;
    }

    public void befizet(double osszeg) {
        this.aktualisEgyenleg += osszeg;
    }
    public boolean kivesz(int osszeg) {
        if (this.aktualisEgyenleg - osszeg < 0) {
            return false;
        } else {return true;}
    }
    public Kartya ujKartya(String kartyaszam) {
        return new Kartya(this.tulajdonos, this, kartyaszam);
    }
}
