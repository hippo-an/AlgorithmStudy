package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Task_21937_Silver1 {
    private static int N, M, X;
    private static int ans = 0;
    private static List<Integer>[] graph;
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            graph[x].add(y);
        }

        X = Integer.parseInt(br.readLine());

        dfs(X);
        System.out.println(ans);
        br.close();
    }

    private static void dfs(int idx) {
        List<Integer> nodes = graph[idx];
        if (nodes.isEmpty()) {
            return;
        }

        for (Integer node : nodes) {
            if (!visited[node]) {
                visited[node] = true;
                ans++;
                dfs(node);
            }
        }
    }

}
