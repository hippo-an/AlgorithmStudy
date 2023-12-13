package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximizeGap_10819_2 {
    private static int n;
    private static int[] arr;
    private static int[] selected;
    private static boolean[] visited;
    private static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n];
        selected = new int[n];

        dfs(0);
        System.out.println(ans);

        br.close();
    }

    private static void dfs(int k) {
        if (k == n) {
            int sum = getSum();
            ans = Math.max(sum, ans);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[k] = arr[i];
                dfs(k + 1);
                selected[k] = 0;
                visited[i] = false;
            }
        }
    }

    private static int getSum() {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += Math.abs(selected[i - 1]- selected[i]);
        }
        return sum;
    }
}
