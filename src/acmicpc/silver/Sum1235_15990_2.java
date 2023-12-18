package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum1235_15990_2 {

    private static long[][] dp = new long[100001][3];
    private static int mod = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = dp[3][1] = dp[3][2] = 1;

        for (int i = 4; i < dp.length; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % mod;
            dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % mod;
            dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % mod;
        }


        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long sum = dp[n][0] + dp[n][1] + dp[n][2];
            sb.append(sum % mod)
                    .append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
