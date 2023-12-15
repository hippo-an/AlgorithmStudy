package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuyCards2_16194_2 {
    private static int n;
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = arr[i];

            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i], arr[j] + dp[i - j]);
            }
        }

        System.out.println(dp[n]);

        br.close();
    }
}
