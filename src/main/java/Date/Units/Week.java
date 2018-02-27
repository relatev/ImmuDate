package Date.Units;

import Date.Chronologies.Chronology;
import Date.Exceptions.ValueOutOfDomainException;

public class Week extends ChronologicalUnit<Week, Year> {

    public Week(long value, Year superior, Chronology chrono) throws ValueOutOfDomainException {
        super(value,
                ChronologicalDomain.ofRange(chrono.ZERO.WEEK_ZERO, chrono.getWeeksOfYear(superior)),
                superior,
                chrono);
    }

    public Week(Year superior, Chronology chrono) {
        this(chrono.ZERO.WEEK_ZERO, superior, chrono);
    }

    @Override
    Week former() {
        Week next;

        try {
            next = copyWith(VALUE - 1);
        }catch (ValueOutOfDomainException e) {
            next = copyWith(CHRONO.getWeeksOfYear(SUPERIOR.former()), SUPERIOR.former());
        }

        return next;
    }

    @Override
    Week latter() {
        Week next;

        try {
            next = copyWith(VALUE + 1);
        }catch (ValueOutOfDomainException e) {
            next = copyWith(CHRONO.ZERO.WEEK_ZERO, SUPERIOR.latter());
        }

        return next;
    }

    @Override
    Week copyWith(long value, Year superior) {
        return new Week(value, superior, CHRONO);
    }

    @Override
    public int compareTo(Week other) {
        return Long.compare(VALUE, other.VALUE);
    }
}
