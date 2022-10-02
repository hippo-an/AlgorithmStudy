package newstep.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tree_4803 {
    private static int N, M, vc, ec;
    private static String MANY = "", one = "", no = "";
    private static StringBuilder sb = new StringBuilder();
    private static List<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int cnt = 1; ; cnt++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            graph = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                graph[y].add(x);
            }

            int tc = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    vc = 0;
                    ec = 0;

                    dfs(i);
                    if (vc == (ec / 2) + 1 && ec % 2 == 0) tc++;
                }
            }

            switch (tc) {
                case 0:
                    sb.append(String.format("Case %d: No trees.", cnt)).append("\n");
                    break;
                case 1:
                    sb.append(String.format("Case %d: There is one tree.", cnt)).append("\n");
                    break;
                default:
                    sb.append(String.format("Case %d: A forest of %d trees.", cnt, tc)).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    private static void dfs(int x) {
        vc++;
        ec += graph[x].size();
        visited[x] = true;

        for (int nx : graph[x]) {
            if (visited[nx]) {
                continue;
            }
            dfs(nx);
        }
    }
}
