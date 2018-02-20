package Chronologien;

import Chronologien.Chronologie;

import java.util.Arrays;

public class GregorianischeChronologie extends Chronologie {

    private final long jahrNull = 1;
    private final int monatNull = 1;
    private final int wocheNull = 1;
    private final int tagNull = 1;

    private final int monateProJahr = 12;

    private final int[] minTageProMonat = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 , 31};
    private final int[] maxTageProMonat = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 , 31};

    private final int tageProWoche = 7;

    @Override
    public int gebeMonateImJahr(long jahr) throws IllegalArgumentException {
        if(!validesJahr(jahr))
            throw new IllegalArgumentException("Die Monate im Jahr " + jahr + " sind undefiniert.");

        return this.gebeMonateProJahr();
    }

    @Override
    public int gebeWochenImJahr(long jahr) throws IllegalArgumentException {
        return (int) Math.floor(this.gebeTageImJahr(jahr) / this.gebeTageProWoche());
    }

    @Override
    public int gebeTageImJahr(long jahr) throws IllegalArgumentException {
        if(!validesJahr(jahr))
            throw new IllegalArgumentException("Die Tage im " + jahr + " sind undefiniert.");

        if(istSchaltjahr(jahr))
            return Arrays.stream(this.gebeMaxTageProMonat()).sum();
        else
            return Arrays.stream(this.gebeMinTageProMonat()).sum();
    }

    @Override
    public int gebeTageImMonat(long jahr, int monat) throws IllegalArgumentException {
        if(!validerMonat(jahr, monat))
            throw new IllegalArgumentException("Die Tage für den Monat " + monat + " sind undefiniert.");

        if(istSchaltjahr(jahr))
            return this.gebeMaxTageProMonat()[monat - 1];
        else
            return this.gebeMinTageProMonat()[monat - 1];
    }

    @Override
    public int gebeTageInWoche(long jahr, int woche) throws IllegalArgumentException {
        if(!valideWoche(jahr, woche))
            throw new IllegalArgumentException("Die Tage für die Woche " + woche + " sind undefiniert.");

        return this.gebeTageProWoche();
    }

    @Override
    public boolean istSchaltjahr(long jahr) throws IllegalArgumentException {
        if(!validesJahr(jahr))
            throw new IllegalArgumentException("Das Jahr " + jahr + " ist undefiniert.");

        return jahr % 4 == 0 && (!(jahr % 100 == 0) || jahr % 400 == 0);
    }

    @Override
    public boolean istSchaltmonat(long jahr, int monat) throws IllegalArgumentException {
        if(!validerMonat(jahr, monat))
            throw new IllegalArgumentException("Der Monat " + monat + " ist undefiniert.");

        return istSchaltjahr(jahr) && monat == 2;
    }

    @Override
    public boolean istSchaltwoche(long jahr, int woche) {
        return false;
    }

    @Override
    public boolean istSchalttag(long jahr, int monat, int tag) throws IllegalArgumentException {
        return false;
    }

    @Override
    public long gebeJahrNull() {
        return this.jahrNull;
    }

    @Override
    public int gebeMonatNull() {
        return this.monatNull;
    }

    @Override
    public int gebeWocheNull() {
        return this.wocheNull;
    }

    @Override
    public int gebeTagNull() {
        return this.tagNull;
    }

    private int gebeMonateProJahr() {
        return this.monateProJahr;
    }

    private int[] gebeMinTageProMonat() {
        return this.minTageProMonat;
    }

    private int[] gebeMaxTageProMonat() {
        return this.maxTageProMonat;
    }

    private int gebeTageProWoche() {
        return this.tageProWoche;
    }

    @Override
    public String toString() {
        return "GregorianischeChronologie{" +
                "jahrNull=" + jahrNull +
                ", monatNull=" + monatNull +
                ", wocheNull=" + wocheNull +
                ", tagNull=" + tagNull +
                ", monateProJahr=" + monateProJahr +
                ", minTageProMonat=" + Arrays.toString(minTageProMonat) +
                ", maxTageProMonat=" + Arrays.toString(maxTageProMonat) +
                ", tageProWoche=" + tageProWoche +
                '}';
    }
}
