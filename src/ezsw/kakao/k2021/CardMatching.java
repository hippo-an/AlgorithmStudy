package ezsw.kakao.k2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CardMatching {


    public static void main(String[] args) {

    }

    int[][] b;
    private static final int INF = 987654321;
    static final int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    class Point {
        int row, col, cnt;
        public Point(int r, int c, int t) {
            this.row = r;
            this.col = c;
            this.cnt = t;
        }
    }
    public int solution(int[][] board, int r, int c) {
        b = board;

        // 선택 순서가 결과에 영향을 줌 - 순열
        return permute(new Point(r, c, 0));
    }

    private int permute(Point src) {
        int ret = INF;
        for (int num = 1; num <= 6; num++) {
            List<Point> card = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (b[i][j] == num) {
                        card.add(new Point(i, j, 0));
                    }
                }
            }

            if(card.isEmpty()) continue;

            int one = bfs(src, card.get(0)) +
                    bfs(card.get(0), card.get(1)) + 2;

            int two = bfs(src, card.get(1)) +
                    bfs(card.get(1), card.get(0)) + 2;

            for (int i = 0; i < 2; i++) {
                b[card.get(i).row][card.get(i).col] = 0;
            }

            ret = Math.min(ret, one + permute(card.get(1)));
            ret = Math.min(ret, two + permute(card.get(0)));

            for (int i = 0; i < 2; i++) {
                b[card.get(i).row][card.get(i).col] = num;
            }
        }

        if(ret == INF) return 0;
        return ret;
    }

    private int bfs(Point src, Point dst) {
        boolean[][] visited = new boolean[4][4];

        Queue<Point> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            Point curr = q.poll();
            if (curr.row == dst.row && curr.col == dst.col) {
                return curr.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.row + d[i][0], nc = curr.col + d[i][1];

                if(nr < 0 || nr > 3 || nc < 0 || nc > 3) continue;

                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, curr.cnt + 1));
                }

                for (int j = 0; j < 2; j++) {
                    if(b[nr][nc] != 0) break;
                    if(nr + d[i][0] < 0 || nr + d[i][0] > 3 || nc + d[i][1] < 0 || nc + d[i][1] > 3) break;
                    nr += d[i][0];
                    nc += d[i][1];
                }

                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, curr.cnt + 1));
                }
            }
        }
        return INF;
    }

}
