package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Paint_1926_1 {

    private static int[][] board;
    private static boolean[][] visited;
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        int totalCount = 0;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    queue.offer(i);
                    queue.offer(j);
                    visited[i][j] = true;
                    totalCount++;

                    int count = 0;

                    while (!queue.isEmpty()) {
                        int x = queue.poll();
                        int y = queue.poll();
                        count++;

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dir[d][0];
                            int ny = y + dir[d][1];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                                continue;
                            }

                            if (visited[nx][ny] || board[nx][ny] != 1) {
                                continue;
                            }

                            queue.offer(nx);
                            queue.offer(ny);
                            visited[nx][ny] = true;
                            count++;
                        }
                    }

                    maxCount = Math.max(maxCount, count);
                }
            }
        }

        System.out.println(totalCount);
        System.out.println(maxCount);

        br.close();
    }
}
