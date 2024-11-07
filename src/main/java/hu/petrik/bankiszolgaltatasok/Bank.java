package hu.petrik.bankiszolgaltatasok;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    public ArrayList<Szamla> szamlaLista = new ArrayList<Szamla>();


    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelkeret) {

        if (hitelkeret == 0) {
            MegtakaritasiSzamla megtakaritasiSzamla = new MegtakaritasiSzamla(tulajdonos);
            szamlaLista.add(megtakaritasiSzamla);
            return megtakaritasiSzamla;
        } else if (hitelkeret > 0) {
            HitelSzamla hitelSzamla = new HitelSzamla(tulajdonos, hitelkeret);
            szamlaLista.add(hitelSzamla);
            return hitelSzamla;
        } else {
            throw new IllegalArgumentException("nem lehet negatív");
        }

    }

    public double getOsszEgyenleg(Tulajdonos tulajdonos) {

        double osszEgyenleg = 0;
        for (Szamla szamla : szamlaLista) {
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
                HitelSzamla hitelSzamla = (HitelSzamla) szamla;
                osszeg += hitelSzamla.getHitelKeret();
            }
        }
        return osszeg;
    }
}

