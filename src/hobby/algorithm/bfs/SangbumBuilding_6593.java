package hobby.algorithm.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SangbumBuilding_6593 {
    static int l, r, c;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) {
                break;
            }


            // (x, y, z) 순서로 저장하자.
            char[][][] board = new char[r][c][l];
            int[][][] distance = new int[r][c][l];
            Queue<Integer> queue = new LinkedList<>();


            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < c; k++) {
                        board[j][k][i] = s.charAt(k);
                        distance[j][k][i] = -1;
                        if (board[j][k][i] == 'S') {
                            queue.offer(j);
                            queue.offer(k);
                            queue.offer(i);

                            distance[j][k][i] = 0;
                        }
                    }
                }
                br.readLine();
            }



            boolean flag = false;
            int ans = 0;
            outer: while(!queue.isEmpty()) {
                int x = queue.poll();
                int y = queue.poll();
                int z = queue.poll();

                for (int i = 0; i < 6; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    int nz = z + dz[i];

                    if (oob(nx, ny, nz)) {
                        continue;
                    }

                    if (board[nx][ny][nz] == 'E') {
                        flag = true;
                        ans = distance[x][y][z] + 1;
                        break outer;
                    }


                    if (board[nx][ny][nz] != '.' || distance[nx][ny][nz] != -1) {
                        continue;
                    }

                    queue.offer(nx);
                    queue.offer(ny);
                    queue.offer(nz);
                    distance[nx][ny][nz] = distance[x][y][z] + 1;
                }
            }

            if (flag) {
                sb.append(String.format("Escaped in %d minute(s).", ans));
            } else {
                sb.append("Trapped!");
            }
            sb.append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean oob(int nx, int ny, int nz) {
        return nx < 0 || nx >= r || ny < 0 || ny >= c || nz < 0 || nz >= l;
    }


}
