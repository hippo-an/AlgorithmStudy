package newstep.progression.codewars;

public class VowelCount_7kyu {
    public static int getCount(String str) {
        int ans = 0;
        for (char c : str.toCharArray()) {
            ans += c == 'e' || c == 'a' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0;
        }

        return ans;
    }

    public static int getCountBP(String str) {
        return str.replaceAll("(?i)[^aeiou]", "").length();
    }

    public static int getCountCV(String str) {
        return (int) str.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

}
