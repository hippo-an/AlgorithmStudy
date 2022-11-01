package newstep.progression.programmers.level1;

import java.util.HashSet;
import java.util.Set;

public class Babbling1 {
    public static void main(String[] args) {

    }

    private static String[] base = {"", "aya", "ye", "woo", "ma" };
    private static int[] flag = new int[5];
    private static Set<String> baseList = new HashSet<>();

    public int solution(String[] babbling) {
        dfs(1);
        int answer = 0;

        System.out.println(baseList.toString());

        for (String s : babbling) {
            if (baseList.contains(s)) answer++;
        }
        return answer;
    }

    private void dfs(int k) {
        if (k == 5) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1;i <= 4; i++) {
                if (flag[i] > 0) sb.append(base[flag[i]]);
            }

            baseList.add(sb.toString());
        } else {
            outer: for (int i = 1; i <= 4; i++) {

                for (int j = 1; j < k; j++) {
                    if (flag[j] == i) continue outer;
                }

                flag[k] = i;
                dfs(k + 1);

                flag[k] = 0;
                dfs(k + 1);
            }
        }

    }

}
