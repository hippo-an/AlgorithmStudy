package newstep.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci5_10870_Bronze2 {
    private static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dy = new int[20 + 1];
        dy[1] = 1;

        for (int i = 2; i <= 20; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }

        System.out.println(dy[N]);
    }
}
