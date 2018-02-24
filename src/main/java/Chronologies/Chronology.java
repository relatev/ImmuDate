package Chronologies;

import Units.Month;
import Units.Week;
import Units.Year;

public abstract class Chronology {

    public final ChronologicalZero ZERO;
    public final ChronologicalDomain DOMAIN;

    Chronology(ChronologicalZero zero, ChronologicalDomain domain) {
        this.ZERO = zero;
        this.DOMAIN = domain;
    }

    public abstract int getMonthsOfYear(Year year);

    public abstract int getWeeksOfYear(Year year);

    public abstract int getDaysOfMonth(Month month);

    public abstract int getDaysOfWeek(Week week);

    abstract boolean isLeapYear();

    abstract boolean isLeapMonth();

    abstract boolean isLeapWeek();

    abstract boolean isLeapDay();

}
