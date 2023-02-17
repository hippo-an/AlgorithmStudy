package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Acrobatics_21923_Gold4 {
    private static int N;
    private static int M;
    private static long[][] graph;
    private static long[][] upDp;
    private static long[][] downDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new long[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
            }
        }

        upstream();
        downstream();

        long ans = upDp[1][1] + downDp[1][1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                ans = Math.max(ans, upDp[i][j] + downDp[i][j]);
            }
        }

        System.out.println(ans);
    }

    private static void upstream() {
        upDp = new long[N + 1][M + 1];

        for (int i = 1; i <= M; i++) {
            upDp[N][i] = graph[N][i] + upDp[N][i - 1];
        }

        upDp[N][1] = graph[N][1];
        for (int i = N - 1; i >= 1; i--) {
            upDp[i][1] = graph[i][1] + upDp[i + 1][1];
        }

        for (int i = N - 1; i >= 1; i--) {
            for (int j = 2; j <= M; j++) {
                upDp[i][j] = Math.max(upDp[i][j - 1], upDp[i + 1][j]) + graph[i][j];
            }
        }
    }

    private static void downstream() {
        downDp = new long[N + 1][M + 1];

        downDp[N][M] = graph[N][M];
        for (int i = M - 1; i >= 1; i--) {
            downDp[N][i] = graph[N][i] + downDp[N][i + 1];
        }

        for (int i = N - 1; i >= 1; i--) {
            downDp[i][M] = graph[i][M] + downDp[i + 1][M];
        }

        for (int i = N - 1; i >= 1; i--) {
            for (int j = M - 1; j >= 1; j--) {
                downDp[i][j] = Math.max(downDp[i][j + 1], downDp[i + 1][j]) + graph[i][j];
            }
        }
    }

}
