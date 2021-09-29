package ezsw.basic;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
    /**
     * - 최단 경로
     * >> - 그래프에서 두 정점 사이의 경로들 중에서 간선의 가중치의 합이 최소인 경로
     */

    // 모든 정점까지 거리 구하기
    static final int INF = 987654321;
    static final int MAX = 10;
    static int n, e;
    static int[][] graph = new int[MAX][MAX];  // 좌표 값을 나타내는 2차원 배열
    static int[] dist = new int[MAX];  // 노드에 대한 가격을 저장하는 (최소 가격) 배열

    // 경로가 필요한 경우 추가
    static int[] prev = new int[MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) graph[i][j] = 0;
                else       graph[i][j] = INF;
            }
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
            graph[u][v] = graph[v][u] = cost;  // 방향성이 없기 때문에 양방향 저장
        }

        // 모든 정점까지 거리 구하기
        dijkstra(0);
        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }

        System.out.println();
        // 경로가 필요한 경우
        dijkstra1(0);
        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }
        int curr = 5;
        while (curr != -1) {
            System.out.print(curr + " < ");
            curr = prev[curr];
        }

        // 특정 도착점까지 거리 구하기
        for (int i = 0; i < n; i++) {
            System.out.println(dijkstra2(0, i));
        }
    }

    private static int dijkstra2(int src, int dst) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        boolean[] visited = new boolean[MAX];

        for (int i = 0; i < n; i++) {
            dist[i] = INF;
        }
        dist[src] = 0;
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1];
            if(u == dst) return curr[0];  // 현재 노드의 위치가 도착하는 위치와 일치하는 경우 visited 에 마킹 전에 그냥 return 시킴
            if(visited[u]) continue;

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (dist[v] > dist[u] + graph[u][v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new int[] {dist[v], v});
                }
            }
        }

        return INF;
    }

    private static void dijkstra1(int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        boolean[] visited = new boolean[MAX];

        for (int i = 0; i < n; i++) {
            prev[i] = -1;
            dist[i] = INF;
        }

        dist[src] = 0;
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1];

            if(visited[u]) continue;

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (dist[v] > dist[u] + graph[u][v]) {
                    prev[v] = u;
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new int[]{dist[v], v});
                }
            }
        }
    }

    private static void dijkstra(int src) {
        // 두값을 비교할때 첫번째 인덱스로 비교를 하라는 comparator 를 설정해 줌
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // 첫번째 값은 정점까지 가는 최단 비용, 두번째 인덱스는 정점의 번호

        boolean[] visited = new boolean[MAX];
        for (int i = 0; i < n; i++) dist[i] = INF;

        dist[src] = 0;
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1];  // 정점의 번호

            if(visited[u]) continue;  // 해당 정점을 방문한 적이 있는 경우

            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (dist[v] > dist[u] + graph[u][v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new int[] {dist[v], v});
                }
            }
        }
    }
}
