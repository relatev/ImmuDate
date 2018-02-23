package Datum;

import Chronologien.Chronologie;

public class Datum {

    private final Chronologie chrono;
    private final long jahr;
    private final int monat;
    private final int tag;

    public Datum(Chronologie chrono, long jahr, int monat, int tag) {
        this.chrono = chrono;

        this.jahr = jahr;
            if(!chrono.validesJahr(jahr))
                throw new IllegalArgumentException("Das Jahr " + jahr + " ist undefiniert.");

        this.monat = monat;
            if(!chrono.validerMonat(jahr, monat))
                throw new IllegalArgumentException("Monat darf nicht " + chrono.gebeMonateImJahr(jahr) + " überschreiten.");

        this.tag = tag;
            if(!chrono.validerTag(jahr, monat, tag))
                throw new IllegalArgumentException("Tag darf " + chrono.gebeTageImMonat(jahr, monat) + " nicht überschreiten.");

    }

    public Datum(Chronologie chrono) {
        this(chrono, chrono.gebeJahrNull(), chrono.gebeMonatNull(), chrono.gebeTagNull());
    }

    public boolean istSchaljahr() {
        return this.gebeChrono().istSchaltjahr(this.gebeJahr());
    }

    public boolean istSchaltmonat() {
        return this.gebeChrono().istSchaltmonat(this.gebeJahr(), this.gebeMonat());
    }

    public boolean istSchaltwoche() {
        return this.gebeChrono().istSchaltwoche(this.gebeJahr(), this.gebeWoche());
    }

    public boolean istSchalttag() {
        return this.gebeChrono().istSchalttag(this.gebeJahr(), this.gebeMonat(), this.gebeTag());
    }

    public boolean istVorJahrNull() {
        return this.gebeJahr() < this.gebeChrono().gebeJahrNull();
    }

    public boolean istVor(Datum datum) {
        if(!this.gleicheChronoWie(datum))
            datum = datum.mit(this.gebeChrono());

        return this.gebeJahr() <= datum.gebeJahr()
                && this.gebeMonat() <= datum.gebeMonat()
                && this.gebeTag() < datum.gebeTag();
    }

    public boolean istGleich(Datum datum) {
        if(!this.gleicheChronoWie(datum))
            datum = datum.mit(this.gebeChrono());

        return this.gebeJahr() == datum.gebeJahr()
                && this.gebeMonat() == datum.gebeMonat()
                && this.gebeTag() == datum.gebeTag();
    }

    public Periode differenz(Datum datum) {
        if(!this.gleicheChronoWie(datum))
            datum = datum.mit(this.gebeChrono());

        if(this.istVor(datum))
            return new Periode(this, datum);
        else
            return new Periode(datum, this);
    }

    public Datum mit(Chronologie chrono) {
        return new Periode(this).zuDatum(chrono);
    }

    protected long zuTagen() {
        return zuTagen(this.gebeJahr());
    }

    protected long zuTagen(long referenzJahr) {
        if(!this.gebeChrono().validesJahr(referenzJahr))
            throw new IllegalArgumentException("Das Jahr " + referenzJahr + " ist undefiniert.");

        // Addiert die Tage zwischen dem tagNull der Chronologie und dem Tag des Datums.
        int tage = this.gebeTag() - this.gebeChrono().gebeTagNull();

        // Iteriert durch alle Monate zwischen dem monatNull der Chronologie und dem Monat des Datums.
        for(int cMonat = this.gebeChrono().gebeMonatNull(); cMonat < this.gebeMonat(); cMonat++)
            // Addiert die Tage des aktuellen cMonats.
            tage += this.gebeChrono().gebeTageImMonat(this.gebeJahr(), cMonat);

        // Iteriert durch alle Jahre zwischen dem refrenz Jahr und dem Jahr des Datums.
        for(long cJahr = referenzJahr; cJahr < this.gebeJahr();
            // Überspringt Jahre zwischen 0 und jahrNull der Chronologie.
            cJahr = (cJahr == -1? this.gebeChrono().gebeJahrNull() : cJahr + 1))
                // Addiert die Tage des aktuellen cJahrs.
                tage += this.gebeChrono().gebeTageImJahr(cJahr);

        return tage;
    }

    public Chronologie gebeChrono() {
        return this.chrono;
    }

    public long gebeJahr() {
        return this.jahr;
    }

    public int gebeMonat() {
        return this.monat;
    }

    public int gebeWoche() {
        long tage = this.zuTagen(this.gebeJahr());
        int woche = this.gebeChrono().gebeWocheNull();

        // Überprüft ob die Länge einer Woche in tage passt.
        while(tage / this.gebeChrono().gebeTageInWoche(this.gebeJahr(), woche) >= 1) {
            // Addiert eins zu woche und subtrahiert die Länge der Woche von tage.
            tage -= this.gebeChrono().gebeTageInWoche(this.gebeJahr(), woche); woche++;
        }

        return woche;
    }

    public int gebeTag() {
        return this.tag;
    }

    public boolean gleicheChronoWie(Datum datum) {
        return this.gebeChrono().getClass().equals(datum.gebeChrono().getClass());
    }

    @Override
    public String toString() {
        return "Datum{" +
                "chrono=" + chrono +
                ", jahr=" + jahr +
                ", monat=" + monat +
                ", tag=" + tag +
                '}';
    }
}
