package newstep.progression.boj.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class CriticalPath_1948_Platinum5 {

    private static int n, m;
    private static int[] inDegree;
    private static int[] result;
    private static boolean[] visited;
    private static List<List<Integer>> graph;
    private static List<List<Integer>> reverseGraph;
    private static int[][] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        inDegree = new int[n + 1];
        result = new int[n + 1];
        visited = new boolean[n + 1];
        times = new int[n + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            inDegree[to]++;
            times[from][to] = time;
            times[to][from] = time;
            reverseGraph.get(to).add(from);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Integer now = q.poll();
            List<Integer> edges = graph.get(now);

            for (Integer next : edges) {
                result[next] = Math.max(result[next], result[now] + times[now][next]);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        int cnt = 0;
        q.offer(end);
        while (!q.isEmpty()) {
            Integer now = q.poll();
            List<Integer> edges = reverseGraph.get(now);

            for (Integer prev : edges) {
                if (result[prev] + times[prev][now] == result[now]) {
                    cnt++;
                    if (!visited[prev]) {
                        q.offer(prev);
                        visited[prev] = true;
                    }
                }
            }
        }

        System.out.printf("%d\n%d", result[end], cnt);
        br.close();
    }
}
