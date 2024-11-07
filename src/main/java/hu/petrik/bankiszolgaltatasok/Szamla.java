package hu.petrik.bankiszolgaltatasok;

public abstract class Szamla extends BankiSzolgaltatas {
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
    public abstract boolean kivesz(int osszeg);
    public Kartya ujKartya(String kartyaszam) {
        return new Kartya(this.tulajdonos, this, kartyaszam);
    }
}
