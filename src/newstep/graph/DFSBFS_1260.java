package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSBFS_1260 {

    private static int N, M, V;
    private static List<Integer>[] graph;
    private static boolean[] selected;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        selected = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        selected = new boolean[N + 1];
        bfs(V);

        System.out.println(sb.toString());

    }


    private static void dfs (int x) {
        selected[x] = true;

        sb.append(x).append(' ');

        for (int y : graph[x]) {
            if (selected[y]) continue;
            dfs(y);
        }
    }


    private static void bfs (int x) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        selected[x] = true;


        while(!que.isEmpty()) {

            x = que.poll();
            sb.append(x).append(' ');

            for (int y : graph[x]) {
                if (selected[y]) continue;
                que.add(y);
                selected[y] = true;
            }

        }
    }
}
