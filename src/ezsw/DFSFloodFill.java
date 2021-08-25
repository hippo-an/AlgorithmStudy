package ezsw;

import java.util.Scanner;
import java.util.Stack;

public class DFSFloodFill {
    static final int MAX = 10;
    static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int n;
    static int[][] board = new int[MAX][MAX];

    static class Point {
        int row, col;
        public Point(int r, int c) {
            row = r; col = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int sRow, sCol, color;
        sRow = sc.nextInt();
        sCol = sc.nextInt();
        color = sc.nextInt();

        dfs(sRow, sCol, color);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int sRow, int sCol, int color) {
        boolean[][] visited = new boolean[MAX][MAX];
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(sRow, sCol));

        while (!stack.isEmpty()) {
            Point curr = stack.pop();
            if(visited[curr.row][curr.col]) continue;

            visited[curr.row][curr.col] = true;
            board[curr.row][curr.col] = color;
            System.out.println("curr row & col : " + curr.row + ", " + curr.col);

            for (int i = 0; i < d.length; i++) {
                int nr = curr.row + d[i][0];
                int nc = curr.col + d[i][1];

                if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1) continue;
                if(visited[nr][nc]) continue;
                if (board[nr][nc] == 1) continue;
                stack.push(new Point(nr, nc));
            }
        }

    }
}


