package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze_2178 {
    private static int N, M;
    private static int[][] graph, dist;
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                graph[i][j] = (int) s.charAt(j - 1) - '0';
                dist[i][j] = -1;
            }
        }

        bfs(1, 1);

        System.out.println(dist[N][M]);
    }

    private static void bfs(int sx, int sy) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sx);
        Q.add(sy);
        dist[sx][sy] = 1;

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for (int i = 0; i < dir.length; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (dist[nx][ny] != -1) continue;
                if (graph[nx][ny] == 0) continue;

                Q.add(nx);
                Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }

        }
    }
}
