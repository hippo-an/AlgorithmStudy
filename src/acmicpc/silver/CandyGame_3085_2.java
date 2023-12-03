package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyGame_3085_2 {
    private static int n, ans = 1;
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        gamePlay();
        System.out.println(ans);
        br.close();
    }

    private static void gamePlay() {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (c + 1 < n && board[r][c] != board[r][c + 1]) {
                    swap(r, c, r, c + 1);
                    check();
                    swap(r, c + 1, r, c);
                }

                if (r + 1 < n && board[r][c] != board[r + 1][c]) {
                    swap(r, c, r + 1, c);
                    check();
                    swap(r + 1, c, r, c);
                }
            }
        }
    }

    private static void check() {
        int rCount = 1;
        int cCount = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, rCount);
                ans = Math.max(ans, cCount);

                if (j + 1 == n) {
                    break;
                }
                if (board[i][j] == board[i][j + 1]) {
                    rCount++;
                } else {
                    rCount = 1;
                }

                if (board[j][i] == board[j + 1][i]) {
                    cCount++;
                } else {
                    cCount = 1;
                }
            }
            rCount = 1;
            cCount = 1;
        }
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }
}
