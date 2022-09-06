package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IslandCount_4963 {

    private static int w, h;
    private static int[][] arr;
    private static boolean[][] visited;
    private static final int[][] dir = {{1, 0}, {1, 1}, {1, -1}, {0, 1}, {0, -1}, {-1, 0}, {-1, 1}, {-1, -1}};

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while (w != 0 && h != 0) {
            arr = new int[h + 1][w + 1];
            visited = new boolean[h + 1][w + 1];

            for (int i = 1 ; i <= h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j= 1 ; j <= w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 1 ; i <= h; i++) {
                for (int j= 1 ; j <= w; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        cnt ++;
                        dfs(i, j);
                    }
                }
            }

            sb.append(cnt).append("\n");

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int[] direction : dir) {
            int nx = direction[0] + x;
            int ny = direction[1] + y;

            if (nx < 1 || ny < 1 || nx > h || ny > w) continue;
            if (visited[nx][ny]) continue;
            if (arr[nx][ny] == 0) continue;
            dfs(nx, ny);
        }
    }
}
