package newstep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class NnM_15663 {
    private static int N, M;
    private static int[] arr, used, ans;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();

        Arrays.sort(arr, 1, N + 1);

        recursiveFunction(1);
        System.out.println(sb.toString());
    }

    private static void recursiveFunction(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(ans[i]).append(" ");
            sb.append("\n");
        } else {
            int last = 0;
            for (int i = 1; i <= N; i++) {
                if (used[i] == 1) continue;
                if (arr[i] == last) continue;

                last = arr[i];
                ans[k] = arr[i];
                used[i] = 1;
                recursiveFunction(k + 1);
                ans[k] = 0;
                used[i] = 0;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        used = new int[N + 1];
        ans = new int[M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
