package ezsw.basic2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathBFS {

    static final int max = 10;
    static int[][] d = {{-1, 0}, {1,0}, {0,-1}, {0,1}};
    static int n; // node의 갯수
    static int[][] board = new int[max][max];

    static class Point{
        private int row;
        private int col;
        private int dist;

        public Point(int r, int c, int d) {
            row = r;
            col = c;
            dist = d;

            System.out.println("this is row : " + row + ", col : " + col + ", distance : " + dist);
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

        int sRow, sCol, dRow, dCol;

        sRow = sc.nextInt();
        sCol = sc.nextInt();
        dRow = sc.nextInt();
        dCol = sc.nextInt();

        System.out.println(bfs(sRow, sCol, dRow, dCol));

    }

    private static int bfs(int sRow, int sCol, int dRow, int dCol) {
        boolean[][] visited = new boolean[max][max];

        Queue<Point> queue = new LinkedList<>();
        visited[sRow][sCol] = true;

        queue.add(new Point(sRow, sCol, 0));

        while (!queue.isEmpty()) {
            Point current = queue.remove();

            if (current.row == dRow && current.col == dCol) return current.dist;

            for (int i = 0; i < 4; i++) {
                int nr = current.row + d[i][0];
                int nc = current.col + d[i][1];

                if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1) {
                    continue;
                }

                if (visited[nr][nc]) continue;

                if(board[nr][nc] != 0) continue;

                visited[nr][nc] = true;

                queue.add(new Point(nr, nc, current.dist + 1));
            }
        }
        return -1;
    }
}
