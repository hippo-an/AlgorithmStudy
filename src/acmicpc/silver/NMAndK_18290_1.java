package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NMAndK_18290_1 {
    private static int n, m, k;
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int[][] arr;
    private static boolean[][] visited;
    private static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, 0, 0);
        System.out.println(ans);
        br.close();
    }

    // 기억해야 할 점!
    // sum 을 selected 배열을 사용하지 않고 함수의 파라미터로 넘기는 방식
    // x 와 y 의 증가만 이루어지기 때문에 x 의 -1 과 y 의 -1 만 비교

    private static void solve(int count, int x, int y, int sum) {
        if (count == k) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = x; i < n; i++) {
            for (int j = y; j < m; j++) {
                if ((i == 0 || !visited[i - 1][j]) && (j == 0 || !visited[i][j - 1])) {
                    visited[i][j] = true;
                    solve(count + 1, i, j + 1, sum + arr[i][j]);
                    visited[i][j] = false;
                }
            }
            y = 0;
        }
    }
}
