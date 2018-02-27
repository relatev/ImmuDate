package Date.Chronologies;

import Date.Units.*;

public class StaticChronology extends Chronology {

    public final int MONTHS_A_YEAR = 12;
    public final int WEEKS_A_YEAR = 52;
    public final int DAYS_A_MONTH = 30;
    public final int DAYS_A_WEEK = 7;

    public StaticChronology() {
        super(new ChronologicalZero(0, 1,1, 1));
    }

    @Override
    public int getMonthsOfYear(Year year) {
        return MONTHS_A_YEAR;
    }

    @Override
    public int getWeeksOfYear(Year year) {
        return WEEKS_A_YEAR;
    }

    @Override
    public int getDaysOfYear(Year year) {
        return MONTHS_A_YEAR * DAYS_A_MONTH;
    }

    @Override
    public int getDaysOfMonth(Month month) {
        return DAYS_A_MONTH;
    }

    @Override
    public int getDaysOfWeek(Week week) {
        return DAYS_A_WEEK;
    }

    @Override
    public boolean isLeapYear(Year year) {
        return false;
    }

    @Override
    public boolean isLeapMonth(Month month) {
        return false;
    }

    @Override
    public boolean isLeapWeek(Week week) {
        return false;
    }

    @Override
    public boolean isLeapDay(Day day) {
        return false;
    }
}
