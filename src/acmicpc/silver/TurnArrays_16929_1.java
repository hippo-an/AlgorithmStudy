package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TurnArrays_16929_1 {

    private static int n, m, r;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 로테이션 횟수에 맞게
        for (int i = 0; i < r; i++) {
            int x1 = 0;
            int y1 = 0;
            int x2 = n - 1;
            int y2 = m - 1;

            while (x2 - x1 >= 1 && y2 - y1 >= 1) {
                turn(x1++, x2--, y1++, y2--);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j])
                        .append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static void turn(int x1, int x2, int y1, int y2) {
        int temp = arr[x1][y1];

        for (int i = y1 + 1; i <= y2; i++) {
            arr[x1][i - 1] = arr[x1][i];
        }

        for (int i = x1 + 1; i <= x2; i++) {
            arr[i - 1][y2] = arr[i][y2];
        }

        for (int i = y2-1; i >= y1; i--) {
            arr[x2][i + 1] = arr[x2][i];
        }

        for (int i = x2 - 1; i >= x1; i--) {
            arr[i + 1][y1] = arr[i][y1];
        }

        arr[x1 + 1][y1] = temp;
    }
}