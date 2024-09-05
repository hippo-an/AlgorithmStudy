package hobby.algorithm.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SafeArea_2468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        for (int i = 0; i <= 100; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];
            int safeCount = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (arr[x][y] > i && !visited[x][y]) {
                        queue.add(x);
                        queue.add(y);
                        visited[x][y] = true;
                        safeCount++;

                        while(!queue.isEmpty()) {
                            int a = queue.poll();
                            int b = queue.poll();

                            for (int k = 0; k < 4; k++) {
                                int nx = a + dx[k];
                                int ny = b + dy[k];

                                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                    continue;
                                }

                                if (arr[nx][ny] <= i || visited[nx][ny]) {
                                    continue;
                                }

                                queue.add(nx);
                                queue.add(ny);
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            ans = Math.max(ans, safeCount);
        }

        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
