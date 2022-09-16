package newstep.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThreeLiquid_2473 {
    private static int N;
    private static int[] arr;
    private static long[] ans = new long[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 1, N + 1);

        long min = Long.MAX_VALUE;
        for (int i = 1; i <= N - 2; i++) {
            int L = i + 1;
            int R = N;
            int std = arr[i];
            while(L < R) {
                long abs = Math.abs((long)arr[L] + arr[R] + std);
                if (abs < min) {
                    min = abs;
                    ans[0] = std;
                    ans[1] = arr[L];
                    ans[2] = arr[R];
                }

                if (arr[L] + arr[R] > -std) R--;
                else L++;
            }
        }

        System.out.printf("%d %d %d", ans[0], ans[1] , ans[2]);

    }
}
