package newstep.progression.hackerrank.preperation;

import java.util.ArrayList;
import java.util.List;

public class CompareTheTriplets {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int scoreA = 0;
        int scoreB = 0;

        for (int i = 0; i < a.size(); i++) {
            Integer numA = a.get(i);
            Integer numB = b.get(i);
            if (numA < numB) {
                scoreB++;
            } else if (numA > numB) {
                scoreA++;
            }
        }

        return List.of(scoreA, scoreB);
    }

}
