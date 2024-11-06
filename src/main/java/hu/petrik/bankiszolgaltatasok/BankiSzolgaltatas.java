package hu.petrik.bankiszolgaltatasok;

public class BankiSzolgaltatas {
    public  Tulajdonos tulajdonos;
    protected BankiSzolgaltatas(Tulajdonos tulajdonos) {
        this.tulajdonos = tulajdonos;
    }

    public Tulajdonos getTulajdonos() {
        return tulajdonos;
    }


}
