package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zoo_1309_1 {

    private static int n;
    private static final long MOD = 9901L;

    // dp[n][0] => n번째 우리에 한마리의 사자도 배치하지 않는 경우
    // dp[n][1] => n번째 우리에 첫번째 칸에 사자를 배치하는 경우
    // dp[n][2] => n번째 우리의 두번째 칸에 사자를 배치하는 경우
    private static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n][3];

        dp[0][0] = dp[0][1] = dp[0][2] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        long sum = dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2];
        System.out.println(sum % MOD);

        br.close();
    }
}
