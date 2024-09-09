package hobby.algorithm.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class FindRoute_11403 {
    private static int[][] result;
    private static boolean[] visited;
    private static List<List<Integer>> graph;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val > 0) {
                    graph.get(i).add(j);
                }
            }
        }

        result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited = new boolean[n];
                recursion(i, i, j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    private static void recursion(int origin,int from, int to) {
        for (Integer x : graph.get(from)) {
            if (visited[x]) {
                continue;
            }

            if (x == to) {
                result[origin][to] = 1;
                return;
            }
            visited[x] = true;
            recursion(origin, x, to);
        }
    }


    private static void dfs( int from, int to) {

        Stack<Integer> stack = new Stack<>();
        stack.push(from);

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (Integer x : graph.get(cur)) {
                if (visited[x]) {
                    continue;
                }
                if (x == to) {
                    result[from][to] = 1;
                    return;
                }
                visited[x] = true;
                stack.push(x);
            }
        }
    }
}
