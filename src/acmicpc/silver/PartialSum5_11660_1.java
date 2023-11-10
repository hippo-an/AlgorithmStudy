package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 누적합 || dp
// 행 별 누적합을 구한 후 행별로 처리
public class PartialSum5_11660_1 {
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        int[][] sum = new int[N + 1][N + 1];  // 행 별 누적합
        int[][] dp = new int[N + 1][N + 1];  // dp 테이블

        for (int x = 1; x <= N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 1; y <= N; y++) {
                arr[x][y] = Integer.parseInt(st.nextToken());
                sum[x][y] = sum[x][y - 1] + arr[x][y];
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j-1] - dp[i - 1][j - 1] + arr[i][j];
            }
        }



        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 누적합
//            int sumForSub = 0;
//            for (int x = x1; x <= x2; x++) {
//                sumForSub += (sum[x][y2] - sum[x][y1 - 1]);
//            }
//            sb.append(sumForSub)
//                    .append("\n");

            // dp
            int ans = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
            sb.append(ans)
                    .append("\n");
        }

        System.out.println(sb);
    }
}
