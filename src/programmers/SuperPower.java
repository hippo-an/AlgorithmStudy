package programmers;

import java.util.*;

public class SuperPower {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> m = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            m.put(id_list[i], i);
        }

        Map<String, Set<String>> c = new HashMap<>();

        for (String s : report) {
            String[] s1 = s.split(" ");
            Set<String> hs = c.getOrDefault(s1[1], new HashSet<>());
            hs.add(s1[0]);
            c.put(s1[1], hs);
        }

        for (String s : id_list) {
            Set<String> strings = c.get(s);
            if (strings == null || strings.isEmpty()) {
                continue;
            }

            if (strings.size() >= k) {
                for (String string : strings) {
                    answer[m.get(string)]++;
                }
            }
        }

        return answer;
    }
}
