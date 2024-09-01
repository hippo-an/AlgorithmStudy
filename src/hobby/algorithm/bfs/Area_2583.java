package hobby.algorithm.bfs;

import java.io.*;
import java.util.*;

public class Area_2583 {
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int ldy = Integer.parseInt(st.nextToken());
            int ldx = Integer.parseInt(st.nextToken());
            int rty = Integer.parseInt(st.nextToken());
            int rtx = Integer.parseInt(st.nextToken());

            for (int r = ldx; r < rtx; r++) {
                for (int c = ldy; c < rty; c++) {
                    arr[r][c] = true;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int numOfArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!arr[i][j] ) {
                    numOfArea++;
                    q.offer(i);
                    q.offer(j);
                    arr[i][j] = true;
                    int count = 1;
                    while (!q.isEmpty()) {
                        int x = q.poll();
                        int y = q.poll();

                        for (k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                            if (arr[nx][ny]) continue;

                            count++;
                            arr[nx][ny] = true;
                            q.offer(nx);
                            q.offer(ny);
                        }
                    }
                    res.add(count);
                }
            }
        }

        res.sort((o1, o2) -> o1 - o2);

        StringBuilder sb = new StringBuilder();
        sb.append(numOfArea);
        sb.append("\n");
        for (Integer e : res) {
            sb.append(e)
                    .append(" ");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
