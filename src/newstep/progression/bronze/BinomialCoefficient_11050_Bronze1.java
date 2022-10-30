package newstep.progression.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinomialCoefficient_11050_Bronze1 {

    private static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        memo = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            memo[i][0] = 1;
            memo[i][i] = 1;
        }

        for (int i = 1; i <= N ;i++) {
            for (int j = 1; j <= K; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i - 1][j - 1];
            }
        }

        System.out.println(memo[N][K]);
    }
}
