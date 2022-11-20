package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tile2N2_11727_Silver3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dy = new int[1001];

        dy[1] = 1;
        dy[2] = 3;

        for (int i = 3; i <= 1000; i++) {
            dy[i] = ((2 * dy[i - 2]) + dy[i - 1]) % 10007;
        }

        System.out.println(dy[n]);
    }
}
