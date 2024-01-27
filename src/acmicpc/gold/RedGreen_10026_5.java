package acmicpc.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// bfs 를 이용하여 영역 숫자 확인
// 색깔별 조건 처리에 주의
public class RedGreen_10026_5 {
    private static int n;
    private static char[][] board;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

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

        int count = 0;
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }

        int rgCount = 0;
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    rgCount++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(count + " " + rgCount);

        br.close();
    }

    private static void bfs(int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        Point point = new Point(i, j);
        queue.offer(point);
        visited[i][j] = true;
        char base = board[i][j];

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (base == 'G') {
                board[current.x][current.y] = 'R';
            }
            for (int k = 0; k < 4; k++) {
                int nx = current.x + dx[k];
                int ny = current.y + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (visited[nx][ny] || base != board[nx][ny]) {
                    continue;
                }

                queue.offer(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
