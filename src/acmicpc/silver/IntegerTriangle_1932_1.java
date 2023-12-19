package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerTriangle_1932_1 {
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


       int ans = board[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    board[i][j] = board[i - 1][j] + board[i][j];
                } else {
                    board[i][j] = Math.max(board[i - 1][j], board[i - 1][j - 1]) + board[i][j];
                }
                ans = Math.max(ans, board[i][j]);
            }
        }

        System.out.println(ans);

        br.close();
    }
}
