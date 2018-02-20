import Chronologien.Chronologie;
import Chronologien.GregorianischeChronologie;
import Chronologien.StatischeChronologie;
import Datum.*;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

public class DatumTest {

    @Test (expected = IllegalArgumentException.class)
    public void jahrSollteNichtValidiertWerden() {
        Chronologie chrono = new GregorianischeChronologie();

        new Datum(chrono, chrono.gebeJahrNull() - 1, chrono.gebeMonatNull(), chrono.gebeTagNull());
    }

    @Test (expected = IllegalArgumentException.class)
    public void monatSollteNichtValidiertWerden() {
        Chronologie chrono = new GregorianischeChronologie();

        new Datum(chrono, chrono.gebeJahrNull(), chrono.gebeMonatNull() - 1, chrono.gebeTagNull());
    }

    @Test (expected = IllegalArgumentException.class)
    public void tagNullSollteNichtValidiertWerden() {
        Chronologie chrono = new GregorianischeChronologie();

        new Datum(chrono, chrono.gebeJahrNull(), chrono.gebeMonatNull(), chrono.gebeTagNull() - 1);
    }

    @Test
    public void umgerechnetesDatumSollteGleichLangWieAusgangsdatumSein()  {
        Datum datum1 = new Datum(new GregorianischeChronologie());
        Datum datum2 = datum1.with(new GregorianischeChronologie());

        Assert.assertTrue("Datumsumrechnung nicht korrekt.", datum1.istGleich(datum2));
    }

    @Test
    public void differenzSollteKorrektBerechnetWerden() {
        Datum datum1 = new Datum(new GregorianischeChronologie(), -1, 1, 1);
        Datum datum2 = new Datum(new GregorianischeChronologie(), 400, 12,31);
        Periode differenz = datum1.differenz(datum2);

        Assert.assertTrue("Datumsdifferenz nicht korrekt.", differenz.gebeLaenge() == 146461);
    }

}
