package newstep.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FindParents_11725 {

    private static List<Integer>[] graph;
    private static int[] parents;
    private static int N;

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1, -1);

        for (int i = 2; i <= N; i++) sb.append(parents[i]).append("\n");

        System.out.println(sb);

    }

    private static void dfs(int x, int parent) {
        for (int y : graph[x]) {
            if (y == parent) continue;
            parents[y] = x;
            dfs(y, x);
        }
    }
}
