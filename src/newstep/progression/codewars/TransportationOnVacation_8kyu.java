package newstep.progression.codewars;

public class TransportationOnVacation_8kyu {

    private static final int DAILY_COST = 40;
    public static int rentalCarCost(int d) {
        int off = 20;
        if (d < 3) {
            off = 0;
        } else if (d >= 7) {
            off = 50;
        }
        return d * DAILY_COST - off;
    }

}
