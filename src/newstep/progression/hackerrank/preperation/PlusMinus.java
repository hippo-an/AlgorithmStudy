package newstep.progression.hackerrank.preperation;

import java.util.List;

public class PlusMinus {
    public static void plusMinus(List<Integer> arr) {
        int[] ret = new int[3];
        for (Integer element : arr) {
            if (element > 0) {
                ret[0]++;
            } else if (element == 0) {
                ret[2]++;
            } else {
                ret[1]++;
            }
        }

        double length = (double)arr.size();

        System.out.printf("%.6f\n", ret[0] / length);
        System.out.printf("%.6f\n", ret[1] / length);
        System.out.printf("%.6f\n", ret[2] / length);
    }

}
