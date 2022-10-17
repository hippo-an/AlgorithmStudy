package newstep.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task_2056 {

    private static int N, ans = Integer.MIN_VALUE;
    private static int[] indeg, build, done;
    private static List<Integer>[] graph;

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        indeg = new int[N + 1];
        build = new int[N + 1];
        done = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            build[i] = Integer.parseInt(st.nextToken());
            int loop = Integer.parseInt(st.nextToken());

            while (loop-- > 0) {
                int pre = Integer.parseInt(st.nextToken());
                graph[pre].add(i);
                indeg[i]++;
            }
        }

        topologicalSort();
        System.out.println(ans);
    }

    private static void topologicalSort() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1;i <= N; i++) if (indeg[i] == 0) {que.add(i); done[i] = build[i];}

        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y : graph[x]) {
                indeg[y]--;
                if (indeg[y] == 0) que.add(y);
                done[y] = Math.max(done[y], done[x] + build[y]);
            }
        }

        for (int i = 1; i <= N; i++) ans = Math.max(ans, done[i]);
    }
}
