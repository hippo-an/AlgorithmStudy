package newstep.progression.codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        int[][] dir = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        int[] ans = new int[2];

        int rA = 0;
        int cA = 0;

        int rB = 0;
        int cB = 0;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 2) {
                    rA = i;
                    cA = j;
                    ans[0]++;
                } else if (arr[i][j] == 3) {
                    rB = i;
                    cB = j;
                    ans[1]++;
                }
            }
        }



        Queue<Integer> q = new LinkedList<>();
        q.add(rA);
        q.add(cA);
        q.add(0);

        q.add(rB);
        q.add(cB);
        q.add(1);

        boolean[][] visited = new boolean[n + 1][n + 1];
        visited[rA][cA] = true;
        visited[rB][cB] = true;

        while (!q.isEmpty()) {
            int r = q.poll();
            int c = q.poll();
            int idx = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr < 1 || nr > n || nc < 1 || nc > n) {
                    continue;
                }

                if (arr[nr][nc] == 0) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                q.add(nr);
                q.add(nc);
                q.add(idx);
                ans[idx]++;
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
        br.close();

    }

}
