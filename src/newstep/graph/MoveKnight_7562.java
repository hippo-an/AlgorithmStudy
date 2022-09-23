package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MoveKnight_7562 {

    private static int N;
    private static int[][] chess;
    private static int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    private static int dX, dY, oX, oY;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            oX = Integer.parseInt(s[0]);
            oY = Integer.parseInt(s[1]);
            s = br.readLine().split(" ");
            dX = Integer.parseInt(s[0]);
            dY = Integer.parseInt(s[1]);
            chess = new int[N][N];
            sb.append(bfs()).append("\n");
        }


        System.out.println(sb);
    }

    private static int bfs() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                chess[i][j] = -1;
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        chess[oX][oY] = 0;
        Q.add(oX);
        Q.add(oY);


        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = x + dir[i][0], ny = y + dir[i][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (chess[nx][ny] != -1) continue;
                Q.add(nx);
                Q.add(ny);
                chess[nx][ny] = chess[x][y] + 1;
            }
        }

        return chess[dX][dY];
    }
}
