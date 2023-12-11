package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllPermutation_10974_3 {
    private static int n;
    private static int[] arr;
    private static boolean[] visitied;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visitied = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        find(0, "");
        System.out.println(sb);
        br.close();
    }

    private static void find(int k, String ans) {
        if (k == n) {
            sb.append(ans)
                    .append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visitied[i]) {
                visitied[i] = true;
                find(k + 1, ans + arr[i] + " ");
                visitied[i] = false;
            }
        }

    }

}