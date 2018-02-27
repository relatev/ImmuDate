package Date.Exceptions;

import Date.Units.ChronologicalDomain;

public class ValueOutOfDomainException extends RuntimeException {

    public ValueOutOfDomainException(long value, ChronologicalDomain domain) {
        super("Value " + value + " is undefined for " + domain);
    }

}
