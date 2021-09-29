package ezsw.basic2;

import java.util.Scanner;

public class Array2Cross {

    static int r, c, sr, sc;
    static int[][] board = new int[100][100];

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        r = scn.nextInt();
        c = scn.nextInt();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = scn.nextInt();
            }
        }

        sr = scn.nextInt();
        sc = scn.nextInt();

        cross();

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void cross() {

        if(board[sr][sc] != 0) return;

        board[sr][sc] = 1;

        for (int i = sr - 1; i >= 0; --i) {
            if(board[i][sc] != 0) break;
            board[i][sc] = 1;
        }
        for (int i = sr + 1; i < r; i++) {
            if(board[i][sc] != 0) break;
            board[i][sc] = 1;
        }

        for (int i = sc - 1; i >= 0; --i) {
            if(board[sr][i] != 0) break;
            board[sr][i] = 1;
        }
        for (int i = sc + 1; i < r; i++) {
            if(board[sr][i] != 0) break;
            board[sr][i] = 1;
        }

    }
}
