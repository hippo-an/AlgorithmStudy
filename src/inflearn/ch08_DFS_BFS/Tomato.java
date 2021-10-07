package inflearn.ch08_DFS_BFS;

/**
 * 12. 토마토(BFS 활용)
 * 설명
 *
 * 현수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
 *
 * 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.
 *
 * Image1.jpg
 *
 * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면,
 *
 * 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
 *
 * 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,
 *
 * 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
 *
 * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
 *
 * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 *
 *
 * 입력
 * 첫 줄에는 상자의 크기를 나타내는 두 정수 M, N이 주어진다. M은 상자의 가로 칸의 수,
 *
 * N 은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M, N ≤ 1,000 이다.
 *
 * 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
 *
 * 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.
 *
 * 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
 *
 * 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 *
 *
 * 출력
 * 여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.
 *
 * 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
 *
 * 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 */

import java.util.*;

public class Tomato {
    static int[][] b;
    static int n, m, answer = 0;
    static boolean[][] v;

    int[][] d = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };

    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) {
        Tomato main = new Tomato();
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        b = new int[n + 1][m + 1];
        v = new boolean[n + 1][m + 1];

        boolean flag = false;


        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                b[i][j] = sc.nextInt();
                if(b[i][j] == 1) {
                    q.offer(new Point(i, j, 0));
                    v[i][j] = true;
                } else if(b[i][j] == 0) flag = true;
            }
        }

        if(!flag) {
            System.out.println(0);
            return;
        }

        main.bfs();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(b[i][j] == 0) flag = false;
            }
        }

        if(!flag) System.out.println(-1);
        else {
            System.out.println(answer);
        }

    }

    private void bfs() {
        while (!q.isEmpty()) {
            Point curr = q.poll();

            for(int i = 0; i < d.length; i++) {
                int nr = curr.r + d[i][0], nc = curr.c + d[i][1];
                if(nr < 1 || nr > n || nc < 1 || nc > m) continue;
                if(v[nr][nc]) continue;
                if(b[nr][nc] == -1 || b[nr][nc] == 1) continue;
                v[nr][nc] = true;
                b[nr][nc] = 1;
                q.offer(new Point(nr, nc, curr.d + 1));
            }
            answer = Math.max(curr.d, answer);
        }

    }

    static class Point {
        int r, c, d;

        Point(int r , int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
