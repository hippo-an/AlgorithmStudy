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

        int R = 10_000, ans = R;

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

        int temp = mid;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (temp - arr[i] > 0) {
                temp -= arr[i];
            } else if (temp == 0) {
                temp = mid;
                cnt++;
            } else {
                cnt++;
                temp = mid - arr[i];
            }

        }
        return cnt < M;
    }
}
