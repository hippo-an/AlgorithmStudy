package newstep.progression.leet;

public class LongestPalindromicSubstring_5_Medium {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String ans = "";
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    String sub = s.substring(i, j + 1);
                    if (sub.length() > max && isPalindrome(sub)) {
                        ans = sub;
                        max = sub.length();
                    }
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(String sub) {
        int length = sub.length();
        for (int i = 0; i < length / 2; i++) {
            if (sub.charAt(i) != sub.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private int lo, maxLen;

    public String longestPalindromeBp(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
