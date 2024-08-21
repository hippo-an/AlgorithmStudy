package hobby.algorithm.dp;

import java.io.*;

public class StepUp_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stepsScore = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stepsScore[i] = Integer.parseInt(br.readLine());
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (n == 1) {
            bw.write(String.valueOf(stepsScore[1]));
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        int[][] dp = new int[2][n + 1];
        dp[0][1] = stepsScore[1];
        dp[0][2] = stepsScore[1] + stepsScore[2];
        dp[1][2] = stepsScore[2];


        for (int i = 3; i <= n; i++) {
            dp[0][i] = dp[1][i-1] + stepsScore[i];
            dp[1][i] = Math.max(dp[0][i - 2], dp[1][i - 2]) + stepsScore[i];
        }

        bw.write(String.valueOf(Math.max(dp[1][n], dp[0][n])));
        bw.flush();
        bw.close();
        br.close();
    }
}


// 연속된 세 개의 계단을 밟으면 안되는 조건
// dp[0][i] -> i 번째 1칸을 밟아서 올라온 점수
// dp[1][i] -> i 번째 2칸을 밟아서 올라온 점수
// n 번째의 1칸 -> n - 1 번째의 2칸을 밟은 점수 + 현재 칸의 점수
// n 번째의 2칸 -> n-2 의 1과 n-2 의 2 를 전부 사용 가능하지.
// Math.max(n - 2 의 1, n -2 의 2) + 현재 칸의 점수
// 최대 점수 = Math.max(n 의 1, n 의 2)
