package ezsw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSShortestPath {
    static final int MAX = 10;
    static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int n;
    static int[][] board = new int[MAX][MAX];

    static class Point {
        int row, col, dist;
        public Point(int r, int c, int d) {
            row = r; col = c; dist = d;
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
        boolean[][] visited = new boolean[MAX][MAX];  // 방문 좌표 확인을 위한 2차원 boolean 배열
        Queue<Point> queue = new LinkedList<>();  // queue 사용을 위한 LinkedList 정의
        visited[sRow][sCol] = true;  // 처음 시작 위치의 좌표를 true 값으로 변경

        queue.add(new Point(sRow, sCol, 0));  // 처음 시작 위치의 좌표와 거리를 0 으로 해서 point 객체를 enqueue 함

        // queue 가 비어있으면 반복문 종료
        while (!queue.isEmpty()) {
            Point curr = queue.remove();  // 선입 선출의 queue 속성에 의해 제일 먼저 enqueue 된 요소 dequeue

            if (curr.row == dRow && curr.col == dCol) {
                return curr.dist;
            }

            for (int i = 0; i < d.length; i++) {
                int nr = curr.row + d[i][0], nc = curr.col + d[i][1];
                if(nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1) continue;
                if(visited[nr][nc]) continue;
                if(board[nr][nc] == 1) continue;
                visited[nr][nc] = true;
                queue.add(new Point(nr, nc, curr.dist + 1));
            }
        }

        return -1;
    }
}
