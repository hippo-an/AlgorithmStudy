package newstep.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GameDevelopment_1516 {
    private static int N;
    private static int[] indeg, build, done;
    private static List<Integer>[] graph;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        indeg = new int[N + 1];
        build = new int[N + 1];
        done = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();


        for (int i = 1;i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            build[i] = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) break;

                graph[x].add(i);
                indeg[i]++;
            }
        }

        topologicalSort();
        System.out.println(sb);
    }

    private static void topologicalSort() {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1;i <= N; i++) if (indeg[i] == 0) {done[i] = build[i]; que.add(i);}

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y : graph[x]) {
                indeg[y]--;
                if (indeg[y] == 0) que.add(y);
                done[y] = Math.max(done[y], done[x] + build[y]);
            }
        }

        for ( int i = 1;i <= N; i++){
            sb.append(done[i]).append("\n");
        }
    }
}
