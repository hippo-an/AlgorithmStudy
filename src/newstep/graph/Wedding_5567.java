package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Wedding_5567 {

    private static int N, M;
    private static List<Integer>[] graph;
    private static int[] dist;

    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = -1;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }


        bfs(1);

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= 2 && dist[i] > 0) cnt++;
        }

        System.out.println(cnt);
    }

    private static void bfs(int start) {

        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        dist[start] = 0;

        while(!Q.isEmpty()) {
            int x = Q.poll();

            for (int nx : graph[x]) {
                if (dist[nx] != -1) continue;
                Q.add(nx);
                dist[nx] = dist[x] + 1;
            }
        }
    }
}
