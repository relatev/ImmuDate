package Chronologies;

import Units.Month;
import Units.Week;
import Units.Year;

public class JulianChronology extends Chronology {

    public JulianChronology(ChronologicalZero zero, ChronologicalDomain domain) {
        super(zero, domain);
    }

    @Override
    public int getMonthsOfYear(Year year) {
        return 0;
    }

    @Override
    public int getWeeksOfYear(Year year) {
        return 0;
    }

    @Override
    public int getDaysOfMonth(Month month) {
        return 0;
    }

    @Override
    public int getDaysOfWeek(Week week) {
        return 0;
    }

    @Override
    boolean isLeapYear() {
        return false;
    }

    @Override
    boolean isLeapMonth() {
        return false;
    }

    @Override
    boolean isLeapWeek() {
        return false;
    }

    @Override
    boolean isLeapDay() {
        return false;
    }
}
