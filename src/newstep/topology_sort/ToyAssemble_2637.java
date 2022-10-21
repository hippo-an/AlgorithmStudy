package newstep.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ToyAssemble_2637 {

    static class Info {
        int y, v;
        Info(int y, int v) {
            this.y = y;
            this.v = v;
        }
    }

    private static int N, M;
    private static List<Info>[] graph;
    private static int[] indeg;
    private static int[][] cnt;

    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        indeg = new int[N + 1];
        cnt = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[x].add(new Info(y, v));
            indeg[y]++;
        }

        topologicalSort();
        System.out.println(sb);
    }

    private static void topologicalSort() {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1;i <= N; i++) {
            // 기본 부품
            if (indeg[i] == 0) {
                que.offer(i);
                cnt[i][i] = 1;
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            for (Info info : graph[x]) {
                int y = info.y;
                int v = info.v;

                indeg[y]--;
                for (int i = 1; i <= N; i++) cnt[y][i] += cnt[x][i] * v;

                if (indeg[y] == 0) que.add(y);
            }
        }
        for (int i = 1; i <= N; i++) {
            if (cnt[N][i] != 0) {
                sb.append(i).append(" ").append(cnt[N][i]).append("\n");
            }
        }


    }
}
