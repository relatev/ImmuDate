package Units;

import Chronologies.ChronologicalDomain;
import Chronologies.Chronology;
import Exceptions.ValueOutOfDomainException;

import java.util.Iterator;

abstract class ChronologicalUnit<A extends ChronologicalUnit> implements Comparable<ChronologicalUnit>, Iterator<ChronologicalUnit> {
    public enum Direction{UP, DOWN}

    public final long VALUE;
    public final ChronologicalDomain DOMAIN;

    public final A SUPERIOR;
    public final Chronology CHRONO;

    private Direction direct = Direction.UP;

    public ChronologicalUnit(long value, ChronologicalDomain domain, A superior, Chronology chrono) throws ValueOutOfDomainException {
        this.VALUE = value;
        this.DOMAIN = domain;

        this.SUPERIOR = superior;
        this.CHRONO = chrono;

        if(!valid())
            throw new ValueOutOfDomainException(VALUE, DOMAIN);
    }

    public abstract boolean valid();

    @Override
    public boolean hasNext() {
        boolean hasNext = false;

        switch (direct) {
            case UP: hasNext = hasLatter(); break;
            case DOWN: hasNext = hasFormer(); break;
        }

        return hasNext;
    }

    boolean hasFormer() {
        return VALUE > Long.MIN_VALUE;
    }

    boolean hasLatter() {
        return VALUE < Long.MAX_VALUE;
    }

    @Override
    public ChronologicalUnit next() {
        ChronologicalUnit next = null;

        switch (direct) {
            case UP: next = latter(); break;
            case DOWN: next = former(); break;
        }

        return next;
    }

    abstract ChronologicalUnit former();

    abstract ChronologicalUnit latter();

    public Direction gebeDirect() {
        return direct;
    }

    public void setDirect(Direction direct) {
        this.direct = direct;
    }

    @Override
    public String toString() {
        return "ChronologicalUnit{" +
                "VALUE=" + VALUE +
                ", DOMAIN=" + DOMAIN +
                ", SUPERIOR=" + SUPERIOR +
                ", CHRONO=" + CHRONO +
                ", direct=" + direct +
                '}';
    }
}
