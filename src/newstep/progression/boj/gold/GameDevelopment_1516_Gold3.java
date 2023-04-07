package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class GameDevelopment_1516_Gold3 {
    private static int n;
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int[] weights;
    private static int[] result;
    private static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        weights = new int[n + 1];
        inDegree = new int[n + 1];
        result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            weights[i] = weight;
            while (st.hasMoreTokens()) {
                int edge = Integer.parseInt(st.nextToken());
                if (edge == -1) {
                    break;
                }

                graph.get(edge).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                result[i] = weights[i];
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            List<Integer> edges = graph.get(now);

            for (int edge : edges) {
                result[edge] = Math.max(result[edge], result[now] + weights[edge]);
                inDegree[edge]--;
                if (inDegree[edge] == 0) {
                    q.offer(edge);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
