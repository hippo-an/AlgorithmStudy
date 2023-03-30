package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class AssemblyToys_2637_Gold2 {

    private static int N, M;
    private static int[] inDegree;
    private static List<List<Integer>> graph;
    private static int[][] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        inDegree = new int[N + 1];
        cnt = new int[N + 1][N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            List<Integer> element = graph.get(x);
            element.add(y);
            element.add(k);

            inDegree[y]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                cnt[i][i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();

            List<Integer> element = graph.get(x);
            for (int i = 0; i < element.size(); i += 2) {
                int y = element.get(i);
                int k = element.get(i + 1);
                inDegree[y]--;

                for (int j = 1; j <= N; j++) {
                    cnt[y][j] += cnt[x][j] * k;
                }

                if (inDegree[y] == 0) {
                    q.offer(y);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (cnt[N][i] != 0) {
                sb.append(i).append(" ").append(cnt[N][i]).append("\n");
            }
        }
        System.out.println(sb);

        br.close();
    }
}
