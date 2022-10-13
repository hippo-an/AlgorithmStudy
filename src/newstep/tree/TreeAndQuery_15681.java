package newstep.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class TreeAndQuery_15681 {

    private static StringTokenizer st;
    private static final StringBuilder sb = new StringBuilder();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N, R, Q;
    private static List<Integer>[] graph;
    private static int[] leaf;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    private static void process() throws IOException {
        dfs(R, -1);

        for (int i = 1; i <= Q; i++) {
            int idx = Integer.parseInt(br.readLine());
            sb.append(leaf[idx]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int par) {
        if (x != R && graph[x].size() == 1) {
            leaf[x] = 1;
            return;
        }

        for (int y : graph[x]) {
            if (y != par) {
                dfs(y, x);
                leaf[x] += leaf[y];
            }
        }

        leaf[x]++;
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        leaf = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }
    }
}
