package Chronologien;

public abstract class Chronologie {

    public abstract int gebeMonateImJahr(long jahr) throws IllegalArgumentException;

    public abstract int gebeWochenImJahr(long jahr) throws IllegalArgumentException;

    public abstract int gebeTageImJahr(long jahr) throws IllegalArgumentException;

    public abstract int gebeTageImMonat(long jahr, int monat) throws IllegalArgumentException;

    public abstract int gebeTageInWoche(long jahr, int woche) throws IllegalArgumentException;

    public abstract boolean istSchaltjahr(long jahr) throws IllegalArgumentException;

    public abstract boolean istSchaltmonat(long jahr, int monat) throws IllegalArgumentException;

    public abstract boolean istSchaltwoche(long jahr, int woche);

    public abstract boolean istSchalttag(long jahr, int monat, int tag) throws IllegalArgumentException;

    public abstract long gebeJahrNull();

    public abstract int gebeMonatNull();

    public abstract int gebeWocheNull();

    public abstract int gebeTagNull();

    public boolean validesJahr(long jahr) {
        return jahr < 0  || jahr >= this.gebeJahrNull();
    }

    public boolean validerMonat(long jahr, int monat) {
        return monat >= this.gebeMonatNull() && monat <= this.gebeMonateImJahr(jahr);
    }

    public boolean validerTag(long jahr, int monat, int tag) {
        return tag >= this.gebeMonatNull() && tag <= this.gebeTageImMonat(jahr, monat);
    }

    public boolean valideWoche(long jahr, int woche) {
        return woche >= this.gebeWocheNull() && woche <= this.gebeWochenImJahr(jahr);
    }

}
