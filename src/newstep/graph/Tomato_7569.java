package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tomato_7569 {

    static int M, N, H;
    static int[][][] tomato;
    static int[][] dir = {{0,0,1}, {0,0,-1}, {1,0,0}, {-1,0,0}, {0,1,0}, {0,-1,0}};
    static int[][][] dist;
    static List<Integer[]> good;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[M][N][H];
        dist = new int[M][N][H];
        good = new ArrayList<>();

        for (int z = 0; z < H; z++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    tomato[j][i][z] = Integer.parseInt(st.nextToken());
                    if (tomato[j][i][z] == 1) good.add(new Integer[]{j, i, z});
                    dist[j][i][z] = -1;
                }
            }
        }

        bfs();

        int ans = Integer.MIN_VALUE;

        outer: for (int z = 0; z < H; z++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tomato[j][i][z] == 0) {
                        ans = -1;
                        break outer;
                    }
                    if (ans < dist[j][i][z]) ans = dist[j][i][z];
                }
            }
        }
        System.out.println(ans);
    }

    private static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        for (Integer[] g : good) {
            Q.add(g[0]);
            Q.add(g[1]);
            Q.add(g[2]);

            dist[g[0]][g[1]][g[2]] = 0;
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            int z = Q.poll();

            for (int i = 0; i < dir.length; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                int nz = z + dir[i][2];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H) continue;
                if (dist[nx][ny][nz] != -1) continue;
                if (tomato[nx][ny][nz] != 0) continue;

                Q.add(nx);
                Q.add(ny);
                Q.add(nz);

                dist[nx][ny][nz] = dist[x][y][z] + 1;
                tomato[nx][ny][nz] = 1;
            }
        }
    }
}
