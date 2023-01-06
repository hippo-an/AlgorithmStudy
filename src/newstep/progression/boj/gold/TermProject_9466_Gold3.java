package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TermProject_9466_Gold3 {

    private static int[] graph;
    private static boolean[] selected;
    private static boolean[] done;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            graph = new int[n + 1];
            selected = new boolean[n + 1];
            done = new boolean[n + 1];
            ans = 0;

            for (int i = 1; i <= n; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!selected[i]) {
                    dfs(i);
                }
            }

            sb.append(n - ans)
                .append("\n");

        }

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int idx) {
        selected[idx] = true;
        if (!selected[graph[idx]]) {
            dfs(graph[idx]);
        } else {
            int temp = graph[idx];
            while (!done[temp]) {
                done[temp] = true;
                ans++;
                temp = graph[temp];
            }
        }
        done[idx] = true;
    }

}
