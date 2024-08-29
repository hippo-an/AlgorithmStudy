package hobby.algorithm.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Fire_5427 {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            char[][] map = new char[r + 5][c + 5];
            int[][] visited = new int[r + 5][c + 5];
            int[][] fire = new int[r + 5][c + 5];
            Queue<Integer> sQ = new LinkedList<>();
            Queue<Integer> fQ = new LinkedList<>();

            for (int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    visited[i][j] = -1;
                    fire[i][j] = -1;
                }
            }

            for (int i = 0; i < r; i++) {
                String s = br.readLine();
                for (int j = 0; j < s.length(); j++) {
                    char chr = s.charAt(j);
                    map[i][j] = chr;

                    if (chr == '@') {
                        visited[i][j] = 0;
                        sQ.add(i);
                        sQ.add(j);
                    } else if (chr == '*') {
                        fire[i][j] = 0;
                        fQ.add(i);
                        fQ.add(j);
                    }
                }
            }

            while (!fQ.isEmpty()) {
                int x = fQ.poll();
                int y = fQ.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        continue;
                    }

                    if(fire[nx][ny] != -1 || map[nx][ny] == '#') {
                        continue;
                    }

                    fire[nx][ny] = fire[x][y] + 1;
                    fQ.add(nx);
                    fQ.add(ny);
                }
            }

            int min = Integer.MAX_VALUE;
            outer: while (!sQ.isEmpty()) {
                int x = sQ.poll();
                int y = sQ.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        min = Math.min(min, visited[x][y] + 1);
                        break outer;
                    }

                    if(visited[nx][ny] != -1 || map[nx][ny] == '#') {
                        continue;
                    }

                    if (fire[nx][ny] != -1 && fire[nx][ny] <= visited[x][y] + 1) {
                        continue;
                    }

                    visited[nx][ny] = visited[x][y] + 1;
                    sQ.add(nx);
                    sQ.add(ny);
                }
            }

            if (min == Integer.MAX_VALUE) {
                bw.write("IMPOSSIBLE\n");
            } else {
                bw.write(min + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
