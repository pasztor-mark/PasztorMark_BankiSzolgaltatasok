package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla {
    public static double alapKamat;

    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.alapKamat = 1.1;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (this.getAktualisEgyenleg() - osszeg < 0) {
            return false;
        } else {
            this.setEgyenleg(this.getAktualisEgyenleg() - osszeg);
            return true;
        }
    }

    public static double getKamat() {
        return alapKamat;
    }

    public static void setKamat(double alapKamat) {
        MegtakaritasiSzamla.alapKamat = alapKamat;
    }

    public void kamatJovairas() {
        this.setEgyenleg(alapKamat * this.getAktualisEgyenleg());
    }
}
