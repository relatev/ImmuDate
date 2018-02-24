package Units;

import Chronologies.ChronologicalDomain;
import Chronologies.Chronology;
import Exceptions.ValueOutOfDomainException;

public class Month extends ChronologicalUnit<Year> {

    public Month(long value, Year superior, Chronology chrono) throws ValueOutOfDomainException {
        super(value,
                ChronologicalDomain.ofRange(chrono.ZERO.MONTH_ZERO, chrono.getMonthsOfYear(superior)),
                superior,
                chrono);
    }

    @Override
    public boolean valid() {
        return DOMAIN.isDefined(VALUE);
    }

    @Override
    ChronologicalUnit former() {
        return null;
    }

    @Override
    ChronologicalUnit latter() {
        return null;
    }

    @Override
    public int compareTo(ChronologicalUnit chronologicalUnit) {
        return 0;
    }
}
