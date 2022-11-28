package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker_9465_Silver1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n + 1];
            int[][] dy = new int[3][n + 1];

            for (int k = 0; k <= 1; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= n; i++) {
                    sticker[k][i] = Integer.parseInt(st.nextToken());
                }
            }

            dy[0][1] = sticker[0][1];
            dy[1][1] = sticker[1][1];

            for (int i = 2; i <= n; i++) {
                dy[0][i] = Math.max(dy[2][i - 1], dy[1][i - 1]) + sticker[0][i];
                dy[1][i] = Math.max(dy[2][i - 1], dy[0][i - 1]) + sticker[1][i];
                dy[2][i] = Math.max(dy[0][i - 1], Math.max(dy[1][i - 1], dy[2][i - 1]));
            }

            sb.append(Math.max(dy[0][n], Math.max(dy[1][n], dy[2][n])))
                    .append("\n");
        }

        System.out.println(sb);
    }
}
