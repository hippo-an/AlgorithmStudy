package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TravelingSalesmanProblem2_10971_2 {

    private static int n;
    private static int[][] map;
    private static boolean[] visited;

    private static int cnt = 0;
    private static int start;
    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            start = i;
            travel(0, 0, start);
        }

        System.out.println(ans);

        br.close();
    }

    private static void travel(int k, int sum, int from) {
        if (k == n & from == start) {
            ans = Math.min(ans, sum);
            return;
        }


        for (int j = 0; j < n; j++) {
            if (from == j) {
                continue;
            }

            if (cnt < n - 1 && j == start) {
                continue;
            }

            if (!visited[j]& map[from][j] != 0) {
                visited[j] = true;
                cnt++;
                travel(k + 1, sum + map[from][j], j);
                cnt--;
                visited[j] = false;
            }
        }
    }
}
