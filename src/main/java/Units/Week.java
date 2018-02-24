package Units;

import Chronologies.ChronologicalDomain;
import Chronologies.Chronology;
import Exceptions.ValueOutOfDomainException;

public class Week extends ChronologicalUnit<Year> {

    public Week(long value, Year superior, Chronology chrono) throws ValueOutOfDomainException {
        super(value,
                ChronologicalDomain.ofRange(chrono.ZERO.WEEK_ZERO, chrono.getWeeksOfYear(superior)),
                superior,
                chrono);
    }

    @Override
    public boolean valid() {
        return VALUE >= CHRONO.ZERO.WEEK_ZERO
                && VALUE <= CHRONO.getWeeksOfYear(SUPERIOR);
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
