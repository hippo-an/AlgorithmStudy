package inflearn.ch07_recursive_tree_graph;

/**
 * 그래프 최단거리(BFS)
 * 다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.
 * 1 2 5
 * 3 4 6
 * ▣ 입력설명
 * 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
 * 결정보가 주어진다.
 * ▣ 출력설명
 * 1번 정점에서 각 정점으로 가는 최소 간선수를 2번 정점부터 차례대로 출력하세요.
 * ▣ 입력예제 1
 * 6 9
 * 1 3
 * 1 4
 * 2 1
 * 2 5
 * 3 4
 * 4 5
 * 4 6
 * 6 2
 * 6 5
 * ▣ 출력예제 1
 * 2 : 3
 * 3 : 1
 * 4 : 1
 * 5 : 2
 * 6 : 2
 */

import java.util.*;

public class TheShortestGraphRoute_BFS {

    static List<ArrayList<Integer>> g;
    static int n, m, answer = 0;
    static int[] dist, ch;

    public static void main(String[] args) {
        TheShortestGraphRoute_BFS main = new TheShortestGraphRoute_BFS();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        g = new ArrayList<>();
        ch = new int[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g.get(a).add(b);
        }

        main.bfs(1);

        for (int i = 2; i < dist.length; i++) {
            System.out.println(i + " : " + dist[i]);
        }
    }

    private void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        ch[v] = 1;
        dist[v] = 0;

        q.offer(v);

        while (!q.isEmpty()) {
            int cv = q.poll();

            for (int nv : g.get(cv)) {
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    q.offer(nv);
                    dist[nv] = dist[cv] + 1;
                }
            }
        }
    }
}
