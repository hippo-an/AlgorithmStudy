package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FindWay_11403 {
    private static List<Integer>[] graph;
    private static int[][] ans;
    private static int N;
    private static boolean flag;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ans = new int[N][N];
        graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int t = Integer.parseInt(st.nextToken());
                if (t > 0) graph[i].add(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited = new boolean[N];
                flag = false;
                dfs(i, j);
                if (flag) {
                    ans[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int a : ans[i]){
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void dfs(int x, int target) {
        for (int node : graph[x]) {
            if (visited[node]) continue;
            visited[node] = true;
            if (node == target) {
                flag = true;
            }
            dfs(node, target);
        }
    }
}
