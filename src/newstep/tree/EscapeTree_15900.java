package newstep.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EscapeTree_15900 {
    private static int N, ans;
    private static List<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
        visited = new boolean[N + 1];

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1, 0);
        System.out.println(ans % 2 == 0 ? "No" : "Yes");
    }

    private static void dfs(int x, int d) {
        visited[x] = true;
        List<Integer> list = graph[x];
        if (x != 1 && list.size() == 1) {
            ans += d;
            return;
        }

        for (int nx : list) {
            if (!visited[nx]) dfs(nx, d + 1);
        }
    }
}
