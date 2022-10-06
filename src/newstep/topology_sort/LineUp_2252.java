package newstep.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LineUp_2252 {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static List<Integer>[] graph;
    private static int[] indeg;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        indeg = new int[N + 1];

        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            indeg[y]++;
        }

        topologySort();
        System.out.println(sb.toString());
    }

    private static void topologySort() {
        Deque<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) Q.add(i);
        }

        while(!Q.isEmpty()) {
            Integer x = Q.poll();
            sb.append(x).append(' ');
            for (int y : graph[x]) {
                indeg[y]--;
                if (indeg[y] == 0) Q.add(y);
            }
        }
    }
}
