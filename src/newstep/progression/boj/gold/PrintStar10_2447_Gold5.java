package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrintStar10_2447_Gold5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        char[][] stars = new char[n + 1][n + 1];

        divide(1, 1, n, stars, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();

    }

    private static void divide(int x, int y, int n, char[][] stars, boolean blank) {
        if (blank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    stars[i][j] = ' ';
                }
            }
            return;
        }

        if (n == 1) {
            stars[x][y] = '*';
            return;
        }

        int size = n / 3;
        int cnt = 0;
        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                cnt++;
                divide(i, j, size, stars, cnt == 5);
            }
        }
    }

}
