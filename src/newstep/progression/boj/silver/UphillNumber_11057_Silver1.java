package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UphillNumber_11057_Silver1 {
    private final static long MOD = 10007L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dy = new long[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            dy[1][i] = 1;
        }

        // dy 배열의 정의를 y 로 끝나는 x 번째 자리에 올 수 있는 수의 갯수로 정의해보자.
        for (int x = 2; x <= N; x++) {
            // y 로 끝나는 수 마다
            for (int y = 0; y<= 9; y++) {
                // 앞선 자리수보다 작거나 같은 숫자가 올 수 있다.
                // 예를들어 x = 2 이고 y = 6이라면  x - 1 의 0 ~ 6까지의 합이 될 것이다.
                for (int z = 0; z <= y; z++) {
                    dy[x][y] += dy[x - 1][z] % MOD;
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
