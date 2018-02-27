package Date;

import Date.Chronologies.Chronology;
import Date.Chronologies.GregorianChronology;
import Date.Units.*;
import Date.Utils.OrientedIterator.Orientation;

import java.util.function.Function;

public class Date implements Comparable<Date> {

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

    public Date(Chronology chrono, long year, long month, long day) {
        this.CHRONO = chrono;
        this.YEAR = new Year(year, CHRONO);
        this.MONTH = new Month(month, YEAR, CHRONO);
        this.DAY = new Day(day, MONTH, CHRONO);
    }

    public Date(Chronology chrono, Year year) {
        this(chrono, year.VALUE,
                chrono.ZERO.MONTH_ZERO,
                chrono.ZERO.DAY_ZERO);
    }

    public Date(Chronology chrono) {
        this(chrono, chrono.ZERO.YEAR_ZERO,
                chrono.ZERO.MONTH_ZERO,
                chrono.ZERO.DAY_ZERO);
    }

    public boolean isLeapYear() {
        return CHRONO.isLeapYear(YEAR);
    }

    public boolean isLeapMonth() {
        return CHRONO.isLeapMonth(MONTH);
    }

    public boolean isLeapDay() {
        return CHRONO.isLeapDay(DAY);
    }

    public boolean before(Date other) {
        if(!CHRONO.equals(other.CHRONO))
            other = other.with(CHRONO);

        return this.YEAR.compareTo(other.YEAR) == -1
                || this.YEAR.compareTo(other.YEAR) == 0
                && (this.MONTH.compareTo(other.MONTH) == -1
                || (this.MONTH.compareTo(other.MONTH) == 0 && this.DAY.compareTo(other.DAY) == -1));
    }

    public boolean at(Date other) {
        if(!CHRONO.equals(other.CHRONO))
            other = other.with(CHRONO);

        return this.YEAR.compareTo(other.YEAR) == 0
                && this.MONTH.compareTo(other.MONTH) == 0
                && this.DAY.compareTo(other.DAY) == 0;
    }

    public boolean after(Date other) {
        if(CHRONO.equals(other.CHRONO))
            other = other.with(CHRONO);

        return !this.at(other) && !this.before(other);
    }

    public long toDays(Date reference) {
        if(!CHRONO.equals(reference.CHRONO))
            reference = reference.with(CHRONO);

        if(this.at(reference))
            return 0;

        Orientation orient = this.before(reference)? Orientation.UP : Orientation.DOWN;
        long days = 0;

        for(Day counter = this.DAY;
            !counter.toDate().at(reference);
            counter = counter.next(orient))
                days += 1;

        return orient == Orientation.UP? days : -days;
    }

    public Date with(Chronology chrono) {
        return new Period(this).toDate(chrono);
    }

    @Override
    public int compareTo(Date other) {
        if(this.before(other))
            return -1;
        if(this.at(other))
            return 0;
        else // if(this.after(other)
            return 1;
    }

    @Override
    public String toString() {
        return "Date{" +
                "CHRONO=" + CHRONO +
                ", YEAR=" + YEAR.VALUE +
                ", MONTH=" + MONTH.VALUE +
                ", DAY=" + DAY.VALUE +
                '}';
    }
}
