package ezsw.basic2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {

    static final int max = 10;
    static final int n = 6;
    static final int e = 9;
    static int[] dist = new int[max];
    static final int INF = 987654321;
    static int[][] graph = new int[max][max];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }

        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();

            graph[u][v] = graph[v][u] = cost;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(dijkstra(0, i));
        }
    }

    private static int dijkstra(int src, int dst) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        boolean[] visited = new boolean[max];
        for (int i = 0; i <n; i++) {
            dist[i] = INF;
        }

        dist[src] = 0;
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1];
            if(u == dst) return curr[0];
            if(visited[u]) continue;

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if(dist[v] > dist[u] + graph[u][v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        return INF;
    }

    static void dijkstra1(int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        boolean[] visited = new boolean[max];

        for (int i = 0; i < n; i++) {
            dist[i] = INF;
        }

        dist[src] = 0;
        pq.add(new int[] {0, src});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1];

            if(visited[u]) continue;

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (dist[v] > dist[u] + graph[u][v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

    }
}
