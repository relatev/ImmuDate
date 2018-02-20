package Datum;

import Chronologien.Chronologie;

public class Periode {

    private final Datum anfang;
    private final Datum ende;

    private final long tage;

    public Periode(Datum anfang, Datum ende) {
        this.anfang = anfang;
        this.ende = ende;

        this.tage = ende.zuTagen(anfang.gebeJahr()) - anfang.zuTagen();
    }

    public Periode(Datum ende) {
        this(new Datum(ende.gebeChrono()), ende);
    }

    public Datum zuDatum(Chronologie chrono) {
        long laenge = this.gebeLaenge();

        long jahr = chrono.gebeJahrNull();
        int monat = chrono.gebeMonatNull();
        int tag = chrono.gebeTagNull();

        while(laenge / chrono.gebeTageImJahr(jahr) >= 1) {
            jahr++; laenge -= chrono.gebeTageImJahr(jahr);
        }

        while(laenge / chrono.gebeTageImMonat(jahr, monat) >= 1) {
            monat++; laenge -= chrono.gebeTageImMonat(jahr, monat);
        }

        tag += (int) laenge;

        return new Datum(chrono, jahr, monat, tag);
    }

    public Datum gebeAnfang() {
        return anfang;
    }

    public Datum gebeEnde() {
        return ende;
    }

    public long gebeLaenge() {
        return Math.abs(this.tage);
    }

    public long gebeTage() {
        return tage;
    }

    @Override
    public String toString() {
        return "Periode{" +
                "anfang=" + anfang +
                ", ende=" + ende +
                ", tage=" + tage +
                '}';
    }
}
