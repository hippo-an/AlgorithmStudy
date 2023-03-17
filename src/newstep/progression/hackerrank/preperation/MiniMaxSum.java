package newstep.progression.hackerrank.preperation;

import java.util.List;

public class MiniMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
        long sum = 0L;
        for (Integer element : arr) {
            sum += element;
        }
        long[] minMax = new long[]{sum, 0};

        for (int i = 0; i < arr.size(); i++) {
            long e = sum - arr.get(i);
            if (e < minMax[0]) {
                minMax[0] = e;
            }
            if (e > minMax[1]) {
                minMax[1] = e;
            }
        }

        System.out.printf("%d %d", minMax[0], minMax[1]);
    }
}
