package hobby.algorithm.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class CountConnectedComponent_11724 {

    private static List<List<Integer>> graph;
    private static int n, m;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

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

        visited = new boolean[n + 1];

        dfs();
//        bfsRecursionTraversal();
//        recursiveBfs();
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs() {
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                stack.push(i);
                count++;
                visited[i] = true;

                while(!stack.isEmpty()) {
                    int cur = stack.pop();

                    for (Integer x : graph.get(cur)) {
                        if (visited[x]) {
                            continue;
                        }
                        stack.push(x);
                        visited[x] = true;
                    }
                }


            }
        }
    }

    private static void dfsRecursionTraversal() {
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                stack.push(i);
                count++;

                while(!stack.isEmpty()) {
                    int cur = stack.pop();

                    if (visited[cur]) {
                        continue;
                    }

                    visited[cur] = true;

                    for (Integer x : graph.get(cur)) {
                        stack.push(x);
                    }
                }
            }
        }
    }

    private static void recursiveDfs() {

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                recursive(i);
            }
        }

    }

    private static void recursive(int n) {
        if (visited[n]) {
            return;
        }

        visited[n] = true;

        for (Integer x : graph.get(n)) {
            recursive(x);
        }
    }
}
