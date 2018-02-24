import Chronologies.Chronology;
import Units.Day;
import Units.Month;
import Units.Year;
import org.omg.CORBA.DATA_CONVERSION;

public class Date {

    public final Chronology CHRONO;

    public final Year YEAR;
    public final Month MONTH;
    public final Day DAY;

    public Date(Chronology chrono, Year year, Month month, Day day) {
        this.CHRONO = chrono;
        this.YEAR = year;
        this.MONTH = month;
        this.DAY = day;
    }

    public Period substract(Date date) {
        return null;
    }

    public Period add(Date date) {
        return null;
    }

}
