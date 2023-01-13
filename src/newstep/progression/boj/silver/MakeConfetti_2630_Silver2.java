package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeConfetti_2630_Silver2 {

    private static int white = 0;
    private static int blue = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(1, 1, n, board);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void partition(int r, int c, int n, int[][] board) {
        if (check(r, c, n, board)) {
            if (board[r][c] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = n / 2;
        partition(r, c, newSize, board);
        partition(r, c + newSize, newSize, board);
        partition(r + newSize, c, newSize, board);
        partition(r + newSize, c + newSize, newSize, board);

    }

    private static boolean check(int r, int c, int n, int[][] board) {
        int color = board[r][c];

        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }


}
