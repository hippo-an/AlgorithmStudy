package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BuildBridge_2146_Gold3 {

    private static int N;
    private static int[][] map;
    private static int[][] island;
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        island = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        islandSeparate();
        bridgeBuilder();

        System.out.println(ans);
        br.close();
    }

    private static void bridgeBuilder() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int islandNum = island[i][j];
                if (islandNum != 0) {
                    map = new int[N + 1][N + 1];
                    bfs(i, j, islandNum);
                }
            }
        }
    }

    private static void bfs(int x, int y, int islandNum) {
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{x, y, 1});
        map[x][y] = 1;

        while (!q.isEmpty()) {
            Integer[] point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dir[i][0];
                int ny = point[1] + dir[i][1];

                if (nx < 1 || nx > N || ny < 1 || ny > N) {
                    continue;
                }

                if (island[nx][ny] == islandNum || map[nx][ny] != 0) {
                    continue;
                }
                map[nx][ny] = 1;

                if (island[nx][ny] == 0) {
                    q.offer(new Integer[]{nx, ny, point[2] + 1});
                } else if (island[nx][ny] != islandNum) {
                    ans = Math.min(point[2], ans);
                }
            }
        }
    }

    private static void islandSeparate() {
        int cnt = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1 && island[i][j] == 0) {
                    islandBfs(i, j, cnt);
                    cnt++;
                }
            }
        }
    }

    private static void islandBfs(int x, int y, int cnt) {
        Queue<Integer[]> q = new LinkedList<>();
        island[x][y] = cnt;
        q.offer(new Integer[]{x, y});

        while (!q.isEmpty()) {
            Integer[] point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dir[i][0];
                int ny = point[1] + dir[i][1];

                if (nx < 1 || nx > N || ny < 1 || ny > N) {
                    continue;
                }

                if (map[nx][ny] != 1 || island[nx][ny] != 0) {
                    continue;
                }

                island[nx][ny] = cnt;
                q.offer(new Integer[]{nx, ny});
            }
        }
    }

}
