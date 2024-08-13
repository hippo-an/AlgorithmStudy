package hobby.algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Fire_4179 {
    private static char[][] board;
    private static int[][] fireDist;
    private static int[][] jDist;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        board = new char[r+1][c+1];
        fireDist = new int[r+1][c+1];
        jDist = new int[r+1][c+1];

        for (int i = 1; i <= r; i++) {
            Arrays.fill(fireDist[i], -1);
            Arrays.fill(jDist[i], -1);
        }

        Queue<Integer> fireQueue = new LinkedList<>();
        Queue<Integer> jQueue = new LinkedList<>();

        for (int i = 1; i <= r; i++) {
            String s = br.readLine();
            for (int j = 1; j <= c; j++) {
                board[i][j] = s.charAt(j - 1);

                if (board[i][j] == 'F') {
                    fireQueue.add(i);
                    fireQueue.add(j);
                    fireDist[i][j] = 0;
                } else if (board[i][j] == 'J') {
                    jQueue.add(i);
                    jQueue.add(j);
                    jDist[i][j] = 0;
                }
            }
        }

        while(!fireQueue.isEmpty()) {
            int x = fireQueue.poll();
            int y = fireQueue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 1 || ny < 1 || nx > r || ny > c) continue;

                if (board[nx][ny] == '#') continue;
                if (fireDist[nx][ny] != -1) continue;

                fireQueue.add(nx);
                fireQueue.add(ny);
                fireDist[nx][ny] = fireDist[x][y] + 1;
            }
        }

        while(!jQueue.isEmpty()) {
            int x = jQueue.poll();
            int y = jQueue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 1 || ny < 1 || nx > r || ny > c) {
                    System.out.println(jDist[x][y] + 1);
                    return;
                }

                if (board[nx][ny] == '#') continue;
                if (fireDist[nx][ny] != -1 &&
                        fireDist[nx][ny] <= jDist[x][y] + 1) continue;
                if (jDist[nx][ny] != -1) continue;

                jQueue.add(nx);
                jQueue.add(ny);
                jDist[nx][ny] = jDist[x][y] + 1;
            }
        }


        System.out.println("IMPOSSIBLE");

    }
}
