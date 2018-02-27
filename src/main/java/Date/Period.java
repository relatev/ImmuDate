package Date;

import Date.Chronologies.ChronologicalZero;
import Date.Chronologies.Chronology;
import Date.Date;
import Date.Units.Day;
import Date.Units.Month;
import Date.Units.Week;
import Date.Units.Year;
import Date.Utils.OrientedIterator.Orientation;

public class Period {

    public final Date START;
    public final Date END;

    public final long VALUE;

    public Period(Date start, Date end) {
        this.START = start;
        this.END = end;
        this.VALUE = END.toDays(START);
    }

    public Period(Date start) {
        this(start, new Date(start.CHRONO));
    }

    public Date toDate(Chronology chrono) {
        long days = VALUE;
        Orientation orient = days > 0? Orientation.UP : Orientation.DOWN;

        if(days == 0)
            return new Date(chrono);

        Year year = new Year(chrono);
        Month month = new Month(year, chrono);
        Day day = new Day(month, chrono);

        while(Math.abs(days / chrono.getDaysOfYear(year)) >= 1) {
            year = year.next(orient);
            days += orient == Orientation.UP? -chrono.getDaysOfYear(year) : chrono.getDaysOfYear(year);
        }

        while(Math.abs(days / chrono.getDaysOfMonth(month)) >= 1) {
            month = month.next(orient);
            days += orient == Orientation.UP? -chrono.getDaysOfMonth(month) : chrono.getDaysOfMonth(month);
        }

        while(Math.abs(days / 1) >= 1) {
            day = day.next(orient);
            days += orient == Orientation.UP? -1 : 1;
        }

        return new Date(chrono, year, month, day);
    }

}
