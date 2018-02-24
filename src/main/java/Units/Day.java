package Units;

import Chronologies.ChronologicalDomain;
import Chronologies.Chronology;
import Exceptions.ValueOutOfDomainException;

public class Day extends ChronologicalUnit<Month> {

    public Day(long value, Month superior, Chronology chrono) throws ValueOutOfDomainException {
        super(value,
                ChronologicalDomain.ofRange(chrono.ZERO.DAY_ZERO, chrono.getDaysOfMonth(superior)),
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
