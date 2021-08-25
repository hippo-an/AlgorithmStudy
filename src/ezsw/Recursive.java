package ezsw;


import java.util.Scanner;

/**
 * 자기 자신을 호출하는 함수
 * base case
 * >> 간단히 결과를 반환하는 부분
 *
 * recursive case
 * >> 자기 자신을 호출하는 부분
 */
public class Recursive {

    static int n;
    static int[][] board = new int[100][100];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int sr, sc;
        sr = scanner.nextInt();
        sc = scanner.nextInt();

        fill(sr, sc);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fill(int r, int c) {
        if (r < 0 || r > n - 1 || c < 0 || c > n - 1) return;
        if(board[r][c] != 0) return;
        board[r][c] = 1;
        fill(r - 1, c);
        fill(r + 1, c);
        fill(r, c - 1);
        fill(r, c + 1);
    }

    static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}
