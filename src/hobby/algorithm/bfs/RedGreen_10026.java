package hobby.algorithm.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class RedGreen_10026 {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[105][105];
        char[][] rgArr = new char[105][105];
        boolean[][] visited = new boolean[105][105];
        boolean[][] rgVisited = new boolean[105][105];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);

                if (arr[i][j] == 'R') {
                    rgArr[i][j] = 'G';
                } else {
                    rgArr[i][j] = arr[i][j];
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int rgCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    char cu = arr[i][j];
                    count++;
                    queue.add(i);
                    queue.add(j);
                    visited[i][j] = true;

                    while(!queue.isEmpty()) {
                        int x = queue.poll();
                        int y = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) {
                                continue;
                            }

                            if (arr[nx][ny] != cu) {
                                continue;
                            }

                            visited[nx][ny] = true;
                            queue.add(nx);
                            queue.add(ny);
                        }
                    }
                }

                if (!rgVisited[i][j]) {
                    char cu = rgArr[i][j];
                    rgCount++;
                    queue.add(i);
                    queue.add(j);
                    rgVisited[i][j] = true;

                    while(!queue.isEmpty()) {
                        int x = queue.poll();
                        int y = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= n || rgVisited[nx][ny]) {
                                continue;
                            }

                            if (rgArr[nx][ny] != cu) {
                                continue;
                            }

                            rgVisited[nx][ny] = true;
                            queue.add(nx);
                            queue.add(ny);
                        }
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(count + " " + rgCount );
        bw.flush();
        bw.close();
        br.close();
    }
}
