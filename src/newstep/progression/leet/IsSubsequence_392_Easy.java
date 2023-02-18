package newstep.progression.leet;

public class IsSubsequence_392_Easy {
    public boolean isSubsequence(String s, String t) {
        int idx = 0;
        int matchingCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (idx < t.length()) {
                if (t.charAt(idx) == c) {
                    idx++;
                    matchingCount++;
                    break;
                }

                idx++;
            }
        }

        return matchingCount == s.length();
    }

}
