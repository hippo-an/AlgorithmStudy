package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class LineUp_2252_Gold3 {
    private static int n, m;
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inDegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            inDegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");
            List<Integer> edges = graph.get(now);
            for (int edge : edges) {
                inDegree[edge]--;
                if (inDegree[edge] == 0) {
                    q.offer(edge);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] != 0) {
                return;
            }
        }

        System.out.println(sb);

        br.close();
    }
}
