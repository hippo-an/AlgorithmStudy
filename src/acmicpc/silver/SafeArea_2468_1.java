package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class SafeArea_2468_1 {

    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int n;
    private static int[][] arr;
    private static boolean[][] sink;
    private static int count;
    private static int ans = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }

        for (int height = 1; height < max; height++) {
            sink = new boolean[n][n];
            count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!sink[i][j] && arr[i][j] > height) {
                        sinkRecursive(i, j, height);
                        count++;
                    }
                }
            }


            ans = Math.max(ans, count);
        }

        System.out.println(ans);

        br.close();
    }

    private static void sinkRecursive(int x, int y, int height) {
        if (!sink[x][y] && arr[x][y] > height) {
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                sink[x][y] = true;
                sinkRecursive(nx, ny, height);
            }
        }
    }
}