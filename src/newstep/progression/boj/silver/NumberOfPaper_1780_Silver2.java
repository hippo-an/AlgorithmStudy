package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfPaper_1780_Silver2 {

    private static int negativeOne = 0;
    private static int zero = 0;
    private static int one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] papers = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(1, 1, n, papers);
        System.out.printf("%d\n%d\n%d\n", negativeOne, zero, one);
    }

    private static void partition(int r, int c, int n, int[][] papers) {

        if (check(r, c, n, papers)) {
            if (papers[r][c] == -1) {
                negativeOne++;
            } else if (papers[r][c] == 0) {
                zero++;
            } else {
                one++;
            }

            return;
        }

        int size = n / 3;

        for (int i = 0; i < n; i += size) {
            for (int j = 0; j < n; j += size) {
                partition(r + i, c + j, size, papers);
            }
        }


    }

    private static boolean check(int r, int c, int n, int[][] papers) {
        int num = papers[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (papers[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }

}
