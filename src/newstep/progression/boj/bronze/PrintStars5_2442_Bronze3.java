package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStars5_2442_Bronze3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char star = '*';
        char blank = ' ';
        String line = "\n";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i; j++) {
                sb.append(blank);
            }

            for (int t = 1; t <= 2 * i - 1; t++) {
                sb.append(star);
            }
            sb.append(line);
        }

        System.out.println(sb);
        br.close();
    }

}
