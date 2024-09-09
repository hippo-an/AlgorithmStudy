package hobby.algorithm.dp;

import java.io.*;

public class Fibonacci_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        // i,0 -> i 호출 시 0 이 호출되는 횟수
        // i,1 -> i 호출 시 1 이 호출되는 횟수
        int[][] dp = new int[45][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;

        for (int i = 3; i < 45; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            bw.write(dp[x][0] + " " + dp[x][1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
