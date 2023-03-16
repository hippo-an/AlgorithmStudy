package newstep.progression.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compression {

    public static void main(String[] args) {
        Compression c = new Compression();
        int[] kakaos = c.solution("TOBEORNOTTOBEORTOBEORNOT");
        System.out.println(Arrays.toString(kakaos));

    }

    public int[] solution(String msg) {
        Map<String, Integer> map = initMap();

        List<Integer> ret = new ArrayList<>();

        int l = 0;
        int r = 0;
        StringBuilder sb;

        while (l < msg.length() && r < msg.length()) {
            sb = new StringBuilder(String.valueOf(msg.charAt(l)));
            while (r + 1 < msg.length() && map.containsKey(sb.toString())) {
                r++;
                sb.append(msg.charAt(r));
            }

            if (map.containsKey(sb.toString())) {
                ret.add(map.get(sb.toString()));
                r++;
            } else {
                String key = sb.substring(0, sb.length() - 1);
                ret.add(map.get(key));
                l = r;
            }


            map.putIfAbsent(sb.toString(), map.size() + 1);
        }


        int[] ans = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            ans[i] = ret.get(i);
        }

        return ans;
    }

    private Map<String, Integer> initMap() {
        Map<String, Integer> map = new HashMap<>();
        for (char a = 'A'; a <= 'Z'; a++) {
            map.put(String.valueOf(a), a - 'A' + 1);
        }
        return map;
    }
}
