package newstep.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2Tiling_11726_Silver3 {

    private static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dy = new int[1000 + 1];
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3;i <= 1000; i++) {
            dy[i] = (dy[i - 1] + dy[i - 2]) % 10007;
        }

        System.out.println(dy[N]);
    }
}
