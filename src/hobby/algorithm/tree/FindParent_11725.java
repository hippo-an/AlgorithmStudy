package hobby.algorithm.tree;

import java.io.*;
import java.util.*;

public class FindParent_11725 {
    private static List<List<Integer>> graph;
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);
        StringBuilder sb = new StringBuilder();

        for (int i = 2;i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int v) {
        for (Integer next : graph.get(v)) {
            if (parent[v] == next) {
                continue;
            }
            parent[next] = v;
            dfs(next);
        }
    }

    private static void stackDfs(int root) {
        Stack<Integer> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            int cur = s.pop();

            for (Integer next : graph.get(cur)) {
                if (parent[cur] == next) {
                    continue;
                }

                s.push(next);
                parent[next] = cur;
            }
        }
    }

    private static void bfs(int root) {
        Queue<Integer> s = new LinkedList<>();
        s.offer(root);

        while (!s.isEmpty()) {
            int cur = s.poll();

            for (Integer next : graph.get(cur)) {
                if (parent[cur] == next) {
                    continue;
                }

                s.offer(next);
                parent[next] = cur;
            }
        }
    }
}
