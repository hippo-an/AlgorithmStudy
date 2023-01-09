package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStars16_10991_Bronze3 {

    private static final char star = '*';
    private static final char blank = ' ';
    private static final String line = "\n";
    private static int N;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            blankAdder(i);
            startAdder(i);
            lineAdder();
        }

        System.out.println(sb);
        br.close();
    }

    private static void blankAdder(int i) {
        for (int j = 1; j <= N - i; j++) {
            sb.append(blank);
        }
    }

    private static void startAdder(int i) {
        for (int j = 1; j <= 2 * i - 1; j++) {
            sb.append(j % 2 == 0 ? blank : star);
        }
    }

    private static void lineAdder() {
        sb.append(line);
    }
}
