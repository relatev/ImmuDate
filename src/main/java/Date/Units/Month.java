package Date.Units;

import Date.Chronologies.Chronology;
import Date.Exceptions.ValueOutOfDomainException;

public class Month extends ChronologicalUnit<Month, Year> {

    public Month(long value, Year superior, Chronology chrono) throws ValueOutOfDomainException {
        super(value,
                ChronologicalDomain.ofRange(chrono.ZERO.MONTH_ZERO, chrono.getMonthsOfYear(superior)),
                superior,
                chrono);
    }

    public Month(Year superior, Chronology chrono) {
        this(chrono.ZERO.MONTH_ZERO, superior, chrono);
    }

    @Override
    Month former() {
        Month next;

        try {
            next = copyWith(VALUE - 1);
        }catch(ValueOutOfDomainException e) {
            next = copyWith(CHRONO.getMonthsOfYear(SUPERIOR.former()), SUPERIOR.former());
        }

        return next;
    }

    @Override
    Month latter() {
        Month next;

        try {
            next = copyWith(VALUE + 1);
        }catch (ValueOutOfDomainException e) {
            next = copyWith(CHRONO.ZERO.MONTH_ZERO, SUPERIOR.latter());
        }

        return next;
    }

    @Override
    Month copyWith(long value, Year superior) {
        return new Month(value, superior, CHRONO);
    }

    @Override
    public int compareTo(Month other) {
        return Long.compare(VALUE, other.VALUE);
    }
}
