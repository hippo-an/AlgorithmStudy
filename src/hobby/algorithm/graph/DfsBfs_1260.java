package hobby.algorithm.graph;

import java.io.*;
import java.util.*;

public class DfsBfs_1260 {

    private static boolean[] visited;
    private static List<List<Integer>> graph;
    private static BufferedWriter bw;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[n + 1];
        dfs(v);
        bw.write("\n");
        bfs(v);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int s) throws IOException {
        visited[s] = true;
        bw.write(s + " ");

        for (int v : graph.get(s)) {
            if (visited[v]) {
                continue;
            }

            dfs(v);
        }
    }

    private static void bfs(int s) throws IOException {
        visited = new boolean[n + 1];
        Queue<Integer> stack = new LinkedList<>();
        stack.offer(s);
        visited[s] = true;

        while (!stack.isEmpty()) {
            int cur = stack.poll();
            bw.write(cur + " ");

            for (Integer x : graph.get(cur)) {
                if (visited[x]) {
                    continue;
                }
                stack.offer(x);
                visited[x] = true;
            }
        }

    }
}
