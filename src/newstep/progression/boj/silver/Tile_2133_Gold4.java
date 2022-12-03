package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tile_2133_Gold4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dy = new long[30 + 1];
        dy[2] = 3;

        for (int i = 4; i <= N; i += 2) {
            dy[i] = 3 * dy[i - 2];

            for (int k = i - 4; k >= 1; k--) {
                dy[i] += dy[k] * 2;
            }

            // 항상 새롭게 나오는 2가지의 예외 케이스
            dy[i] += 2;
        }

        System.out.println(dy[N]);
    }
}
