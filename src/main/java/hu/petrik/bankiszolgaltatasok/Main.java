package hu.petrik.bankiszolgaltatasok;

public class Main {
    public static void main(String[] args) {
        try {
        Bank bank = new Bank();
        bank.getOsszEgyenleg(new Tulajdonos("Teszt Imre"));
        } catch (Exception e) {}
    }
}
