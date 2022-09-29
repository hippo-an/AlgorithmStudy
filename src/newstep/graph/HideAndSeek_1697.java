package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek_1697 {
    private static int N, K;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[100001];
        bfs();
        System.out.println(dist[K]);
    }

    private static void bfs() {
        Arrays.fill(dist, -1);
        Queue<Integer> Q = new LinkedList<>();
        Q.add(N);
        dist[N] = 0;

        while (!Q.isEmpty()) {
            Integer n = Q.poll();

            if (0 <= n - 1 && n - 1 <= 100000 && dist[n - 1] == -1) {
                Q.add(n - 1);
                dist[n - 1] = dist[n] + 1;
            }

            if (0 <= n + 1 && n + 1 <= 100000 && dist[n + 1] == -1) {
                Q.add(n + 1);
                dist[n + 1] = dist[n] + 1;
            }

            if (0 <= n * 2 && n * 2 <= 100000 && dist[n * 2] == -1) {
                Q.add(n * 2);
                dist[n * 2] = dist[n] + 1;
            }
        }
    }
}
