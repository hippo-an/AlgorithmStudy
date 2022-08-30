package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class OrganicCabbage_1012 {

    private static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int[][] arr;
    private static boolean[][] visited;
    private static int T, N, M, k;
    private static final List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            visited = new boolean[N][M];


            for (int j = 1 ; j <= k; j++) {
                String[] s = br.readLine().split(" ");
                int x = Integer.parseInt(s[1]);
                int y = Integer.parseInt(s[0]);
                arr[x][y] = 1;
            }

            int sum = 0;

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (arr[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        sum++;
                    }
                }
            }
            ans.add(sum);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : ans) {
            sb.append(integer).append("\n");
        }

        System.out.println(sb.toString());

    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0 ; i < 4; i ++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visited[nx][ny] || arr[nx][ny] != 1) continue;

            dfs(nx, ny);
        }
    }
}
