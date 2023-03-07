package newstep.progression.leet;

public class LongestSubstringWithoutRepeatingCharacters_3_Medium {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] map = new int[128];

        int l = 0;
        int r = 0;

        while (l < s.length() && l <= r) {
            if (r < s.length() && map[s.charAt(r)] == 0) {
                map[s.charAt(r)] = 1;
                r++;
            } else {
                map[s.charAt(l)] = 0;
                l++;
            }
            ans = Math.max(ans, r - l);
        }

        return ans;
    }

}
