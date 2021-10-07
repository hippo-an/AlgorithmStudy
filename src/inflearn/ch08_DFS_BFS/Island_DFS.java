package inflearn.ch08_DFS_BFS;

/**
 * 13. 섬나라 아일랜드
 * 설명
 *
 * N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
 *
 * 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
 *
 * 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
 *
 * Image1.jpg
 *
 * 만약 위와 같다면 섬의 개수는 5개입니다.
 *
 *
 * 입력
 * 첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
 *
 * 두 번째 줄부터 격자판 정보가 주어진다.
 *
 *
 * 출력
 * 첫 번째 줄에 섬의 개수를 출력한다.
 */

import java.util.*;

public class Island_DFS {
    int[][] d = {
            {-1, 0},   // 상
            {-1, 1},   // 우상
            {0, 1},    //우
            {1, 1},    // 우하
            {1, 0},    // 하
            {1, -1},   // 좌하
            {0, -1},   // 좌
            {-1, -1},  // 좌상
    };
    static int[][] b;
    static boolean[][] v;
    Stack<Point> s = new Stack<Point>();
    static int answer = 0, n;

    public static void main(String[] args) {
        Island_DFS main = new Island_DFS();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        b = new int[n][n];
        v = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(b[i][j] == 1) {
                    main.dfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private void dfs(int r, int c) {

        s.push(new Point(r, c));
        b[r][c] = 0;
        v[r][c] = true;


        while (!s.isEmpty()) {
            Point curr = s.pop();

            for(int i = 0; i < d.length; i++) {
                int nr = curr.r + d[i][0];
                int nc = curr.c + d[i][1];

                if(nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1) continue;
                if(b[nr][nc] == 0) continue;
                if(v[nr][nc]) continue;

                b[nr][nc] = 0;
                v[nr][nc] = true;
                s.push(new Point(nr, nc));
            }
        }


    }

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
