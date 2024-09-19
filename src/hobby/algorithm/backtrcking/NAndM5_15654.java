package hobby.algorithm.backtrcking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NAndM5_15654 {
    static int n, m;
    static int[] arr;
    static int[] ans;
    static boolean[] selected;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 4];
        selected = new boolean[n + 4];
        ans = new int[m + 4];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 1, n + 1);

        resolve(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void resolve(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!selected[i]) {
                selected[i] = true;
                ans[k] = arr[i];
                resolve(k + 1);
                ans[k] = 0;
                selected[i] = false;
            }
        }
    }
}
