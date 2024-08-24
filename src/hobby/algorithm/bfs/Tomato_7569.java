package hobby.algorithm.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato_7569 {
    private static int[] dx = {0, 0, 1, -1, 0, 0};
    private static int[] dy = {1, -1, 0, 0, 0, 0};
    private static int[] dz = {0, 0, 0, 0,  1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] board = new int[n + 5][m + 5][h + 5];
        int[][][] dist = new int[n + 5][m + 5][h + 5];
        Queue<Integer> queue = new LinkedList<>();

        for (int z = 0; z < h; z++) {
            for (int x = 0; x < n; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < m; y++) {
                    board[x][y][z] = Integer.parseInt(st.nextToken());
                    if (board[x][y][z] == 1) {
                        queue.add(x);
                        queue.add(y);
                        queue.add(z);
                    } else if (board[x][y][z] == 0) {
                        dist[x][y][z] = -1;
                    }
                }
            }
        }
        // 0(토마토) 인 경우 -1 로 dist 가 초기화


        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            int z = queue.poll();

            for (int dir = 0; dir < 6; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                int nz = z + dz[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue;
                if (dist[nx][ny][nz] >= 0) continue;
                dist[nx][ny][nz] = dist[x][y][z] + 1;
                queue.offer(nx);
                queue.offer(ny);
                queue.offer(nz);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < h; k++) {
                    if (dist[i][j][k] == -1) {
                        bw.write("-1");
                        bw.flush();
                        bw.close();
                        br.close();
                        return;
                    }

                    ans = Math.max(ans, dist[i][j][k]);
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
