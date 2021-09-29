package ezsw.basic;

import java.util.Scanner;

public class ArrayCross {

    static int row, col, sr, sc;
    static int[][] board = new int[100][100];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        sr = scanner.nextInt();
        sc = scanner.nextInt();

        cross();

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void cross() {
        if (board[sr][sc] != 0) return;
        board[sr][sc] = 1;

        for (int i = sr - 1; i >= 0; --i) {
            if(board[i][sc] != 0) break;
            board[i][sc] = 1;
        }

        for (int i = sr + 1; i < row; ++i) {
            if(board[i][sc] != 0) break;
            board[i][sc] = 1;
        }

        for (int i = sc - 1; i >= 0; --i) {
            if(board[sr][i] != 0) break;
            board[sr][i] = 1;
        }

        for (int i = sc + 1; i < col; ++i) {
            if(board[sr][i] != 0) break;
            board[sr][i] = 1;
        }
    }
}
