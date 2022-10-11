package newstep.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NodeDistance_1240 {

    private static StringTokenizer st;
    private static final StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static List<Info>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int deg = Integer.parseInt(st.nextToken());

            graph[x].add(new Info(y, deg));
            graph[y].add(new Info(x, deg));
        }


        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            search(from, from, to, 0);
        }
        System.out.println(sb);
    }

    private static void search(int x, int prev, int to, int deg) {
        if (x == to) sb.append(deg).append("\n");
        else {
            for (Info info : graph[x]) {
                if (info.child == prev) continue;
                search(info.child, x, to, info.deg + deg);
            }
        }
    }

    static class Info{
        int child;
        int deg;

        public Info(int child, int deg) {
            this.child = child;
            this.deg = deg;
        }
    }
}
