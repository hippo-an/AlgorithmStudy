package newstep.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Add123_9095_Silver3 {
    private static int[] dy;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dy = new int[11 + 1];
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        for (int i = 4; i <= 11; i++) {
            dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3];
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            sb.append(dy[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);

    }
}
