package newstep.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PickNumber_2230 {

    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, 1, N + 1);

        int L = 1, R = 2, ans = Integer.MAX_VALUE;

        while (N > 1 && R < N + 1 && L < N + 1) {

            if (Math.abs(arr[L] - arr[R]) >= M) {
                ans = Math.min(ans, Math.abs(arr[L] - arr[R]));
                L++;
            } else R++;
        }

        if (ans == Integer.MAX_VALUE) {
            ans = 1;
        }

        System.out.println(ans);
    }
}
