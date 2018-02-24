package Units;

import Chronologies.ChronologicalDomain;
import Chronologies.Chronology;
import Exceptions.ValueOutOfDomainException;

public class Year extends ChronologicalUnit<Year> {

    public Year(long value, Chronology chrono) throws ValueOutOfDomainException {
        super(value, chrono.DOMAIN, null, chrono);
    }

    @Override
    public boolean valid() {
        long zero = CHRONO.ZERO.YEAR_ZERO;

        if(!DOMAIN.isDefined(VALUE))
            return false;

        if(zero == 0)
            return true;

        if(zero > 0 && VALUE < 0 || VALUE >= zero)
            return true;

        if(zero < 0 && VALUE <= zero || VALUE > 0)
            return true;

        return false;
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
