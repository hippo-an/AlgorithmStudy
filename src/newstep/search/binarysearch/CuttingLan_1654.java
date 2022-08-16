package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CuttingLan_1654 {
    private static int K, N;
    private static int[] arr;
    private static long T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        K = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        arr = new int[K + 1];

        for (int i = 1; i <= K; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
            T += x;
        }

        System.out.println(parameterize());
    }

    private static long parameterize() {
        long L = 1;
        long R = T / N, ans = T / N;

        while (L <= R) {
            long mid = (L + R) / 2;

            if (determination(mid)) {
                ans = mid;
                L  = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    private static boolean determination(long mid) {
        long temp = 0;
        for (int i = 1; i <= K; i++) {
            temp += arr[i] / mid;
            if (temp > N) return true;
        }
        return temp >= N;
    }
}
