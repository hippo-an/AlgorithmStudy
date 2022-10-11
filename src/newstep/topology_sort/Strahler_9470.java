package newstep.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Strahler_9470 {

    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int N, E;
    private static int[] indeg, order, maxCnt;
    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(" ");

            N = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            indeg = new int[N + 1];
            order = new int[N + 1];
            maxCnt = new int[N + 1];
            graph = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                indeg[to]++;
            }
            topologicalSort();
        }

        System.out.println(sb);
    }

    private static void topologicalSort() {
        Deque<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                Q.add(i);
                order[i] = maxCnt[i] = 1;
            }
        }

        int ans = 0;
        while (!Q.isEmpty()) {
            Integer x = Q.poll();
            if (maxCnt[x] >= 2) order[x]++;
            ans = Math.max(ans, order[x]);

            for (int y : graph[x]) {
                indeg[y]--;
                if (indeg[y] == 0) Q.add(y);
                if (order[y] == order[x]) maxCnt[y]++;
                else if (order[y] < order[x]) {
                    order[y] = order[x];
                    maxCnt[y] = 1;
                }
            }
        }

        sb.append(ans).append("\n");
    }
}
