package Chronologies;

public class ChronologicalDomain {

    public final long MIN;
    public final long MAX;

    public static ChronologicalDomain ofRange(int min, long range) {
        return new ChronologicalDomain(min, min + range);
    }

    public ChronologicalDomain(long min, long max) {
        this.MIN = min;
        this.MAX = max;
    }

    ChronologicalDomain() {
        this(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isDefined(long value) {
        return value >= MIN && value <= MAX;
    }

    @Override
    public String toString() {
        return "ChronologicalDomain{" +
                "MIN=" + MIN +
                ", MAX=" + MAX +
                '}';
    }
}
