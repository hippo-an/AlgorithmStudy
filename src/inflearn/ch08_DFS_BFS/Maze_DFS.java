package inflearn.ch08_DFS_BFS;

/**
 * 10. 미로탐색(DFS)
 * 설명
 *
 * 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
 *
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
 *
 * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
 *
 * Image1.jpg
 *
 * 위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.
 *
 *
 * 입력
 * 7*7 격자판의 정보가 주어집니다.
 *
 *
 * 출력
 * 첫 번째 줄에 경로의 가지수를 출력한다.
 *
 *
 * 예시 입력 1
 *
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 0 0 0 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 0 0 0
 * 예시 출력 1
 *
 * 8
 */

import java.util.*;

public class Maze_DFS {
    int[][] d = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };

    static int[][] b ;
    static int n = 7;
    static int answer=0;

    public static void main(String[] args) {
        Maze_DFS main = new Maze_DFS();
        Scanner sc = new Scanner(System.in);

        b = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        b[1][1] = 1;

        main.dfs(1, 1);

        System.out.println(answer);

    }

    private void dfs(int x, int y) {
        if (x == n && y == n) {
            answer++;
        } else {
            for(int i = 0; i < 4; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];

                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;

                if (b[nx][ny] == 0) {
                    b[nx][ny] = 1;
                    dfs(nx, ny);
                    b[nx][ny] = 0;
                }
            }
        }
    }
}
