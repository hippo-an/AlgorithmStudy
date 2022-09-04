package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberK_1300 {

    private static int N, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        k = Integer.parseInt(br.readLine());
        long L = 1, R = (long) N * N, ans = 0;
        while (L <= R) {
            long mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(long candidate) {
        // candidate 이하의 숫자가 K개 이상인가?
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += Math.min(N, candidate / i);
        }
        return sum >= k;
    }
}
