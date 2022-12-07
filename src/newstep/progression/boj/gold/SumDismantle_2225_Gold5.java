package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumDismantle_2225_Gold5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dy = new long[200 + 1][200 + 1];

        for (int i = 0; i <= N; i++) {
            dy[i][1] = 1;
            dy[i][2] = i + 1;
        }

        for (int k = 1; k <= K; k++) {
            dy[0][k] = 1;
        }

        for (int n = 1; n <= N; n++) {
            for (int k = 3; k <= K; k++) {
                for (int from = k; from >= 0; from--) {
                    dy[n][k] += dy[n - 1][from] % 1000000000;
                }
            }
        }

        System.out.println(dy[N][K] % 1000000000);
    }
}
