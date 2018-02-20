package Chronologien;

import Chronologien.Chronologie;

public class StatischeChronologie extends Chronologie {

    private final long jahrNull = 0;
    private final int monatNull = 1;
    private final int wocheNull = 1;
    private final int tagNull = 1;

    private final int monateProJahr = 12;

    private final int tageProMonat = 30;

    private final int tageProWoche = 7;

    @Override
    public int gebeMonateImJahr(long jahr) {
        return this.gebeMonateProJahr();
    }

    @Override
    public int gebeWochenImJahr(long jahr) {
        return (int) Math.ceil(this.gebeTageImJahr(jahr) / this.gebeTageProWoche());
    }

    @Override
    public int gebeTageImJahr(long jahr) {
        return this.gebeTageProMonat() * this.gebeMonateProJahr();
    }

    @Override
    public int gebeTageImMonat(long jahr, int monat) throws IllegalArgumentException {
        if(!validerMonat(jahr, monat))
            throw new IllegalArgumentException("Die Tage für den Monat " + monat + " sind undefiniert.");

        return this.gebeTageProMonat();
    }

    @Override
    public int gebeTageInWoche(long jahr, int woche) throws IllegalArgumentException {
        if(!valideWoche(jahr, woche))
            throw new IllegalArgumentException("Die Tage in der Woche " + woche + " sind undefiniert.");

        return this.gebeTageProWoche();
    }

    @Override
    public boolean istSchaltjahr(long jahr) {
        return false;
    }

    @Override
    public boolean istSchaltmonat(long jahr, int monat) throws IllegalArgumentException {
        return false;
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

    public int gebeMonateProJahr() {
        return monateProJahr;
    }

    public int gebeTageProMonat() {
        return tageProMonat;
    }

    public int gebeTageProWoche() {
        return tageProWoche;
    }

    @Override
    public String toString() {
        return "StatischeChronologie{" +
                "jahrNull=" + jahrNull +
                ", monatNull=" + monatNull +
                ", wocheNull=" + wocheNull +
                ", tagNull=" + tagNull +
                ", monateProJahr=" + monateProJahr +
                ", tageProMonat=" + tageProMonat +
                ", tageProWoche=" + tageProWoche +
                '}';
    }
}
