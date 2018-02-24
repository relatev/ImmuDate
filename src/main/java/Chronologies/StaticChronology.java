package Chronologies;

import Units.Month;
import Units.Week;
import Units.Year;

public class StaticChronology extends Chronology {

    public StaticChronology() {
        super(new ChronologicalZero(1, 1,1, 1),
                new ChronologicalDomain());
    }

    @Override
    public int getMonthsOfYear(Year year) {
        return 12;
    }

    @Override
    public int getWeeksOfYear(Year year) {
        return 52;
    }

    @Override
    public int getDaysOfMonth(Month month) {
        return 30;
    }

    @Override
    public int getDaysOfWeek(Week week) {
        return 7;
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
