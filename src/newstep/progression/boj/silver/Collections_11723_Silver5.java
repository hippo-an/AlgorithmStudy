package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Collections_11723_Silver5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    int o = Integer.parseInt(st.nextToken());
                    if (set.contains(o)) set.remove(o);
                    else set.add(o);
                    break;
                case "all":
                    for (int k = 1;k <= 20; k ++) {
                        set.add(k);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        System.out.println(sb);
    }
}
