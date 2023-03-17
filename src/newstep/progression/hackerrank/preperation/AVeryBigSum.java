package newstep.progression.hackerrank.preperation;

import java.util.List;

public class AVeryBigSum {

    public static long aVeryBigSum(List<Long> ar) {
        long ret = 0L;
        for (Long element : ar) {
            ret += element;
        }

        return ret;
    }
}
