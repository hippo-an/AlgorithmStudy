package newstep.progression.leet;

public class FirstBadVersion_278_Easy {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;

        while (l <= n) {
            int m = (l + n) / 2;

            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return r;
    }

    private boolean isBadVersion(int m) {
        return false;
    }
}
