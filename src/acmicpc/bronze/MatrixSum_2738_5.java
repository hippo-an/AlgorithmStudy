package acmicpc.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixSum_2738_5 {

    private static int n, m;
    private static int[][] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2 * n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i % n][j] += Integer.parseInt(st.nextToken());
                if (i >= n) sb.append(a[i % n][j]).append(' ');
            }
            if (i >= n) sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
