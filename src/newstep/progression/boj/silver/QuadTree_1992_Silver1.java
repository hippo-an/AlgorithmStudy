package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuadTree_1992_Silver1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] photo = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                photo[i][j] = s.charAt(j - 1) - '0';
            }
        }

        StringBuilder sb = new StringBuilder();
        partition(1, 1, N, photo, sb);

        System.out.println(sb);
        br.close();
    }

    private static void partition(int x, int y, int n, int[][] photo, StringBuilder sb) {

        if (check(x, y, n, photo)) {
            sb.append(photo[x][y]);
            return;
        }

        int newN = n / 2;

        sb.append("(");
        partition(x, y, newN, photo, sb);
        partition(x, y + newN, newN, photo, sb);
        partition(x + newN, y, newN, photo, sb);
        partition(x + newN, y + newN, newN, photo, sb);
        sb.append(")");
    }

    private static boolean check(int x, int y, int n, int[][] photo) {
        int base = photo[x][y];
        for (int i = x; i < n + x; i++) {
            for (int j = y; j < n + y; j++) {
                if (photo[i][j] != base) {
                    return false;
                }
            }
        }
        return true;
    }

}
