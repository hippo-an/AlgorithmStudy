package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순서가 존재하며
// n 개 중 m 개의 수를 고르는 문제 => nPm
public class NAndM1_15649_3 {

    private static int n;
    private static int m;
    private static int[] ans;
    private static boolean[] selected;

    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = new int[m + 1];
        selected = new boolean[n + 1];

        // nCm
        find(1);
        System.out.println(sb);
        br.close();
    }

    private static void find(int k) {
        if (k == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (selected[i]) {
                continue;
            }
            ans[k] = i;
            selected[i] = true;
            find(k + 1);
            ans[k] = 0;
            selected[i] = false;
        }
    }
}
