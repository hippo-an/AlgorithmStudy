package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinaryNumber_2193_Silver3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dy = new long[N + 1][2];
        dy[1][0] = 0;
        dy[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            dy[i][0] = dy[i - 1][0] + dy[i - 1][1];
            dy[i][1] = dy[i - 1][0];
        }

        System.out.println(dy[N][0] + dy[N][1]);
    }
}
