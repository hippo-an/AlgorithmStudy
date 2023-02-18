package newstep.progression.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * 하나의 캐릭터에 대해 절대적인 값 (예를 들면 loop 의 인덱스) 을 매핑시키는 것이 포인트
 */
public class IsomorphicStrings_205_Easy {

    public boolean isIsomorphic1(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (map.containsKey(sChar)) {
                if (!map.get(sChar).equals(tChar)) {
                    return false;
                }
            } else {
                for (Character c : map.values()) {
                    if (c.equals(tChar)) {
                        return false;
                    }
                }

                map.put(sChar, tChar);
            }
        }

        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        int[] sChecker = new int[200];
        int[] tChecker = new int[200];

        for (int i = 0; i < s.length(); i++) {
            int sIdx = s.charAt(i);
            int tIdx = t.charAt(i);

            if (sChecker[sIdx] != tChecker[tIdx]) {
                return false;
            }

            sChecker[sIdx] = i + 1;
            tChecker[tIdx] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings_205_Easy exec = new IsomorphicStrings_205_Easy();
        System.out.println(exec.isIsomorphic("bbbaaaba", "aaabbbba"));
    }
}
