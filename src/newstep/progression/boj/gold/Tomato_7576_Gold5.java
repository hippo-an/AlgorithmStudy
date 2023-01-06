package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato_7576_Gold5 {

    private static int[][] dir = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    private static int[][] box;
    private static int[][] dist;
    private static int N;
    private static int M;

    private static Queue<Integer[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];

        for (int x = 1; x <= N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 1; y <= M; y++) {
                box[x][y] = Integer.parseInt(st.nextToken());
                if (box[x][y] == 1) {
                    dist[x][y] = 0;
                    q.offer(new Integer[]{x, y});
                } else {
                    dist[x][y] = -1;
                }
            }
        }
        dfs();

        int ans = Integer.MIN_VALUE;
        out: for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= M; y++) {
                if (box[x][y] == 0) {
                    ans = -1;
                    break out;
                }
                if (ans < dist[x][y]) {
                    ans = dist[x][y];
                }
            }
        }

        System.out.println(ans);
        br.close();

    }

    private static void dfs() {
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();

            for (int i = 0; i <= 3; i++) {
                int nx = poll[0] + dir[i][0];
                int ny = poll[1] + dir[i][1];

                if (nx < 1 || nx > N || ny < 1 || ny > M) {
                    continue;
                }

                if (dist[nx][ny] != -1) {
                    continue;
                }

                if (box[nx][ny] != 0) {
                    continue;
                }

                q.offer(new Integer[]{nx, ny});
                dist[nx][ny] = dist[poll[0]][poll[1]] + 1;
                box[nx][ny] = 1;
            }
        }
    }
}
