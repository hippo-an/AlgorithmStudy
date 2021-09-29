package ezsw.basic2;

import java.util.Scanner;

public class DFS1Recursive {
    static final int max = 10;
    static int n, e;
    static int[][] board = new int[max][max];
    static boolean[] visited = new boolean[max];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            board[u][v] = board[v][u] = 1;
        }
        dfs(0);
    }

    private static void dfs(int node) {

        visited[node] = true;

        System.out.println(node + " ");

        for (int next = 0; next < n; next++) {
            if (!visited[next] && board[node][next] != 0) {
                dfs(next);
            }
        }
    }
}
