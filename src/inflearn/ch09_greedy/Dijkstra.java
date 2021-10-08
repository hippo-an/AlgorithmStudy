package inflearn.ch09_greedy;

/**
 *
 * 다익스트라 알고리즘
 * 아래의 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램을 작성하세요. (경로가 없으면 Impossible를 출력한다)
 *
 * ▣ 입력설명
 * 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
 * 결정보와 거리비용이 주어진다.
 *
 * ▣ 출력설명
 * 1번 정점에서 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요.
 *
 * ▣ 입력예제 1
 * 6 9
 * 1 2 12 // 1번 정점에서 2번정점으로 가는데 12의 비용이 든다.
 * 1 3 4
 * 2 1 2
 * 2 3 5
 * 2 5 5
 * 3 4 5
 * 4 2 2
 * 4 5 5
 * 6 4 5
 *
 * ▣ 출력예제 1
 * 2 : 11
 * 3 : 4
 * 4 : 9
 * 5 : 14
 * 6 : impossible
 */

import java.util.*;

public class Dijkstra {
    static int n, m, inf = Integer.MAX_VALUE;
    // 인접리스트 사용
    static List<ArrayList<Edge>> g;
    static int[] dist;

    public static void main(String[] args) {
        Dijkstra main = new Dijkstra();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        g = new ArrayList<ArrayList<Edge>>();

        for(int i = 0 ; i <= n; i++) {
            g.add(new ArrayList<Edge>());
        }

        dist = new int[n + 1];
        Arrays.fill(dist, inf);

        for (int i = 0; i < m; i++) {
            g.get(sc.nextInt()).add(new Edge(sc.nextInt(), sc.nextInt()));
        }

        main.solution(1);

        for(int i = 2; i <= n; i++) {
            if(dist[i] != inf) System.out.println(i + " : " + dist[i]);
            else System.out.println(i + " : impossible");
        }
    }

    private void solution(int n) {

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Edge(n, 0));
        dist[n] = 0;

        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();

            int nowNode = tmp.node;
            int cost = tmp.cost;

            if (cost > dist[nowNode]) continue;

            for (Edge x : g.get(nowNode)) {
                if(dist[x.node] > cost + x.cost) {
                    dist[x.node] = cost + x.cost;
                    pq.offer(new Edge(x.node, cost + x.cost));
                }
            }
        }

    }

    private static class Edge{
        int node, cost;
        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
