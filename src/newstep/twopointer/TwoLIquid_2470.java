package newstep.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoLIquid_2470 {
    private static int N;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 1, N + 1);

        int v1 = 0, v2 = 0;
        int L = 1;
        int R = N;
        int temp = Integer.MAX_VALUE;

        while (L  < R) {
            int t = arr[L] + arr[R];
            if (temp > Math.abs(arr[L] + arr[R])) {
                temp = Math.abs(arr[L] + arr[R]);
                v1 = arr[L];
                v2 = arr[R];
            }

            if (arr[L] + arr[R] > 0) R--;
            else L++;
        }

        System.out.printf("%d %d", v1, v2);
    }
}
