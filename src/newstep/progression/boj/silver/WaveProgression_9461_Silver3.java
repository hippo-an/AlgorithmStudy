package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaveProgression_9461_Silver3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        long[] dy = new long[101];
        dy[1] = dy[2] = dy[3] = 1;

        for (int i = 4; i <= 100; i++) {
            dy[i] = dy[i - 2] + dy[i - 3];
        }
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dy[n]).append("\n");

        }

        System.out.println(sb);
    }
}
