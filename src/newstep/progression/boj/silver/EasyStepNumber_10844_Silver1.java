package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyStepNumber_10844_Silver1 {
    final static long MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dy = new long[N + 1][10];

        // 한자리수를 가진 경우는 하나이다.
        for (int i = 1;i <= 9; i++) {
            dy[1][i] = 1;
        }


        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j ++) {
                // j 가 0 인 경우 다음 자릿 수는 반드시 1만 올 수 있다. 두 자리수로 예를 들면 10
                if (j == 0) {
                    dy[i][j] = dy[i - 1][1] % MOD;
                }

                // j 가 9 인 경우 다음 자릿수는 반드시 8 만 올 수 있다. 두 자리수로  예를 들면 89
                else if (j == 9) {
                    dy[i][j] = dy[i - 1][8] % MOD;
                }

                // 그 외의 경우에는 세운 점화식으로 dy 배열을 채워준다.
                else {
                    dy[i][j] = (dy[i - 1][j - 1] + dy[i - 1][j + 1]) % MOD;
                }
            }
        }

        long res = 0L;

        for (int i = 0; i <= 9; i++) {
            res += dy[N][i];
        }

        System.out.println(res % MOD);

    }
}
