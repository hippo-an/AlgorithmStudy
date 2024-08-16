package hobby.algorithm.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OrganicCabbage_1012 {
    private static int[][] board;
    private static boolean[][]  visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            board = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 1; i <= k; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            Queue<Integer> queue = new LinkedList<>();
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && board[i][j] == 1) {
                        count++;
                        queue.offer(i);
                        queue.offer(j);
                        visited[i][j] = true;

                        while (!queue.isEmpty()) {
                            int x = queue.poll();
                            int y = queue.poll();

                            for (int w = 0; w < 4; w++) {
                                int nx = x + dx[w];
                                int ny = y + dy[w];

                                if (nx < 0 || ny < 0 || nx >= n || ny >= m ) continue;
                                if (board[nx][ny] == 0) continue;
                                if (visited[nx][ny]) continue;
                                visited[nx][ny] = true;
                                queue.offer(nx);
                                queue.offer(ny);
                            }
                        }
                    }
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
