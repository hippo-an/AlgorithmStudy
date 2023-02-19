package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestEvenSequence_22857_Silver2 {
    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[K + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= N; j++) {
            int element = Integer.parseInt(st.nextToken());
            boolean flag = element % 2 == 0;
            if (flag) {
                dp[0][j] = dp[0][j - 1] + 1;
            }

            for (int i = 1; i <= K; i++) {
                if (flag) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dp[K][i]);
        }
        System.out.println(ans);
        br.close();

    }

}
