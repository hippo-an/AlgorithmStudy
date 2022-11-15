package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOne_1463_Silver3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dy = new int[1000000 + 1];
        dy[2] = 1;
        dy[3] = 1;

        for (int i = 4; i <= 1000000; i++) {
            dy[i] = Math.min(dy[i - 1] + 1, Math.min(i % 2 == 0 ? dy[i / 2] + 1 : Integer.MAX_VALUE, i % 3 == 0 ? dy[i / 3] + 1 : Integer.MAX_VALUE));
        }

        System.out.println(dy[N]);

    }
}
