package hobby.algorithm.backtrcking;

import java.io.*;
import java.util.StringTokenizer;

public class NAndM1_15649 {
    private static StringBuilder sb = new StringBuilder();
    private static int n, m;
    private static boolean[] used;
    private static int[] selected;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        used = new boolean[n + 1];
        selected = new int[m];

        backTracking(0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backTracking(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                selected[k] = i;
                backTracking(k + 1);
                used[i] = false;
            }
        }
    }
}
