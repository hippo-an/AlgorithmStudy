package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStars8_2445_Bronze3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char star = '*';
        char blank = ' ';
        String line = "\n";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                sb.append(star);
            }

            for (int j = 1; j <= 2 * (N - i); j++) {
                sb.append(blank);
            }

            for (int j = 1; j <= i; j++) {
                sb.append(star);
            }

            sb.append(line);
        }

        for (int i = N - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                sb.append(star);
            }

            for (int j = 1; j <= 2 * (N - i); j++) {
                sb.append(blank);
            }

            for (int j = 1; j <= i; j++) {
                sb.append(star);
            }

            sb.append(line);
        }

        System.out.println(sb);
        br.close();
    }

}
