package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BipartiteGraph_1707_Gold4 {

    private static boolean answerFlag;
    private static int[] check;
    private static List<Integer>[] graph;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new List[V + 1];
            check = new int[V + 1];
            answerFlag = true;

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
                check[i] = 0;
            }

            for (int i = 1; i <= E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            for (int i = 1; i <= V; i++) {
                if (!answerFlag) {
                    break;
                }

                if (check[i] == 0) {
                    dfs(i, 1);
                }
            }

            sb.append(answerFlag ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs (int vertex) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(vertex);
        check[vertex] = 1;

        while (!que.isEmpty()) {

            Integer x = que.poll();

            for (Integer v : graph[x]) {

                if (check[v] == 0) {
                    check[v] = -check[x];
                    que.offer(v);
                } else if (check[x] + check[v] != 0) {
                    answerFlag = false;
                    return;
                }
            }
        }
    }

    private static void dfs (int vertex, int c) {

        if (!answerFlag) {
            return ;
        }

        check[vertex] = c;

        for (int v : graph[vertex]) {
            if (check[v] == 0) {
                dfs(v, -check[vertex]);
            }

            if (check[vertex] + check[v] != 0) {
                answerFlag = false;
                return;
            }
        }
    }
}
