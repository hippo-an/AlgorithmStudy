package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lab_14502 {

    private static int N, M, E;
    private static StringTokenizer st;
    private static int[][] map, blank;
    private static boolean[][] visited;
    private static int ans = Integer.MIN_VALUE;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        blank = new int[N * M + 1][2];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 빈칸의 좌표를 기록하기 위한 배열
                if (map[i][j] == 0) {
                    E++;
                    blank[E][0] = i;
                    blank[E][1] = j;
                }
            }
        }

        recursiveFunction(1, 0);
        System.out.println(ans);
    }

    private static void recursiveFunction(int idx, int k) {
        if (k == 3) {
            // 3개의 빈칸에 벽을 설치 후 dfs 를 통한 안전 지역 확인
            bfs();
            return;
        }

        if (idx > E) return;

        map[blank[idx][0]][blank[idx][1]] = 1;
        recursiveFunction(idx + 1, k + 1);
        map[blank[idx][0]][blank[idx][1]] = 0;
        recursiveFunction(idx + 1, k);

    }

    private static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1 ; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visited[i][j] = false;
                if (map[i][j] == 2) {
                    Q.add(i);
                    Q.add(j);
                    visited[i][j] = true;
                }
            }
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 0) {
                    Q.add(nx);
                    Q.add(ny);
                    visited[nx][ny] = true;
                }
            }
        }

        int temp = 0;
        for (int i = 1 ; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    temp++;
                }
            }
        }
        ans = Math.max(temp, ans);

    }
}
