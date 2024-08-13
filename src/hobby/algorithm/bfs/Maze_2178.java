package hobby.algorithm.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze_2178 {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[][] board;
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n + 1][m + 1];
        visited = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String l = br.readLine();
            for (int j = 1; j <= m; j++) {
                board[i][j] = l.charAt(j-1)-'0';
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(1);
        visited[1][1] = 1;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                if (board[nx][ny] == 0 || visited[nx][ny] > 0) continue;

                queue.offer(nx);
                queue.offer(ny);
                visited[nx][ny] = visited[x][y] + 1;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(visited[n][m] + "\n");
        bw.flush();
        bw.close();
        br.close();


    }
}
