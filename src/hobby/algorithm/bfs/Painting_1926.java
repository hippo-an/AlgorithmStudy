package hobby.algorithm.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Painting_1926 {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int count = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    count++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i);
                    queue.offer(j);
                    visited[i][j] = true;
                    int val = 1;
                    while (!queue.isEmpty()) {
                        int x = queue.poll();
                        int y = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx < 1 || ny < 1 || nx > n || ny > m) continue;

                            if (visited[nx][ny] || board[nx][ny] != 1) continue;

                            queue.offer(nx);
                            queue.offer(ny);
                            visited[nx][ny] = true;
                            val++;
                        }

                    }

                    if (val > max) {
                        max = val;
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(count + "\n");
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
