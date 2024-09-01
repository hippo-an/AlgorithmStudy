package hobby.algorithm.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakTheWall_2206 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int n, m;
    private static int[][] board;
    // 0 - no broken wall
    // 1 - broken wall
    private static int[][][] dist;
    // 1차원 배열로 해결할 수 없는 이유는 다음 반례를 통해 확인해보자.
    // 6 5
    //01000
    //00010
    //11110
    //00000
    //11111
    //11110

    // (3,4) 에 도착해서 벽을 뚫고 가는게 유일한 방법이다.
    // 다만, 1차원 배열로 dist 를 계산하는 경우, (0,1) 의 벽을 뚫고 (3,4) 에 먼저 도착한다.
    // 벽을 뚫지 않고 오는 방법이 더 늦게 도착하는 경우, 방문처리가 이미 되어있기 때문에
    // 검증할 수 있는 방법이 없다.
    // 그렇기 때문에 뚫고 올때와 뚫고 오지 않을때를 구분해서 저장해야 한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[1005][1005];
        dist = new int[1005][1005][2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        int count = bfs();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        dist[0][0][0] = 1;
        dist[0][0][1] = 1;

        queue.add(0);
        queue.add(0);
        queue.add(0);  // is wall broken?

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            int broken = queue.poll();

            if (x == n - 1 && y == m - 1) {
                return dist[x][y][broken];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 벽이 아닌 곳 && 방문하지 않은곳
                if (board[nx][ny] == 0 && dist[nx][ny][broken] == 0) {
                    dist[nx][ny][broken] = dist[x][y][broken] + 1;
                    queue.add(nx);
                    queue.add(ny);
                    queue.add(broken);
                }

                // 벽을 부수지 않은 상태 && 벽인 곳 && 방문하지 않은 곳
                // 벽을 부수는 경우
                if (broken == 0 && board[nx][ny] == 1 && dist[nx][ny][broken] == 0) {
                    dist[nx][ny][1] = dist[x][y][broken] + 1;
                    queue.add(nx);
                    queue.add(ny);
                    queue.add(1);
                }
            }
        }

        return -1;
    }
}

