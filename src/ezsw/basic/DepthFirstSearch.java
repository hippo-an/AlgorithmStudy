package ezsw.basic;

import java.util.Scanner;
import java.util.Stack;

public class DepthFirstSearch {

    static final int MAX = 10;
    static int n, e;
    static int[][] graph = new int[MAX][MAX];
    // 재귀 호출시 밖으로 빼놓은 이유는 콜스택에 계속 쌓이기 때문에 하나의 콜프레임에 콜스택 쌓이는 양을 줄이기 위해 전역 변수로 설정
    static boolean[] visited = new boolean[MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n  = sc.nextInt();
        e = sc.nextInt();

        for (int i = 0; i < e; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = graph[v][u] = 1;
        }

        dfs(0);
        System.out.println();
        dfs1(0);

    }

    private static void dfs1(int node) {
        visited = new boolean[MAX];

        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if(visited[curr]) continue;

            visited[curr] = true;
            System.out.print(curr + " ");

            for (int next = 0; next < n; next++) {
                if (!visited[next] && graph[curr][next] != 0) {
                    stack.push(next);
                }

            }
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int next = 0; next < n; ++next) {
            if (!visited[next] && graph[node][next] != 0) {
                dfs(next);
            }
        }
    }
}
