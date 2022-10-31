package newstep.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Add1233_15988_Silver2 {
    private static long[] dy;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dy = new long[1000000 + 1];
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        for (int i = 4; i <= 1000000; i++) {
            dy[i] = (dy[i - 1] + dy[i - 2] + dy[i - 3]) % 1000000009;
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            sb.append(dy[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);

    }
}
