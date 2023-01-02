package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PermutationCycle_10451_Silver2 {

    private static int N;
    private static int[] graph;
    private static boolean[] selected;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph = new int[N + 1];
            selected = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (!selected[i]) {
                    cnt += dfs(i, i, graph[i]);
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
        br.close();

    }

    private static int dfs (int start, int idx, int current) {
        int ret = 0;
        selected[idx] = true;

        if (start == current) {
            return ret + 1;
        } else {
            if (!selected[graph[idx]]) {
                ret += dfs(start, graph[idx], graph[current]);
            }
        }
        return ret;
    }
}
