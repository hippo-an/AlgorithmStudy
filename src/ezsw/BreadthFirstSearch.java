package ezsw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {
    static final int MAX_N = 10;  // 문제 조건에 맞춰서 정의
    static int N, E;  // 노드의 갯수, 간선의 갯수
    static int[][] Graph = new int[MAX_N][MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();

        for (int i = 0; i < E; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            Graph[u][v] = Graph[v][u] = 1;
        }

        bfs(0);
    }

    private static void bfs(int node) {
        boolean[] visited = new boolean[MAX_N];
        Queue<Integer> myqueue = new LinkedList<>();
        visited[node] = true;
        myqueue.add(node);

        while (!myqueue.isEmpty()) {
            int curr = myqueue.remove();

            System.out.print(curr + " ");

            for (int next = 0; next < N; ++next) {
                if (!visited[next] && Graph[curr][next] != 0) {
                    visited[next] = true;
                    myqueue.add(next);
                }
            }
        }
    }
}
