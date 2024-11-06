package hu.petrik.bankiszolgaltatasok;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    public ArrayList<Szamla> szamlaLista = new ArrayList<Szamla>();

    /*void bank() throws IOException {
        Szamla sz1 = szamlaNyitas(new Tulajdonos("Teszt János"), 0);
        Szamla sz2 = szamlaNyitas(new Tulajdonos("Teszt Imre"), 3);
        Szamla sz3 = szamlaNyitas(new Tulajdonos("Teszt Gyula"), 1);
        szamlaLista.add(sz1);
        szamlaLista.add(sz2);
        szamlaLista.add(sz3);
    }*/

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelkeret) {

        if (hitelkeret == 0) {
            return new MegtakaritasiSzamla(tulajdonos);
        } else if (hitelkeret < 0) {
            return new HitelSzamla(tulajdonos, hitelkeret);
        } else {
            throw new Error("nem lehet negatív");
        }

    }

    public double getOsszEgyenleg(Tulajdonos tulajdonos) {
        Bank bank = new Bank();
        double osszEgyenleg = 0;
        for (Szamla szamla : bank.szamlaLista) {
            if (szamla.getTulajdonos().equals(tulajdonos)) {
                osszEgyenleg += szamla.getAktualisEgyenleg();
            }
        }
        return osszEgyenleg;
    }
    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos) {
        Szamla legnagyobbEgyenleguSzamla = null;
        double maxEgyenleg = 0;
        for (Szamla szamla : szamlaLista) {
            if (szamla.getTulajdonos().equals(tulajdonos)) {
                if (szamla.getAktualisEgyenleg() > maxEgyenleg) {
                    maxEgyenleg = szamla.getAktualisEgyenleg();
                    legnagyobbEgyenleguSzamla = szamla;
                }
            }
        }
        return legnagyobbEgyenleguSzamla;
    }

    public double getOsszHitelkeret() {
        double osszeg = 0;
        for (Szamla szamla : szamlaLista) {
            if (szamla instanceof HitelSzamla) {
                osszeg += ((HitelSzamla)szamla).getHitelKeret();
            }
        }
        return osszeg;
    }
}

