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

        // Inizialisiert Jahr, Monat und Tag des neuen Datums mit den Nullwerten der Chonologie.
        long jahr = chrono.gebeJahrNull();
        int monat = chrono.gebeMonatNull();
        int tag = chrono.gebeTagNull();

        // Überprüft ob die Länge eines Jahres in Tagen in laenge passt.
        while(laenge / chrono.gebeTageImJahr(jahr) >= 1) {
            // Subtrahiert die Länge des Jahres von laenge und addiert das Jahr zu jahr.
            laenge -= chrono.gebeTageImJahr(jahr); jahr++;
        }

        // Überprüft ob die Länge eines Monats in Tagen in laenge passt.
        while(laenge / chrono.gebeTageImMonat(jahr, monat) >= 1) {
            // Subtrahiert die Länge des Monats von laenge und addiert den Monat zu monat.
            laenge -= chrono.gebeTageImMonat(jahr, monat); monat++;
        }

        // Addiert die übrige laegne zu tag.
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
