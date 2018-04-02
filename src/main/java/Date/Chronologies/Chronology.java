package Date.Chronologies;

import Date.Date;
import Date.Units.*;

import java.util.Objects;

public abstract class Chronology {

    public final ChronologicalZero ZERO;

    Chronology(ChronologicalZero zero) {
        this.ZERO = zero;
    }

    public abstract int getMonthsOfYear(Year year);

    public abstract int getWeeksOfYear(Year year);

    public abstract int getDaysOfYear(Year year);

    public abstract int getDaysOfMonth(Month month);

    public abstract int getDaysOfWeek(Week week);

    public abstract boolean isLeapYear(Year year);

    public abstract boolean isLeapMonth(Month month);

    public abstract boolean isLeapWeek(Week week);

    public abstract boolean isLeapDay(Day day);

    public boolean equals(Chronology other) {
        return getClass().equals(other.getClass());
    }

}
