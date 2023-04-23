package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Escape_3055_Gold4 {

    // 비버 - D  => 100
    // 물 - *  => -100
    // 돌 - X  => -1
    // 고슴도치 - S  => 1
    // 비어있는 곳 - .  => 0

    private static int r, c;
    private static int[][] map;
    private static int[][] distWater;
    private static int[][] distHedge;
    private static boolean[][] visited;
    private static final int[][] dir = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r + 1][c + 1];
        distWater = new int[r + 1][c + 1];
        distHedge = new int[r + 1][c + 1];
        visited = new boolean[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            String line = br.readLine();
            for (int j = 1; j <= c; j++) {
                char read = line.charAt(j - 1);
                if (read == 'D') {
                    map[i][j] = 100;
                } else if (read == '*') {
                    map[i][j] = -100;
                } else if (read == 'X') {
                    map[i][j] = -1;
                } else if (read == 'S') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        bfsWater();
        bfsHedge();

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (map[i][j] == 100) {
                    if (distHedge[i][j] == -1) {
                        System.out.println("KAKTUS");
                    } else {
                        System.out.println(distHedge[i][j]);
                    }
                    break;
                }
            }
        }

        br.close();
    }

    private static void bfsHedge() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                visited[i][j] = false;
                distHedge[i][j] = -1;

                if (map[i][j] == 1) {
                    q.offer(i);
                    q.offer(j);
                    visited[i][j] = true;
                    distHedge[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Integer x = q.poll();
            Integer y = q.poll();

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 1 || ny < 1 || nx > r || ny > c) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (distHedge[nx][ny] != -1) {
                    continue;
                }

                if (map[nx][ny] < 0) {
                    continue;
                }

                if (distWater[nx][ny] != -1 && distWater[nx][ny] <= distHedge[x][y] + 1) {
                    continue;
                }


                q.offer(nx);
                q.offer(ny);
                distHedge[nx][ny] = distHedge[x][y] + 1;
                visited[nx][ny] = true;
            }
        }
    }

    private static void bfsWater() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                visited[i][j] = false;
                distWater[i][j] = -1;

                if (map[i][j] == -100) {
                    q.offer(i);
                    q.offer(j);
                    visited[i][j] = true;
                    distWater[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Integer x = q.poll();
            Integer y = q.poll();

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 1 || ny < 1 || nx > r || ny > c) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (distWater[nx][ny] != -1) {
                    continue;
                }

                if (map[nx][ny] != 0) {
                    continue;
                }

                q.offer(nx);
                q.offer(ny);
                distWater[nx][ny] = distWater[x][y] + 1;
                visited[nx][ny] = true;
            }
        }
    }

}
