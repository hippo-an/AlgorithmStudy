package inflearn.ch08_DFS_BFS;
/**
 *
 */

import java.util.*;

public class TheShortestMazePath {
    static int[][] b;
    int[][] d = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };

    public static void main(String[] args) {
        TheShortestMazePath main = new TheShortestMazePath();
        Scanner sc = new Scanner(System.in);

        b = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        System.out.println(main.bfs(new Point(1, 1, 0)));

    }

    private int bfs(Point point) {
        boolean[][] v = new boolean[8][8];
        v[1][1] = true;
        Queue<Point> q = new LinkedList<>();
        q.offer(point);

        while (!q.isEmpty()) {
            Point curr = q.poll();

            if(curr.r == 7 && curr.c == 7 ) return curr.d;

            for(int i = 0; i < d.length; i++) {
                int nr = curr.r + d[i][0], nc = curr.c + d[i][1];
                if(nr < 1 || nr > 7 || nc < 1 || nc > 7) continue;
                if(v[nr][nc]) continue;
                if(b[nr][nc] == 1) continue;
                v[nr][nc] = true;
                q.offer(new Point(nr, nc, curr.d + 1));
            }
        }

        return -1;
    }

    static class Point {
        int c;
        int r;
        int d;
        public Point(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
