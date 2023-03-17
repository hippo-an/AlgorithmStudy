package newstep.progression.hackerrank.preperation;

import java.util.List;

public class SimpleArraySum {
    public static int simpleArraySum(List<Integer> ar) {
        int ans = 0;
        for (int element : ar) {
            ans += element;
        }
        return ans;
    }
}
