package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FourSquares_17626_Silver3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dy = new int[N + 1];
        dy[1] = 1;

        int min;
        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dy[i - j * j]);
            }

            dy[i] = min + 1;
        }
        System.out.println(dy[N]);

    }
}
