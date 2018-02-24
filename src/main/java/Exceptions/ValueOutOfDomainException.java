package Exceptions;

import Chronologies.ChronologicalDomain;

public class ValueOutOfDomainException extends Exception {

    public ValueOutOfDomainException(long value, ChronologicalDomain domain) {
        super("Value " + value + " is undefined for " + domain);
    }

}
