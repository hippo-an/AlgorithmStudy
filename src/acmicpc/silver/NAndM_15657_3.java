package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NAndM_15657_3 {
    private static int n, m;
    private static int[] arr;
    private static int[] ans;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        ans = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        find(0, 0);
        System.out.println(sb);
        br.close();
    }

    private static void find(int k, int prev) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] < prev) {
                continue;
            }
            ans[k] = arr[i];
            find(k + 1, arr[i]);
            ans[k] = 0;
        }

    }
}
