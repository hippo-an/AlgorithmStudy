package hobby.algorithm.backtrcking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NAndM7_15656 {
    static int n, m;
    static int[] arr;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        selected = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 0, n);

        solve(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void solve(int k) {
        if (m == k) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            selected[k] = arr[i];
            solve(k + 1);
            selected[k] = 0;
        }

    }
}
