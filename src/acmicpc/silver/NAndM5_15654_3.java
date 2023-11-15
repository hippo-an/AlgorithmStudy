package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NAndM5_15654_3 {
    private static int n;
    private static int m;
    private static int[] arr;
    private static int[] ans;
    private static boolean[] selected;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        ans = new int[m];
        selected = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        find(0);
        System.out.println(sb);

        br.close();
    }

    private static void find(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (selected[i]) {
                continue;
            }

            ans[k] = arr[i];
            selected[i] = true;
            find(k + 1);
            ans[k] = 0;
            selected[i] = false;
        }
    }
}
