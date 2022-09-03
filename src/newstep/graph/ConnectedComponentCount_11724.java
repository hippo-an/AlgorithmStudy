package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConnectedComponentCount_11724 {

    private static int N, M;
    private static List<Integer>[] graph;
    private static boolean[] visitied;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        visitied = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (!visitied[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    private static void dfs(int x) {
        visitied[x] = true;

        for (int n : graph[x]) {
            if (!visitied[n])dfs(n);
        }
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        visitied[n] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            for (Integer x : graph[node]) {
                queue.poll();
                visitied[x] = true;
            }
        }
    }
}
