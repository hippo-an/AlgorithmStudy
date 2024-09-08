package hobby.algorithm.dp;

import java.io.*;

public class Make12_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 백트랙킹을 위한 정보 기록용 테이블 추가
        // dp[0][i] = i 에 도달하기 위한 가장 작은 가지수
        // dp[1][i] = i 에 도달하기 위해 사용한 인덱스 번호
        int[][] dp = new int[2][n + 1];
        dp[0][1] = 0;
        dp[1][1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
            dp[1][i] = i - 1;
            if (i % 2 == 0) {
                int b = dp[0][i / 2] + 1;
                if (b < dp[0][i]) {
                    dp[0][i] = b;
                    dp[1][i] = i / 2;
                }
            }

            if (i % 3 == 0) {
                int b = dp[0][i / 3] + 1;
                if (b < dp[0][i]) {
                    dp[0][i] = b;
                    dp[1][i] = i / 3;
                }
            }
        }

        bw.write(dp[0][n] + "\n");

        StringBuilder sb = new StringBuilder();
        while (n >= 1) {
            sb.append(n);
            sb.append(" ");
            n = dp[1][n];
        }
        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
