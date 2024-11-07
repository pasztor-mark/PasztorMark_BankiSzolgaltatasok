package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla {
    private final double hitelkeret;

    public HitelSzamla(Tulajdonos tulajdonos, double hitelkeret) {
        super(tulajdonos);
        this.hitelkeret = hitelkeret;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (hitelkeret < osszeg) {
            return false;
        } else {
            setEgyenleg(this.getAktualisEgyenleg() - osszeg);
            return true;
        }
    }

    public double getHitelKeret() {
        return this.hitelkeret;
    }
}

