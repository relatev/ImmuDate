import Chronologies.ChronologicalZero;
import Chronologies.Chronology;
import Chronologies.StaticChronology;
import Exceptions.ValueOutOfDomainException;
import Units.Day;
import Units.Month;
import Units.Year;

public class Main {

    public static void main(String[] args) {
        Day day = null;
        try {
            day = new Day(1, new Month(6, null, new StaticChronology()), new StaticChronology());
        } catch (ValueOutOfDomainException e) {
            e.printStackTrace();
        }
    }

}
