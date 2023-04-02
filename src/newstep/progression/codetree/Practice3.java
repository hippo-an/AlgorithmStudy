package newstep.progression.codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice3 {

    private static int n;
    private static int[][] graph;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int initial = graph[n][1];
        dp = new int[n + 1];
        int[][] dir = {{1, 0}, {0, -1}};

        dp[1] = initial;
        int idx = 1;

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                int max = dp[idx];
                for (int k = 0; k < 2; k++) {
                    int x = i + dir[k][0];
                    int y = j + dir[k][1];
                    if (x >= 1 && x <= n && y >= 1 && y <= n) {
                        max = Math.max(max, dp[x] + graph[x][y]);
                    }
                }
                dp[i] = max;
            }
        }
        System.out.println(dp[n]);
        br.close();
    }

}
