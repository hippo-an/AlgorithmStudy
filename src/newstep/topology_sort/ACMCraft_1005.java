package newstep.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ACMCraft_1005 {
    private static int N, K, W;
    private static int[] build, indeg, done;
    private static List<Integer>[] graph;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            build = new int[N + 1];
            indeg = new int[N + 1];
            done = new int[N + 1];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
            for (int i = 1; i <= N; i++) build[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                indeg[y]++;
            }

            W = Integer.parseInt(br.readLine());

            topologicalSort();
            sb.append(done[W]).append("\n");
        }

        System.out.println(sb);
    }

    private static void topologicalSort() {
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                Q.add(i);
                done[i] = build[i];
            }
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (int y : graph[x]){
                indeg[y]--;
                if (indeg[y] == 0) Q.add(y);
                done[y] = Math.max(done[y], done[x] + build[y]);
            }
        }

    }
}
