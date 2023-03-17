package newstep.progression.hackerrank.preperation;

import java.util.List;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int sumA = 0;
        int sumB = 0;

        int n = arr.size();
        for (int i = 0; i < n; i++) {
            sumA += arr.get(i).get(i);
            sumB += arr.get(i).get(n - i - 1);
        }

        return Math.abs(sumA - sumB);
    }
}
