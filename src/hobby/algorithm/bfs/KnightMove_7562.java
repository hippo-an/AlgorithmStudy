package hobby.algorithm.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KnightMove_7562 {

    private static int[][] dirs = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        outer: while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            int[][] arr = new int[l+5][l+5];
            boolean[][] visitied = new boolean[l+5][l+5];
            Queue<Integer> queue = new LinkedList<>();

            queue.add(x);
            queue.add(y);
            queue.add(0);
            visitied[x][y] = true;

            while (!queue.isEmpty()) {
                int curX = queue.poll();
                int curY = queue.poll();
                int curLen = queue.poll();

                if (curX == targetX && curY == targetY) {
                    bw.write(curLen + "\n");
                    continue outer;
                }

                for (int[] dir : dirs) {
                    int nx = curX + dir[0];
                    int ny = curY + dir[1];

                    if (nx < 0 || ny < 0 || nx >= l || ny >= l) {
                        continue;
                    }

                    if (visitied[nx][ny]) {
                        continue;
                    }

                    if (nx == targetX && ny == targetY) {
                        bw.write(curLen + 1 + "\n");
                        continue outer;
                    }

                    queue.add(nx);
                    queue.add(ny);
                    queue.add(curLen + 1);
                    visitied[nx][ny] = true;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
