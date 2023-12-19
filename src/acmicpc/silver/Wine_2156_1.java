package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Wine_2156_1 {
    private static int[] amount;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        amount = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            amount[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[n + 1];
        Arrays.fill(dp, 1, dp.length, -1);

        dp[1] = amount[1];

        if (n > 1) {
            dp[2] = amount[2] + amount[1];
        }

        System.out.println(recursive(n));

        br.close();
    }

    private static int recursive(int n) {
        if (n > 0 & dp[n] == -1) {
            dp[n] = Math.max(Math.max(recursive(n - 3) + amount[n - 1], recursive(n - 2)) + amount[n], recursive(n - 1));
        }
        return dp[n];
    }
}
