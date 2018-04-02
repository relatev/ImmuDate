package Date.Units;

import Date.Chronologies.Chronology;
import Date.Exceptions.ValueOutOfDomainException;

public class Year extends ChronologicalUnit<Year, Year> {

    public Year(long value, Chronology chrono) throws ValueOutOfDomainException {
        super(value, new ChronologicalDomain(), null, chrono);
    }

    public Year(Chronology chrono) {
        this(chrono.ZERO.YEAR_ZERO, chrono);
    }

    @Override
    public boolean valid() {
        long zero = CHRONO.ZERO.YEAR_ZERO;

        if(!DOMAIN.isDefined(VALUE))
            return false;

        if(zero > 0 && (VALUE < 0 || VALUE >= zero))
            return true;

        if(zero < 0 && (VALUE <= zero || VALUE > 0))
            return true;

        return zero == 0;
    }

    @Override
    Year former() {
        Year next;

        try {
            next = copyWith(VALUE - 1);

        }catch(ValueOutOfDomainException e) {
            next = copyWith(CHRONO.ZERO.YEAR_ZERO >= 0? -1 : CHRONO.ZERO.YEAR_ZERO);
        }

        return next;
    }

    @Override
    Year latter() {
        Year next;

        try {
            next = copyWith(VALUE + 1);

        }catch(ValueOutOfDomainException e) {
            next = copyWith(CHRONO.ZERO.YEAR_ZERO <= 0? 1 : CHRONO.ZERO.YEAR_ZERO);
        }

        return next;
    }

    @Override
    Year copyWith(long value, Year superior) {
        return new Year(value, CHRONO);
    }

    @Override
    public int compareTo(Year other) {
        return Long.compare(VALUE, other.VALUE);
    }
}
