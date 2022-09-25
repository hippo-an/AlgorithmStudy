package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WiseKnight_18404 {
    private static int N, M, kx, ky;
    private static int[][] chess;
    private static int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        kx = Integer.parseInt(st.nextToken());
        ky = Integer.parseInt(st.nextToken());

        chess = new int[N + 1][N + 1];

        bfs();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            sb.append(chess[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]);
            sb.append(" ");
        }

        System.out.println(sb);
    }

    private static void bfs() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                chess[i][j] = -1;
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        Q.add(kx);
        Q.add(ky);
        chess[kx][ky] = 0;


        while (!Q.isEmpty()) {

            int x = Q.poll();
            int y = Q.poll();

            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if (chess[nx][ny] != -1) continue;

                Q.add(nx);
                Q.add(ny);

                chess[nx][ny] = chess[x][y] + 1;
            }
        }
    }
}
