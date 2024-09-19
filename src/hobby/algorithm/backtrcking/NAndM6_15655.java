package hobby.algorithm.backtrcking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NAndM6_15655 {
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
        arr = new int[n + 3];
        selected = new int[m + 3];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 1, n + 1);

        solve(0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void solve(int k, int prev) {
        if (m == k) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]);
                sb.append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = prev + 1; i <= n; i++) {
            if (arr[i] == arr[prev]) {
                continue;
            }

            selected[k] = arr[i];
            solve(k + 1, i);
            selected[k] = 0;
        }
    }
}
