package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PocketMoney_6236 {

    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[N + 1];
        int L = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            L = Math.max(arr[i], L);
        }

        int R = 1_000_000_000, ans = R;

        while(L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                R = mid - 1;
            } else L = mid + 1;
        }

        System.out.println(ans);
    }

    private static boolean determination(int mid) {

        int sum = 0;
        int cnt = 1;
        for (int i = 1; i <= N; i++) {
            if (sum + arr[i] > mid) {
                cnt++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }

        }
        return cnt <= M;
    }
}
