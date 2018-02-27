package Date.Units;

import Date.Chronologies.Chronology;
import Date.Exceptions.ValueOutOfDomainException;
import Date.Utils.OrientedIterator;

public abstract class ChronologicalUnit<I extends ChronologicalUnit, S extends ChronologicalUnit> implements Comparable<I>, OrientedIterator<I> {

    public final long VALUE;
    public final ChronologicalDomain DOMAIN;

    public final S SUPERIOR;
    public final Chronology CHRONO;

    ChronologicalUnit(long value, ChronologicalDomain domain, S superior, Chronology chrono) throws ValueOutOfDomainException {
        this.VALUE = value;
        this.DOMAIN = domain;

        this.SUPERIOR = superior;
        this.CHRONO = chrono;

        if(!valid())
            throw new ValueOutOfDomainException(VALUE, DOMAIN);
    }

    public boolean valid() {
        return DOMAIN.isDefined(VALUE);
    }

    @Override
    public boolean hasNext(Orientation orient) {
        boolean hasNext = false;

        switch (orient) {
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
    public I next(Orientation orient) {
        I next = null;

        if(!hasNext(orient))
            throw new IndexOutOfBoundsException();

        switch (orient) {
            case UP: next = latter(); break;
            case DOWN: next = former(); break;
        }

        return next;
    }

    abstract I former();

    abstract I latter();

    abstract I copyWith(long value, S superior);

    I copyWith(long value) {
        return copyWith(value, SUPERIOR);
    }

    @Override
    public String toString() {
        return "ChronologicalUnit{" +
                "VALUE=" + VALUE +
                ", DOMAIN=" + DOMAIN +
                ", SUPERIOR=" + SUPERIOR +
                ", CHRONO=" + CHRONO +
                '}';
    }
}
