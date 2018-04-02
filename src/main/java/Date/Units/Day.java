package Date.Units;

import Date.Chronologies.Chronology;
import Date.Date;
import Date.Exceptions.ValueOutOfDomainException;

public class Day extends ChronologicalUnit<Day, Month> {

    public Day(long value, Month superior, Chronology chrono) throws ValueOutOfDomainException {
        super(value,
                ChronologicalDomain.ofRange(chrono.ZERO.DAY_ZERO, chrono.getDaysOfMonth(superior)),
                superior,
                chrono);
    }

    public Day(Month superior, Chronology chrono) {
        this(chrono.ZERO.DAY_ZERO, superior, chrono);
    }

    @Override
    Day former() {
        Day next;

        try {
            next = copyWith(VALUE - 1);
        }catch (ValueOutOfDomainException e) {
            next = copyWith(CHRONO.getDaysOfMonth(SUPERIOR.former()), SUPERIOR.former());
        }

        return next;
    }

    @Override
    Day latter() {
        Day next;

        try {
            next = copyWith(VALUE + 1);
        }catch (ValueOutOfDomainException e) {
            next = copyWith(CHRONO.ZERO.DAY_ZERO, SUPERIOR.latter());
        }

        return next;
    }

    public Date toDate() {
        return new Date(CHRONO, SUPERIOR.SUPERIOR, SUPERIOR, this);
    }

    @Override
    Day copyWith(long value, Month superior) {
        return new Day(value, superior, CHRONO);
    }

    @Override
    public int compareTo(Day other) {
        return Long.compare(VALUE, other.VALUE);
    }
}
