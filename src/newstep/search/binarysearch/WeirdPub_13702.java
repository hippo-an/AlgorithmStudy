package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WeirdPub_13702 {

    private static int N, K;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        long L = 0, R = Integer.MAX_VALUE, ans = 0;

        while (L <= R && (L + R) / 2 != 0) {
            long mid = (L + R) / 2;
            if (determination(mid)) {
                L= mid + 1;
                ans = mid;
            } else {
                R = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean determination(long mid) {
        long cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += (arr[i] / mid);
        }
        return cnt >= K;
    }
}
