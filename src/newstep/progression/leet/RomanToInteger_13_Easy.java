package newstep.progression.leet;

public class RomanToInteger_13_Easy {
    public int romanToIntMy(String s) {

        int length = s.length();

        if (length == 1) {
            return parseRomanToInteger(s.charAt(0));
        }

        int ans = 0;
        int i = 0;
        for (; i < length - 1;) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);

            if (inPattern(first, second)) {
                ans += calculateInPattern(first, second);
                i += 2;
            } else {
                ans += parseRomanToInteger(first);
                i++;
            }
        }

        if (i != length) {
            ans += parseRomanToInteger(s.charAt(i));
        }

        return ans;
    }

    private boolean inPattern(char first, char second) {
        if (first == 'I' && (second == 'V' || second == 'X')) {
            return true;
        } else if (first == 'X' && (second == 'L' || second == 'C')) {
            return true;
        } else if (first == 'C' && (second == 'D' || second == 'M')) {
            return true;
        }

        return false;
    }

    private int calculateInPattern(char first, char second) {
        return parseRomanToInteger(second) - parseRomanToInteger(first);
    }

    private int parseRomanToInteger(char x) {
        switch (x) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    public int romanToIntBp(String s) {
        int ans = 0;
        int num = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            num = parseRomanToInteger(s.charAt(i));

            if (num < prev) {
                ans -= num;
            } else {
                ans += num;
            }
            prev = num;
        }
        return ans;
    }
}
