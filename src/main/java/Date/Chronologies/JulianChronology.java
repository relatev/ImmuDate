package Date.Chronologies;

import Date.Units.Day;
import Date.Units.Month;
import Date.Units.Week;
import Date.Units.Year;

import java.util.Arrays;

public class JulianChronology extends Chronology {

    public final int MONTHS_A_YEAR = 12;
    public final int WEEKS_A_YEAR = 52;
    public final int[] MIN_DAYS_A_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 , 31};
    public final int[] MAX_DAYS_A_MONTH = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 , 31};
    public final int DAYS_A_WEEK = 7;

    public JulianChronology() {
        super(new ChronologicalZero(1, 1,1 ,1));
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
        if(isLeapYear(year))
            return Arrays.stream(MAX_DAYS_A_MONTH).sum();
        else
            return Arrays.stream(MIN_DAYS_A_MONTH).sum();
    }


    @Override
    public int getDaysOfMonth(Month month) {
        if(isLeapYear(month.SUPERIOR))
            return MAX_DAYS_A_MONTH[(int) month.VALUE - 1];
        else
            return MIN_DAYS_A_MONTH[(int) month.VALUE - 1];
    }

    @Override
    public int getDaysOfWeek(Week week) {
        return DAYS_A_WEEK;
    }

    @Override
    public boolean isLeapYear(Year year) {
        return year.VALUE % 4 == 0;
    }

    @Override
    public boolean isLeapMonth(Month month) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isLeapWeek(Week week) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isLeapDay(Day day) {
        throw new UnsupportedOperationException();
    }
}
