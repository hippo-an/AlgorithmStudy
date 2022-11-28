package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBStreet_1149_Silver1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] rgb = new int[N + 1][3];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dy = new int[N + 1][3];
        dy[1][0] = rgb[1][0];
        dy[1][1] = rgb[1][1];
        dy[1][2] = rgb[1][2];
        for (int i = 2; i <= N; i++) {
            dy[i][0] = rgb[i][0] + Math.min(dy[i - 1][1], dy[i - 1][2]);
            dy[i][1] = rgb[i][1] + Math.min(dy[i - 1][0], dy[i - 1][2]);
            dy[i][2] = rgb[i][2] + Math.min(dy[i - 1][0], dy[i - 1][1]);
        }

        int min = dy[N][0];
        for (int i = 1; i <= 2; i++) {
            if (dy[N][i] < min) {
                min = dy[N][i];
            }
        }

        System.out.println(min);
    }
}
