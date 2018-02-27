import Date.Chronologies.*;
import Date.Date;
import Date.Period;

public class Main {

    public static void main(String[] args) {
        Date d1 = new Date(new GregorianChronology(), 2018, 5, 30);
        Date d2 = new Date(new GregorianChronology(), 2015, 2, 20);

       System.out.print(new Period(d1, d2).VALUE);
    }

}
