package newstep.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MusicProgram_2623 {

    private static int N, M;
    private static int[] indeg;
    private static List<Integer>[] graph;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
        indeg = new int[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y ;
            for (int i = 2; i <= cnt ; i++) {
                y = Integer.parseInt(st.nextToken());
                graph[x].add(y);
                indeg[y]++;
                x = y;
            }
        }

        topologySort();

        System.out.println(sb.toString());
    }

    private static void topologySort() {
        Deque<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N; i++) if (indeg[i] == 0) Q.add(i);

        List<Integer> ans = new ArrayList<>();
        while (!Q.isEmpty()) {
            Integer x = Q.poll();
            ans.add(x);
            for (int y : graph[x]) {
                indeg[y]--;
                if (indeg[y] == 0) Q.add(y);
            }
        }

        if (ans.size() != N) sb.append("0").append("\n");
        else {
            for (int x : ans) sb.append(x).append("\n");
        }
    }
}
