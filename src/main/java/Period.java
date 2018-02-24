import Units.Day;

public class Period {

    public final Date START;
    public final Date END;

    private final long DIFFERENCE;

    public Period(Date start, Date end, long difference) {
        this.START = start;
        this.END = end;
        this.DIFFERENCE = difference;
    }
}
