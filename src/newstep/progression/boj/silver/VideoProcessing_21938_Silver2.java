package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VideoProcessing_21938_Silver2 {

    private static int N, M, T;
    private static int[][] video;
    private static boolean[][] visited;
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        video = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                video[i][j] = (r + g + b) / 3;
            }
        }

        T = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (video[i][j] >= T && !visited[i][j]) {
                    ans++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(ans);
        br.close();

    }

    private static void dfs(int i, int j) {
        if (i < 1 || i > N || j < 1 || j > M) {
            return;
        }
        if (video[i][j] < T || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nx = i + dir[k][0];
            int ny = j + dir[k][1];
            dfs(nx, ny);
        }

    }
}
